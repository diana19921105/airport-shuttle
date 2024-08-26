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
 * UpdateBookingRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-18T08:58:05.486826+02:00[Europe/Budapest]", comments = "Generator version: 7.4.0")
public class UpdateBookingRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long numberOfPassengers;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime departureDateTime;

  public UpdateBookingRequest numberOfPassengers(Long numberOfPassengers) {
    this.numberOfPassengers = numberOfPassengers;
    return this;
  }

  /**
   * Get numberOfPassengers
   * @return numberOfPassengers
  */
  
  @Schema(name = "numberOfPassengers", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("numberOfPassengers")
  public Long getNumberOfPassengers() {
    return numberOfPassengers;
  }

  public void setNumberOfPassengers(Long numberOfPassengers) {
    this.numberOfPassengers = numberOfPassengers;
  }

  public UpdateBookingRequest departureDateTime(OffsetDateTime departureDateTime) {
    this.departureDateTime = departureDateTime;
    return this;
  }

  /**
   * Get departureDateTime
   * @return departureDateTime
  */
  
  @Schema(name = "departureDateTime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("departureDateTime")
  public OffsetDateTime getDepartureDateTime() {
    return departureDateTime;
  }

  public void setDepartureDateTime(OffsetDateTime departureDateTime) {
    this.departureDateTime = departureDateTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateBookingRequest updateBookingRequest = (UpdateBookingRequest) o;
    return Objects.equals(this.numberOfPassengers, updateBookingRequest.numberOfPassengers) &&
        Objects.equals(this.departureDateTime, updateBookingRequest.departureDateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberOfPassengers, departureDateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateBookingRequest {\n");
    sb.append("    numberOfPassengers: ").append(toIndentedString(numberOfPassengers)).append("\n");
    sb.append("    departureDateTime: ").append(toIndentedString(departureDateTime)).append("\n");
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

