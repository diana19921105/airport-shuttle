package com.liligo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "shuttle_ride_booking", schema = "liligo", indexes = {
    @Index(name = "shuttle_ride_booking_shuttle_ride", columnList = "shuttle_ride_id"),
    @Index(name = "shuttle_ride_booking_user", columnList = "user_id")
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShuttleRideBookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shuttle_ride_id", nullable = false, referencedColumnName = "id")
    private ShuttleRideEntity shuttleRide;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private UserEntity user;

    @Column(name = "number_of_passengers", nullable = false)
    @Builder.Default
    private int numberOfPassengers = 1;

    @Column(name = "cancelled", nullable = false)
    private boolean cancelled;

}
