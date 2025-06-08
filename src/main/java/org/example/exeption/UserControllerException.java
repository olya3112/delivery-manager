package org.example.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerException {

    @ExceptionHandler(ManagerInternalException.class)
    public ResponseEntity<String> handleManagerInternalException(ManagerInternalException ex) {
        // Можно вернуть объект с кодом и сообщением, если нужно
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // 400
                .body(ex.getMessage());
    }
}
