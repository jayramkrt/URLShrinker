package com.nido.urlshrinker.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Map<String, Object>> handleApiException(ApiException apiEx){
        return ResponseEntity.status(apiEx.getStatus()).body(Map.of( "timestamp", Instant.now(),
                "status", apiEx.getStatus().value(),
                "error", apiEx.getStatus().getReasonPhrase(),
                "message", apiEx.getMessage()));
    }
}
