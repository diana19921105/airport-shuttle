package com.liligo.airport_shuttle.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ShuttleRoute
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-18T08:58:05.486826+02:00[Europe/Budapest]", comments = "Generator version: 7.4.0")
public class ShuttleRoute implements Serializable {

  private static final long serialVersionUID = 1L;

  private String airport;

  private Long availableSeats;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime departureTime;

  public ShuttleRoute() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ShuttleRoute(String airport, Long availableSeats, OffsetDateTime departureTime) {
    this.airport = airport;
    this.availableSeats = availableSeats;
    this.departureTime = departureTime;
  }

  public ShuttleRoute airport(String airport) {
    this.airport = airport;
    return this;
  }

  /**
   * Get airport
   * @return airport
  */
  @NotNull
  @Schema(name = "airport", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("airport")
  public String getAirport() {
    return airport;
  }

  public void setAirport(String airport) {
    this.airport = airport;
  }

  public ShuttleRoute availableSeats(Long availableSeats) {
    this.availableSeats = availableSeats;
    return this;
  }

  /**
   * Get availableSeats
   * @return availableSeats
  */
  @NotNull
  @Schema(name = "availableSeats", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("availableSeats")
  public Long getAvailableSeats() {
    return availableSeats;
  }

  public void setAvailableSeats(Long availableSeats) {
    this.availableSeats = availableSeats;
  }

  public ShuttleRoute departureTime(OffsetDateTime departureTime) {
    this.departureTime = departureTime;
    return this;
  }

  /**
   * Get departureTime
   * @return departureTime
  */
  @NotNull
  @Schema(name = "departureTime", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("departureTime")
  public OffsetDateTime getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(OffsetDateTime departureTime) {
    this.departureTime = departureTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ShuttleRoute shuttleRoute = (ShuttleRoute) o;
    return Objects.equals(this.airport, shuttleRoute.airport) &&
        Objects.equals(this.availableSeats, shuttleRoute.availableSeats) &&
        Objects.equals(this.departureTime, shuttleRoute.departureTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(airport, availableSeats, departureTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShuttleRoute {\n");
    sb.append("    airport: ").append(toIndentedString(airport)).append("\n");
    sb.append("    availableSeats: ").append(toIndentedString(availableSeats)).append("\n");
    sb.append("    departureTime: ").append(toIndentedString(departureTime)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

