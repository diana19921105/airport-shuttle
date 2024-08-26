package com.liligo.contoller;

import com.liligo.airport_shuttle.api.AirportShuttleSearchApi;
import com.liligo.airport_shuttle.model.GetAvailableShuttleRoutesResponse;
import com.liligo.service.ShuttleSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShuttleSearchController implements AirportShuttleSearchApi {

    private final ShuttleSearchService searchService;

    @Override
    public ResponseEntity<GetAvailableShuttleRoutesResponse> getAvailableShuttleRoutes(String departureLocation, Integer limit, Integer offset) {
        var response = new GetAvailableShuttleRoutesResponse()
            .shuttleRouteList(searchService.getShuttleRouteResultList(departureLocation, limit, offset));

        return ResponseEntity.ok(response);
    }

}
