package com.liligo.airport_shuttle.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.liligo.airport_shuttle.model.ShuttleRoute;
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
 * GetAvailableShuttleRoutesResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-18T08:58:05.486826+02:00[Europe/Budapest]", comments = "Generator version: 7.4.0")
public class GetAvailableShuttleRoutesResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  
  private List<ShuttleRoute> shuttleRouteList = new ArrayList<>();

  public GetAvailableShuttleRoutesResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GetAvailableShuttleRoutesResponse(List<ShuttleRoute> shuttleRouteList) {
    this.shuttleRouteList = shuttleRouteList;
  }

  public GetAvailableShuttleRoutesResponse shuttleRouteList(List<ShuttleRoute> shuttleRouteList) {
    this.shuttleRouteList = shuttleRouteList;
    return this;
  }

  public GetAvailableShuttleRoutesResponse addShuttleRouteListItem(ShuttleRoute shuttleRouteListItem) {
    if (this.shuttleRouteList == null) {
      this.shuttleRouteList = new ArrayList<>();
    }
    this.shuttleRouteList.add(shuttleRouteListItem);
    return this;
  }

  /**
   * Get shuttleRouteList
   * @return shuttleRouteList
  */
  @NotNull
  @Schema(name = "shuttleRouteList", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("shuttleRouteList")
  public List<ShuttleRoute> getShuttleRouteList() {
    return shuttleRouteList;
  }

  public void setShuttleRouteList(List<ShuttleRoute> shuttleRouteList) {
    this.shuttleRouteList = shuttleRouteList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetAvailableShuttleRoutesResponse getAvailableShuttleRoutesResponse = (GetAvailableShuttleRoutesResponse) o;
    return Objects.equals(this.shuttleRouteList, getAvailableShuttleRoutesResponse.shuttleRouteList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shuttleRouteList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAvailableShuttleRoutesResponse {\n");
    sb.append("    shuttleRouteList: ").append(toIndentedString(shuttleRouteList)).append("\n");
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

