/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.liligo.airport_shuttle.api;

import com.liligo.airport_shuttle.model.BookShuttleRequest;
import com.liligo.airport_shuttle.model.BookShuttleResponse;
import com.liligo.airport_shuttle.model.BookingDetailResponse;
import com.liligo.airport_shuttle.model.BookingResponse;
import com.liligo.airport_shuttle.model.UpdateBookingRequest;
import com.liligo.airport_shuttle.model.UpdateBookingResponse;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-18T08:58:05.486826+02:00[Europe/Budapest]", comments = "Generator version: 7.4.0")
@Tag(name = "Shuttle Ride Booking", description = "the Shuttle Ride Booking API")
public interface ShuttleRideBookingApi {

    /**
     * POST /book-shuttle
     * Book a shuttle
     *
     * @param bookShuttleRequest  (required)
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "bookShuttle",
        description = "Book a shuttle",
        tags = { "Shuttle Ride Booking" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = BookShuttleResponse.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/book-shuttle",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    ResponseEntity<BookShuttleResponse> bookShuttle(
        @Parameter(name = "BookShuttleRequest", description = "", required = true) @RequestBody BookShuttleRequest bookShuttleRequest
    );


    /**
     * DELETE /bookings/booking/{id}
     * Cancel the booking
     *
     * @param id  (required)
     * @return Successful deletion (status code 204)
     *         or Booking not found (status code 404)
     */
    @Operation(
        operationId = "cancelBooking",
        description = "Cancel the booking",
        tags = { "Shuttle Ride Booking" },
        responses = {
            @ApiResponse(responseCode = "204", description = "Successful deletion"),
            @ApiResponse(responseCode = "404", description = "Booking not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/bookings/booking/{id}"
    )
    
    ResponseEntity<Void> cancelBooking(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    );


    /**
     * GET /bookings/{userId}
     * Get booking list for user
     *
     * @param userId  (required)
     * @param limit The maximum number of bookings to return. If not provided, it will return all bookings from the offset. (optional)
     * @param offset The offset from where to return the bookings from. The first index is 0. If not provided, it will return the bookings from the first index. (optional)
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "getAllBookings",
        description = "Get booking list for user",
        tags = { "Shuttle Ride Booking" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = BookingResponse.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/bookings/{userId}",
        produces = { "application/json" }
    )
    
    ResponseEntity<BookingResponse> getAllBookings(
        @Parameter(name = "userId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("userId") String userId,
        @Parameter(name = "limit", description = "The maximum number of bookings to return. If not provided, it will return all bookings from the offset.", in = ParameterIn.QUERY) @RequestParam(value = "limit", required = false) Integer limit,
        @Parameter(name = "offset", description = "The offset from where to return the bookings from. The first index is 0. If not provided, it will return the bookings from the first index.", in = ParameterIn.QUERY) @RequestParam(value = "offset", required = false) Integer offset
    );


    /**
     * GET /bookings/booking/{id}
     * Get booking detail
     *
     * @param id  (required)
     * @return OK (status code 200)
     *         or Booking not found (status code 404)
     */
    @Operation(
        operationId = "getBookingDetail",
        description = "Get booking detail",
        tags = { "Shuttle Ride Booking" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = BookingDetailResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "Booking not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/bookings/booking/{id}",
        produces = { "application/json" }
    )
    
    ResponseEntity<BookingDetailResponse> getBookingDetail(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    );


    /**
     * PATCH /bookings/booking/{id}
     * Modify booking
     *
     * @param id  (required)
     * @param updateBookingRequest  (optional)
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "updateBooking",
        description = "Modify booking",
        tags = { "Shuttle Ride Booking" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UpdateBookingResponse.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/bookings/booking/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    ResponseEntity<UpdateBookingResponse> updateBooking(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "UpdateBookingRequest", description = "") @RequestBody(required = false) UpdateBookingRequest updateBookingRequest
    );

}
