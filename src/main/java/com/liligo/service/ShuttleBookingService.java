package com.liligo.service;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import com.liligo.airport_shuttle.model.UpdateBookingRequest;
import com.liligo.entity.ShuttleEntity;
import com.liligo.entity.ShuttleRideBookingEntity;
import com.liligo.entity.ShuttleRideEntity;
import com.liligo.entity.UserEntity;
import com.liligo.exception.NotEnoughAvailableSeatsException;
import com.liligo.exception.NotFoundException;
import com.liligo.exception.NotModifyAbleException;
import com.liligo.repository.ShuttleRepository;
import com.liligo.repository.ShuttleRideBookingRepository;
import com.liligo.repository.ShuttleRideRepository;
import com.liligo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static java.time.temporal.ChronoUnit.HOURS;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShuttleBookingService {

    private final ShuttleRideRepository shuttleRideRepository;
    private final ShuttleRepository shuttleRepository;
    private final ShuttleRideBookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final Clock localClock;

    public List<ShuttleRideBookingEntity> getBookings(String userId, Integer limit, Integer offset) {
        log.debug("Get bookings for user {}", userId);

        var queryLimit = Optional.ofNullable(limit)
            .orElse(Integer.MAX_VALUE);
        var queryOffset = Optional.ofNullable(offset)
            .orElse(0);
        log.debug("Limit {}, offset {}", limit, offset);

        var pageRequest = PageRequest.of(queryOffset, queryLimit,
            Sort.by("shuttleRide.departureDatetime").descending());

        return bookingRepository.findAllByUser_Id(Long.valueOf(userId), pageRequest)
            .getContent();
    }

    public ShuttleRideBookingEntity getBooking(String bookingId) {
        log.debug("Get booking with id {}", bookingId);
        return bookingRepository.findById(Long.valueOf(bookingId))
            .orElseThrow(() -> new NotFoundException("error.airport-shuttle.booking-not-found", bookingId));
    }

    @Transactional
    public void deleteBooking(String id) {
        var booking = getBooking(id);
        checkBookingIsModifyAble(booking);

        log.debug("Deleting booking with id {}...", id);
        bookingRepository.deleteById(booking.getId());
        log.debug("Booking with id {} deleted successfully", id);
    }

    @Transactional
    public ShuttleRideBookingEntity updateBooking(String id, UpdateBookingRequest request) {
        var booking = getBooking(id);
        checkBookingIsModifyAble(booking);

        var passengers = Optional.ofNullable(request.getNumberOfPassengers())
            .orElse((long) booking.getNumberOfPassengers());

        Optional.ofNullable(request.getDepartureDateTime())
            .ifPresent(it -> {
                var ride = shuttleRideRepository.findByDepartureDatetime(it)
                    .orElseThrow(() -> new NotFoundException("error.airport-shuttle.shuttle-not-found-by-departure-date-time",
                        String.valueOf(it)));

                checkAvailableSeats(passengers, ride.getShuttle().getNumberOfSeats());

                // free up seats for the previously booked shuttle
                var seats = booking.getShuttleRide().getShuttle().getNumberOfSeats();
                booking.getShuttleRide().getShuttle().setNumberOfSeats(seats + booking.getNumberOfPassengers());
                shuttleRepository.save(booking.getShuttleRide().getShuttle());

                updateAvailableSeats(ride.getShuttle(), passengers.intValue());
                booking.setShuttleRide(ride);
            });

        Optional.ofNullable(request.getNumberOfPassengers())
            .ifPresent(it -> {
                var shuttle = booking.getShuttleRide().getShuttle();
                if (shuttle.getNumberOfSeats() >= it) {
                    var diff = booking.getNumberOfPassengers() - it;
                    booking.setNumberOfPassengers(it.intValue());
                    var updatedSeatsNumber = shuttle.getNumberOfSeats() + diff;
                    shuttle.setNumberOfSeats((int) updatedSeatsNumber);
                } else {
                    throw new NotEnoughAvailableSeatsException("error.airport-shuttle.not-enough-available-seats");
                }
            });

        return booking;
    }

    private void checkBookingIsModifyAble(ShuttleRideBookingEntity bookingEntity) {
        if (bookingEntity.isCancelled() || HOURS.between(OffsetDateTime.now(localClock), bookingEntity.getShuttleRide().getDepartureDatetime()) <= 48) {
            throw new NotModifyAbleException("error.airport-shuttle.booking-not-modifiable", String.valueOf(bookingEntity.getId()));
        }
    }

    @Transactional
    public Long bookShuttleRide(
        Long id,
        OffsetDateTime departureTime,
        String name,
        String email,
        String phone,
        Long passengerNumber
    ) {
        var shuttleRide = shuttleRideRepository.findByIdAndDepartureDatetime(id, departureTime)
            .orElseThrow(() -> new NotFoundException("error.airport-shuttle.shuttle-ride-not-found", String.valueOf(id)));

        var shuttle = shuttleRepository.findByShuttleRideId(id)
            .orElseThrow(() -> new NotFoundException("error.airport-shuttle.shuttle-not-found-by-id",
                String.valueOf(id)));

        checkAvailableSeats(passengerNumber, shuttle.getNumberOfSeats());

        var booking = createBookingEntity(name, email, phone, shuttleRide, passengerNumber.intValue());
        updateAvailableSeats(shuttle, booking.getNumberOfPassengers());

        return booking.getId();
    }

    private void updateAvailableSeats(ShuttleEntity entity, int numberOfPassengers) {
        var updatedSeats = entity.getNumberOfSeats() - numberOfPassengers;
        log.debug("Updated seats for shuttle {} is {}", entity.getId(), updatedSeats);
        entity.setNumberOfSeats(updatedSeats);
    }

    private void checkAvailableSeats(long passengerNumber, int availableSeats) {
        if (passengerNumber > availableSeats) {
            log.warn("Required passenger number ({}) is more than the available seats ({})", passengerNumber, availableSeats);
            throw new NotEnoughAvailableSeatsException("error.airport-shuttle.not-enough-available-seats");
        }
    }

    private ShuttleRideBookingEntity createBookingEntity(
        String name,
        String email,
        String phone,
        ShuttleRideEntity ride,
        int passengers
    ) {
        var user = getUser(name, email, phone);
        var bookingEntity = ShuttleRideBookingEntity.builder()
            .shuttleRide(ride)
            .numberOfPassengers(passengers)
            .user(user)
            .cancelled(false)
            .build();

        log.debug("Saving booking {} to user {}", bookingEntity, user);
        return bookingRepository.save(bookingEntity);
    }

    private UserEntity getUser(String name, String email, String phone) {
        return userRepository.findByEmailAndPhoneNumber(email, phone)
            .orElseGet(() -> {
                log.debug("Creating new user with email {} and phone number {}", email, phone);
                return userRepository.save(
                    UserEntity.builder()
                        .fullName(name)
                        .email(email)
                        .phoneNumber(phone)
                        .build()
                );
            });
    }

}
