package com.liligo.airport_shuttle.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * BookShuttleResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-18T08:58:05.486826+02:00[Europe/Budapest]", comments = "Generator version: 7.4.0")
public class BookShuttleResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long bookingId;

  public BookShuttleResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public BookShuttleResponse(Long bookingId) {
    this.bookingId = bookingId;
  }

  public BookShuttleResponse bookingId(Long bookingId) {
    this.bookingId = bookingId;
    return this;
  }

  /**
   * Get bookingId
   * @return bookingId
  */
  @NotNull
  @Schema(name = "bookingId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("bookingId")
  public Long getBookingId() {
    return bookingId;
  }

  public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookShuttleResponse bookShuttleResponse = (BookShuttleResponse) o;
    return Objects.equals(this.bookingId, bookShuttleResponse.bookingId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookShuttleResponse {\n");
    sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
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

