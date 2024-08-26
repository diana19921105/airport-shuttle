package com.liligo.airport_shuttle.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.liligo.airport_shuttle.model.Customer;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * BookingDetail
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-18T08:58:05.486826+02:00[Europe/Budapest]", comments = "Generator version: 7.4.0")
public class BookingDetail implements Serializable {

  private static final long serialVersionUID = 1L;

  private Customer customer;

  private String departureLocation;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime departureDateTime;

  private Long numberOfPassengers;

  private Boolean modifyAble;

  private Boolean cancelled;

  public BookingDetail() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BookingDetail(Customer customer, String departureLocation, OffsetDateTime departureDateTime, Long numberOfPassengers, Boolean modifyAble, Boolean cancelled) {
    this.customer = customer;
    this.departureLocation = departureLocation;
    this.departureDateTime = departureDateTime;
    this.numberOfPassengers = numberOfPassengers;
    this.modifyAble = modifyAble;
    this.cancelled = cancelled;
  }

  public BookingDetail customer(Customer customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
  */
  @NotNull
  @Schema(name = "customer", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("customer")
  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public BookingDetail departureLocation(String departureLocation) {
    this.departureLocation = departureLocation;
    return this;
  }

  /**
   * Get departureLocation
   * @return departureLocation
  */
  @NotNull
  @Schema(name = "departureLocation", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("departureLocation")
  public String getDepartureLocation() {
    return departureLocation;
  }

  public void setDepartureLocation(String departureLocation) {
    this.departureLocation = departureLocation;
  }

  public BookingDetail departureDateTime(OffsetDateTime departureDateTime) {
    this.departureDateTime = departureDateTime;
    return this;
  }

  /**
   * Get departureDateTime
   * @return departureDateTime
  */
  @NotNull
  @Schema(name = "departureDateTime", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("departureDateTime")
  public OffsetDateTime getDepartureDateTime() {
    return departureDateTime;
  }

  public void setDepartureDateTime(OffsetDateTime departureDateTime) {
    this.departureDateTime = departureDateTime;
  }

  public BookingDetail numberOfPassengers(Long numberOfPassengers) {
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

  public BookingDetail modifyAble(Boolean modifyAble) {
    this.modifyAble = modifyAble;
    return this;
  }

  /**
   * Get modifyAble
   * @return modifyAble
  */
  @NotNull
  @Schema(name = "modifyAble", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("modifyAble")
  public Boolean getModifyAble() {
    return modifyAble;
  }

  public void setModifyAble(Boolean modifyAble) {
    this.modifyAble = modifyAble;
  }

  public BookingDetail cancelled(Boolean cancelled) {
    this.cancelled = cancelled;
    return this;
  }

  /**
   * Get cancelled
   * @return cancelled
  */
  @NotNull
  @Schema(name = "cancelled", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cancelled")
  public Boolean getCancelled() {
    return cancelled;
  }

  public void setCancelled(Boolean cancelled) {
    this.cancelled = cancelled;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingDetail bookingDetail = (BookingDetail) o;
    return Objects.equals(this.customer, bookingDetail.customer) &&
        Objects.equals(this.departureLocation, bookingDetail.departureLocation) &&
        Objects.equals(this.departureDateTime, bookingDetail.departureDateTime) &&
        Objects.equals(this.numberOfPassengers, bookingDetail.numberOfPassengers) &&
        Objects.equals(this.modifyAble, bookingDetail.modifyAble) &&
        Objects.equals(this.cancelled, bookingDetail.cancelled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customer, departureLocation, departureDateTime, numberOfPassengers, modifyAble, cancelled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingDetail {\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    departureLocation: ").append(toIndentedString(departureLocation)).append("\n");
    sb.append("    departureDateTime: ").append(toIndentedString(departureDateTime)).append("\n");
    sb.append("    numberOfPassengers: ").append(toIndentedString(numberOfPassengers)).append("\n");
    sb.append("    modifyAble: ").append(toIndentedString(modifyAble)).append("\n");
    sb.append("    cancelled: ").append(toIndentedString(cancelled)).append("\n");
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

