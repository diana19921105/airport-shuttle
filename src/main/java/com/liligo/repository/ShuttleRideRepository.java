package com.liligo.repository;

import java.time.OffsetDateTime;
import java.util.Optional;

import com.liligo.entity.ShuttleRideEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShuttleRideRepository extends JpaRepository<ShuttleRideEntity, Long> {

    @Query(value = "SELECT sr FROM ShuttleRideEntity sr " +
        "JOIN sr.airport a " +
        "JOIN a.city c " +
        "WHERE c.name = :cityName AND sr.shuttle.numberOfSeats > 0 AND sr.shuttle.isActive")
    Page<ShuttleRideEntity> findAllByCityName(String cityName, Pageable pageable);

    Optional<ShuttleRideEntity> findByIdAndDepartureDatetime(Long id, OffsetDateTime departureTime);

    Optional<ShuttleRideEntity> findByDepartureDatetime(OffsetDateTime departureTime);

}
