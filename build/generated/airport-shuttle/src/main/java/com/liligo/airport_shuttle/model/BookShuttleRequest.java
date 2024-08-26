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
 * BookShuttleRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-18T08:58:05.486826+02:00[Europe/Budapest]", comments = "Generator version: 7.4.0")
public class BookShuttleRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long shuttleRideId;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime departureTime;

  private String name;

  private String email;

  private String phoneNumber;

  private Long numberOfPassengers;

  public BookShuttleRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BookShuttleRequest(Long shuttleRideId, OffsetDateTime departureTime, String name, String email, String phoneNumber, Long numberOfPassengers) {
    this.shuttleRideId = shuttleRideId;
    this.departureTime = departureTime;
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.numberOfPassengers = numberOfPassengers;
  }

  public BookShuttleRequest shuttleRideId(Long shuttleRideId) {
    this.shuttleRideId = shuttleRideId;
    return this;
  }

  /**
   * Get shuttleRideId
   * @return shuttleRideId
  */
  @NotNull
  @Schema(name = "shuttleRideId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("shuttleRideId")
  public Long getShuttleRideId() {
    return shuttleRideId;
  }

  public void setShuttleRideId(Long shuttleRideId) {
    this.shuttleRideId = shuttleRideId;
  }

  public BookShuttleRequest departureTime(OffsetDateTime departureTime) {
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

  public BookShuttleRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BookShuttleRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @NotNull
  @Schema(name = "email", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public BookShuttleRequest phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  /**
   * Get phoneNumber
   * @return phoneNumber
  */
  @NotNull
  @Schema(name = "phoneNumber", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("phoneNumber")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public BookShuttleRequest numberOfPassengers(Long numberOfPassengers) {
    this.numberOfPassengers = numberOfPassengers;
    return this;
  }

  /**
   * Get numberOfPassengers
   * @return numberOfPassengers
  */
  @NotNull
  @Schema(name = "numberOfPassengers", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("numberOfPassengers")
  public Long getNumberOfPassengers() {
    return numberOfPassengers;
  }

  public void setNumberOfPassengers(Long numberOfPassengers) {
    this.numberOfPassengers = numberOfPassengers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookShuttleRequest bookShuttleRequest = (BookShuttleRequest) o;
    return Objects.equals(this.shuttleRideId, bookShuttleRequest.shuttleRideId) &&
        Objects.equals(this.departureTime, bookShuttleRequest.departureTime) &&
        Objects.equals(this.name, bookShuttleRequest.name) &&
        Objects.equals(this.email, bookShuttleRequest.email) &&
        Objects.equals(this.phoneNumber, bookShuttleRequest.phoneNumber) &&
        Objects.equals(this.numberOfPassengers, bookShuttleRequest.numberOfPassengers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shuttleRideId, departureTime, name, email, phoneNumber, numberOfPassengers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookShuttleRequest {\n");
    sb.append("    shuttleRideId: ").append(toIndentedString(shuttleRideId)).append("\n");
    sb.append("    departureTime: ").append(toIndentedString(departureTime)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    numberOfPassengers: ").append(toIndentedString(numberOfPassengers)).append("\n");
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

