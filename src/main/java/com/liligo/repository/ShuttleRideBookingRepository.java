package com.liligo.repository;

import com.liligo.entity.ShuttleRideBookingEntity;
import io.micrometer.common.lang.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShuttleRideBookingRepository extends JpaRepository<ShuttleRideBookingEntity, Long> {

    Page<ShuttleRideBookingEntity> findAllByUser_Id(Long userId, Pageable pageable);

    @Modifying
    @Query("UPDATE ShuttleRideBookingEntity s SET s.cancelled = true WHERE s.id = :id")
    void deleteById(@NonNull Long id);

}
