package com.liligo.airport_shuttle.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.liligo.airport_shuttle.model.BookingDetail;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UpdateBookingResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-18T08:58:05.486826+02:00[Europe/Budapest]", comments = "Generator version: 7.4.0")
public class UpdateBookingResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private BookingDetail bookingDetail;

  public UpdateBookingResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateBookingResponse(BookingDetail bookingDetail) {
    this.bookingDetail = bookingDetail;
  }

  public UpdateBookingResponse bookingDetail(BookingDetail bookingDetail) {
    this.bookingDetail = bookingDetail;
    return this;
  }

  /**
   * Get bookingDetail
   * @return bookingDetail
  */
  @NotNull
  @Schema(name = "bookingDetail", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("bookingDetail")
  public BookingDetail getBookingDetail() {
    return bookingDetail;
  }

  public void setBookingDetail(BookingDetail bookingDetail) {
    this.bookingDetail = bookingDetail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateBookingResponse updateBookingResponse = (UpdateBookingResponse) o;
    return Objects.equals(this.bookingDetail, updateBookingResponse.bookingDetail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingDetail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateBookingResponse {\n");
    sb.append("    bookingDetail: ").append(toIndentedString(bookingDetail)).append("\n");
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

