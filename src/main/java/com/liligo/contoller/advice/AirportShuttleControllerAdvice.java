package com.liligo.contoller.advice;

import java.util.Optional;
import java.util.UUID;

import com.liligo.exception.NotEnoughAvailableSeatsException;
import com.liligo.exception.NotFoundException;
import com.liligo.exception.NotModifyAbleException;
import com.liligo.exception.ValidationException;
import com.liligo.model.SystemMessage;
import com.liligo.model.SystemMessageResponse;
import io.micrometer.tracing.Span;
import io.micrometer.tracing.TraceContext;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class AirportShuttleControllerAdvice {

    private final Tracer tracer;
    private final MessageSource messageSource;

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<SystemMessageResponse> handleValidationException(ValidationException ex) {
        log.error(ex.getMessage(), ex);
        var response = createSystemMessageResponse(ex.getMessage(), getTraceId(), ex.getArgs());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotModifyAbleException.class)
    public ResponseEntity<SystemMessageResponse> handleNotModifyAbleException(NotModifyAbleException ex) {
        log.error(ex.getMessage(), ex);
        var response = createSystemMessageResponse(ex.getMessage(), getTraceId(), ex.getArgs());
        return new ResponseEntity<>(response, HttpStatus.GONE);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<SystemMessageResponse> handleNotFoundException(NotFoundException ex) {
        log.error(ex.getMessage(), ex);
        var response = createSystemMessageResponse(ex.getMessage(), getTraceId(), ex.getArgs());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotEnoughAvailableSeatsException.class)
    public ResponseEntity<SystemMessageResponse> handleNotEnoughSeatsException(NotEnoughAvailableSeatsException ex) {
        log.error(ex.getMessage(), ex);
        var response = createSystemMessageResponse(ex.getMessage(), getTraceId(), ex.getArgs());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    private SystemMessageResponse createSystemMessageResponse(String message, String traceId, String... args) {
        var response = new SystemMessageResponse();
        var systemMessage = SystemMessage.builder()
            .message(readMessageFromProperties(message, args))
            .traceId(traceId)
            .build();
        response.setMessage(systemMessage);

        return response;
    }

    private String readMessageFromProperties(String messageCode, String... args) {
        try {
            return messageSource.getMessage(messageCode, args, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException ex) {
            log.warn("No message found with code {}", messageCode);
            log.error(ex.getMessage(), ex);
            return messageSource.getMessage("error.airport-shuttle.no-such-message", args, LocaleContextHolder.getLocale());
        }
    }

    private String getTraceId() {
        return Optional.ofNullable(tracer.currentSpan())
            .map(Span::context)
            .map(TraceContext::traceId)
            .orElse(UUID.randomUUID().toString());
    }

}
