package com.liligo.repository;

import java.util.Optional;

import com.liligo.entity.ShuttleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShuttleRepository extends JpaRepository<ShuttleEntity, Long> {

    @Query("SELECT s FROM ShuttleEntity s JOIN s.shuttleRides sr WHERE sr.id = :id")
    Optional<ShuttleEntity> findByShuttleRideId(Long id);

}
