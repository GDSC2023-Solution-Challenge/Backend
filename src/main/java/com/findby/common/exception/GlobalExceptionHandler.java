package com.findby.common.exception;

import com.findby.common.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<CommonResponse<Object>> handle(BadRequestException e) {
        CommonResponse<Object> response = new CommonResponse<>(e.getStatus(), e.getMessage(), null);
        return ResponseEntity.status(e.getStatus()).body(response);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<CommonResponse<Object>> handle(ForbiddenException e) {
        CommonResponse<Object> response = new CommonResponse<>(e.getStatus(), e.getMessage(), null);
        return ResponseEntity.status(e.getStatus()).body(response);
    }
}
