package com.liligo.controller;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liligo.airport_shuttle.model.BookShuttleRequest;
import com.liligo.airport_shuttle.model.UpdateBookingRequest;
import com.liligo.contoller.BookingController;
import com.liligo.mapper.BookingMapper;
import com.liligo.service.ShuttleBookingService;
import com.liligo.util.ValidationUtil;
import io.micrometer.tracing.Tracer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookingController.class)
@ExtendWith(MockitoExtension.class)
public class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ShuttleBookingService bookingService;

    @MockBean
    private ValidationUtil validationUtil;

    @MockBean
    private BookingMapper mapper;

    @MockBean
    private Tracer tracer;

    @Test
    void testBookShuttle() throws Exception {
        var request = new BookShuttleRequest()
            .shuttleRideId(1L)
            .departureTime(OffsetDateTime.parse("2024-08-28T14:03:58+02:00"))
            .name("John Doe")
            .email("john@doe.com")
            .numberOfPassengers(2L)
            .phoneNumber("+36 30 123 4567");

        mockMvc.perform(post("/book-shuttle")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk());

        verify(validationUtil).validatePhoneNumber(request.getPhoneNumber());
        verify(validationUtil).validateEmail(request.getEmail());
        verify(bookingService).bookShuttleRide(
            eq(request.getShuttleRideId()),
            any(),
            eq(request.getName()),
            eq(request.getEmail()),
            eq(request.getPhoneNumber()),
            eq(request.getNumberOfPassengers())
        );
    }

    @Test
    void cancelBooking() throws Exception {
        mockMvc.perform(delete("/bookings/booking/1"))
            .andExpect(status().isNoContent());

        verify(bookingService).deleteBooking("1");
    }

    @Test
    void getAllBookings() throws Exception {
        mockMvc.perform(get("/bookings/1")
                .param("limit", String.valueOf(5))
                .param("offset", String.valueOf(0)))
            .andExpect(status().isOk());

        verify(bookingService).getBookings("1", 5, 0);
    }

    @Test
    void getBookingDetail() throws Exception {
        mockMvc.perform(get("/bookings/booking/1"))
            .andExpect(status().isOk());

        verify(bookingService).getBooking("1");
        verify(mapper).map(any());
    }

    @Test
    void updateBooking() throws Exception {
        var request = new UpdateBookingRequest()
            .numberOfPassengers(5L);
        mockMvc.perform(patch("/bookings/booking/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk());

        verify(bookingService).updateBooking("1", request);
        verify(mapper).map(any());
    }


}
