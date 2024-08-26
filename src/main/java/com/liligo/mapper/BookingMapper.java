package com.liligo.mapper;

import java.time.Clock;
import java.time.OffsetDateTime;

import com.liligo.airport_shuttle.model.BookingDetail;
import com.liligo.entity.ShuttleRideBookingEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.time.temporal.ChronoUnit.HOURS;

@Component
@RequiredArgsConstructor
public class BookingMapper {


    private final Clock localClock;
    private final CustomerMapper customerMapper;

    public BookingDetail map(ShuttleRideBookingEntity entity) {
        return new BookingDetail()
            .customer(customerMapper.map(entity.getUser()))
            .modifyAble(isModifyAble(entity))
            .numberOfPassengers((long) entity.getNumberOfPassengers())
            .departureLocation(entity.getShuttleRide().getAirport().getCity().getName())
            .departureDateTime(entity.getShuttleRide().getDepartureDatetime())
            .cancelled(entity.isCancelled());
    }

    private boolean isModifyAble(ShuttleRideBookingEntity entity) {
        return !entity.isCancelled() && HOURS.between(OffsetDateTime.now(localClock), entity.getShuttleRide().getDepartureDatetime()) > 48;
    }

}
