package org.example.exeption.controller;

import org.example.exeption.entity.opportunityException.OpportunityNotFoundException;
import org.example.exeption.enums.ErrorMessageCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.example.exeption.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class OpportunityControllerException {

    @ExceptionHandler(OpportunityNotFoundException.class)
    ResponseEntity<ErrorResponse> handleUserNotFound(OpportunityNotFoundException ex) {

        int errorMessageCode = ErrorMessageCode.DATA_NOT_FOUND.getCode();
        ErrorResponse errorResponse = new ErrorResponse(
                false,
                errorMessageCode,
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
