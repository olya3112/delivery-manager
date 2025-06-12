package org.example.exeption;

import org.example.exeption.enums.ErrorMessageCode;
import org.example.exeption.userException.UserAlreadyExistsException;
import org.example.exeption.userException.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerException {


    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException ex) {

        int errorMessageCode = ErrorMessageCode.USER_NOT_FOUND.getCode();
        ErrorResponse errorResponse = new ErrorResponse(
                false,
                errorMessageCode,
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    ResponseEntity<ErrorResponse> handleUserNotFound(UserAlreadyExistsException ex) {

        int errorMessageCode = ErrorMessageCode.DUPLICATE_DATE.getCode();
        ErrorResponse errorResponse = new ErrorResponse(
                false,
                errorMessageCode,
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
