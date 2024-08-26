package com.liligo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "shuttle", schema = "liligo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShuttleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "vehicle_identification_number", nullable = false)
    private String vehicleIdNumber;

    @Column(name = "number_of_seats", nullable = false)
    private int numberOfSeats;

    @Column(name = "active", nullable = false)
    private boolean isActive;

    @OneToMany(mappedBy = "shuttle")
    @ToString.Exclude
    private List<ShuttleRideEntity> shuttleRides;

}
