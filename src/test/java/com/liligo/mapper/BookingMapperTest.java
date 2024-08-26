package com.liligo.mapper;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

import com.liligo.entity.AirportEntity;
import com.liligo.entity.CityEntity;
import com.liligo.entity.ShuttleRideBookingEntity;
import com.liligo.entity.ShuttleRideEntity;
import com.liligo.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.liligo.util.TestConstant.LOCAL_TIMEZONE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BookingMapperTest {

    @Autowired
    private CustomerMapper customerMapper;
    private BookingMapper bookingMapper;

    @BeforeEach
    public void init() {
        var zonedDateTime = ZonedDateTime.of(
            LocalDateTime.of(2024, 8, 15, 10, 0, 0, 0),
            LOCAL_TIMEZONE);
        var localClock = Clock.fixed(zonedDateTime.withZoneSameInstant(LOCAL_TIMEZONE).toInstant(), LOCAL_TIMEZONE);

        bookingMapper = new BookingMapper(localClock, customerMapper);
    }

    @Test
    void mapTest() {
        var entity = createEntity(OffsetDateTime.parse("2024-08-28T15:00:00Z"), false);
        var mapped = bookingMapper.map(entity);

        assertAll(
            () -> assertTrue(mapped.getModifyAble()),
            () -> assertEquals("Narnia", mapped.getDepartureLocation()),
            () -> assertEquals(2, mapped.getNumberOfPassengers()),
            () -> assertEquals("Tapsi Füles", mapped.getCustomer().getName()),
            () -> assertEquals("tapsi@hapsi.com", mapped.getCustomer().getEmail()),
            () -> assertEquals("+36 30 123 4567", mapped.getCustomer().getPhoneNumber())
        );
    }

    @Test
    void mapTestNotModifyAble() {
        var entity1 = createEntity(OffsetDateTime.parse("2024-08-16T14:57:33Z"), false);
        var entity2 = createEntity(OffsetDateTime.parse("2024-08-28T14:57:33Z"), true);

        var mapped1 = bookingMapper.map(entity1);
        var mapped2 = bookingMapper.map(entity2);

        assertAll(
            () -> assertFalse(mapped1.getModifyAble()),
            () -> assertFalse(mapped2.getModifyAble())
        );

    }

    private ShuttleRideBookingEntity createEntity(OffsetDateTime departure, boolean cancelled) {
        return ShuttleRideBookingEntity.builder()
            .id(1L)
            .numberOfPassengers(2)
            .cancelled(cancelled)
            .shuttleRide(ShuttleRideEntity.builder()
                .departureDatetime(departure)
                .airport(AirportEntity.builder()
                    .city(CityEntity.builder()
                        .name("Narnia")
                        .build())
                    .build())
                .build())
            .user(UserEntity.builder()
                .email("tapsi@hapsi.com")
                .fullName("Tapsi Füles")
                .phoneNumber("+36 30 123 4567")
                .build())
            .build();
    }

}
