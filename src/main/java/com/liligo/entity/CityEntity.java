package com.liligo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.liligo.model.CapitalEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "city", schema = "liligo")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "all_airports_code")
    private String airportCode;

    @Column(name = "capital")
    @Enumerated(EnumType.STRING)
    private CapitalEnum capital;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<AirportEntity> airports;

}
