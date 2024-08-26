package com.liligo.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.liligo.airport_shuttle.model.ShuttleRoute;
import com.liligo.entity.ShuttleEntity;
import com.liligo.entity.ShuttleRideEntity;
import com.liligo.exception.NotFoundException;
import com.liligo.repository.ShuttleRideRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShuttleSearchService {

    private final ShuttleRideRepository shuttleRideRepository;

    public List<ShuttleRoute> getShuttleRouteResultList(String city, Integer limit, Integer offset) {
        var shuttleCityMap = findShuttleByCity(city, limit, offset);
        if (shuttleCityMap.isEmpty()) {
            log.debug("Couldn't find active shuttle in the city: {}", city);
            throw new NotFoundException("error.airport-shuttle.active-shuttle-not-found", city);
        }

        log.debug("Shuttles by city {}", shuttleCityMap);
        List<ShuttleRoute> resultList = new ArrayList<>();
        for (var entry : shuttleCityMap.entrySet()) {
            var shuttleRoute = new ShuttleRoute();
            shuttleRoute.setAvailableSeats((long) entry.getValue().getNumberOfSeats());
            shuttleRoute.setDepartureTime(entry.getKey().getDepartureDatetime());
            shuttleRoute.setAirport(entry.getKey().getAirport().getCode());
            resultList.add(shuttleRoute);
        }

        return resultList;
    }

    private Map<ShuttleRideEntity, ShuttleEntity> findShuttleByCity(String city, Integer limit, Integer offset) {
        var queryLimit = Optional.ofNullable(limit)
            .orElse(Integer.MAX_VALUE);
        var queryOffset = Optional.ofNullable(offset)
            .orElse(0);
        log.debug("Limit {}, offset {}", limit, offset);

        var sort = Sort.by("airport.code").ascending()
            .and(Sort.by("departureDatetime").ascending());
        var pageRequest = PageRequest.of(queryOffset, queryLimit, sort);

        LinkedHashMap<ShuttleRideEntity, ShuttleEntity> sortedMap = new LinkedHashMap<>();
        shuttleRideRepository.findAllByCityName(city, pageRequest)
            .forEach(it -> sortedMap.put(it, it.getShuttle()));

        return sortedMap;
    }

}
