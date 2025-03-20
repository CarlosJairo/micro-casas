package com.Hogar360.casas.infrastructure.exceptionHandlers;

import com.Hogar360.casas.domain.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(NameMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleNameMaxSizeExceededException(NameMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(),
                LocalDateTime.now()));
    }

    @ExceptionHandler(DescriptionMaxSizeExceededException.class)
    public ResponseEntity<ExceptionResponse> handleDescriptionMaxSizeExceededException(DescriptionMaxSizeExceededException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(),
                LocalDateTime.now()));
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryAlreadyExistsException(EntityAlreadyExistsException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(),
                LocalDateTime.now()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> handleIllegalArgumentException(IllegalArgumentException exception){
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(NameEmptyException.class)
    public ResponseEntity<ExceptionResponse> handleNameEmptyException(NameEmptyException exception){
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(DescriptionEmptyException.class)
    public ResponseEntity<ExceptionResponse> handleDescriptionEmptyException(DescriptionEmptyException exception){
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(DepartmentNotExistException.class)
    public ResponseEntity<ExceptionResponse> handleDepartmentNotExistException(DepartmentNotExistException exception) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidFormat(HttpMessageNotReadableException ex) {
        String message = ExceptionConstants.DEPARTMENT_ID_MUST_BE_NUMBER;
        return ResponseEntity.badRequest().body(new ExceptionResponse(message, LocalDateTime.now()));
    }
}
