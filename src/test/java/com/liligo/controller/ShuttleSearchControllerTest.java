package com.liligo.controller;

import com.liligo.contoller.ShuttleSearchController;
import com.liligo.service.ShuttleSearchService;
import io.micrometer.tracing.Tracer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShuttleSearchController.class)
@ExtendWith(MockitoExtension.class)
public class ShuttleSearchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShuttleSearchService searchService;

    @MockBean
    private Tracer tracer;

    @Test
    void searchTest() throws Exception {
        mockMvc.perform(get("/search-shuttles")
                .param("departureLocation", "London")
                .param("limit", String.valueOf(20))
                .param("offset", String.valueOf(0)))
            .andExpect(status().isOk());

        verify(searchService).getShuttleRouteResultList(eq("London"), eq(20), eq(0));
    }

}
