package com.liligo.entity;

import java.time.OffsetDateTime;

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
@Table(name = "shuttle_ride", schema = "liligo", indexes = {
    @Index(name = "shuttle_ride_shuttle", columnList = "shuttle_id"),
    @Index(name = "shuttle_ride_airport", columnList = "airport_id")
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShuttleRideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shuttle_id", nullable = false)
    private ShuttleEntity shuttle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airport_id", nullable = false, referencedColumnName = "id")
    @ToString.Exclude
    private AirportEntity airport;

    @Column(name = "departure_datetime", nullable = false)
    private OffsetDateTime departureDatetime;

}
