package com.liligo.airport_shuttle.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.liligo.airport_shuttle.model.BookingDetail;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * BookingResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-18T08:58:05.486826+02:00[Europe/Budapest]", comments = "Generator version: 7.4.0")
public class BookingResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  
  private List<BookingDetail> bookingDetails = new ArrayList<>();

  public BookingResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BookingResponse(List<BookingDetail> bookingDetails) {
    this.bookingDetails = bookingDetails;
  }

  public BookingResponse bookingDetails(List<BookingDetail> bookingDetails) {
    this.bookingDetails = bookingDetails;
    return this;
  }

  public BookingResponse addBookingDetailsItem(BookingDetail bookingDetailsItem) {
    if (this.bookingDetails == null) {
      this.bookingDetails = new ArrayList<>();
    }
    this.bookingDetails.add(bookingDetailsItem);
    return this;
  }

  /**
   * Get bookingDetails
   * @return bookingDetails
  */
  @NotNull
  @Schema(name = "bookingDetails", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("bookingDetails")
  public List<BookingDetail> getBookingDetails() {
    return bookingDetails;
  }

  public void setBookingDetails(List<BookingDetail> bookingDetails) {
    this.bookingDetails = bookingDetails;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingResponse bookingResponse = (BookingResponse) o;
    return Objects.equals(this.bookingDetails, bookingResponse.bookingDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingResponse {\n");
    sb.append("    bookingDetails: ").append(toIndentedString(bookingDetails)).append("\n");
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

