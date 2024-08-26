package com.liligo.contoller;

import java.util.stream.Collectors;

import com.liligo.airport_shuttle.api.ShuttleRideBookingApi;
import com.liligo.airport_shuttle.model.BookShuttleRequest;
import com.liligo.airport_shuttle.model.BookShuttleResponse;
import com.liligo.airport_shuttle.model.BookingDetailResponse;
import com.liligo.airport_shuttle.model.BookingResponse;
import com.liligo.airport_shuttle.model.UpdateBookingRequest;
import com.liligo.airport_shuttle.model.UpdateBookingResponse;
import com.liligo.mapper.BookingMapper;
import com.liligo.service.ShuttleBookingService;
import com.liligo.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookingController implements ShuttleRideBookingApi {

    private final ShuttleBookingService bookingService;
    private final BookingMapper bookingMapper;
    private final ValidationUtil validationUtil;

    @Override
    public ResponseEntity<BookShuttleResponse> bookShuttle(BookShuttleRequest request) {
        validationUtil.validatePhoneNumber(request.getPhoneNumber());
        validationUtil.validateEmail(request.getEmail());

        var bookingId = bookingService.bookShuttleRide(
            request.getShuttleRideId(),
            request.getDepartureTime(),
            request.getName(),
            request.getEmail(),
            request.getPhoneNumber(),
            request.getNumberOfPassengers());

        var response = new BookShuttleResponse()
            .bookingId(bookingId);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Void> cancelBooking(String id) {
        bookingService.deleteBooking(id);

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<BookingResponse> getAllBookings(String userId, Integer limit, Integer offset) {
        var mappedBookings = bookingService.getBookings(userId, limit, offset)
            .stream()
            .map(bookingMapper::map)
            .collect(Collectors.toList());

        var response = new BookingResponse()
            .bookingDetails(mappedBookings);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<BookingDetailResponse> getBookingDetail(String id) {
        var booking = bookingService.getBooking(id);

        var response = new BookingDetailResponse()
            .bookingDetail(bookingMapper.map(booking));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<UpdateBookingResponse> updateBooking(String id, UpdateBookingRequest updateBookingRequest) {
        var entity = bookingService.updateBooking(id, updateBookingRequest);

        var response = new UpdateBookingResponse()
            .bookingDetail(bookingMapper.map(entity));
        return ResponseEntity.ok(response);
    }

}
