package org.example.exeption;


import lombok.RequiredArgsConstructor;
import lombok.Data;

@Data
@RequiredArgsConstructor
public class ErrorResponse {
    private boolean success;
    private int resultCode;
    private String message;


    public ErrorResponse(boolean success, int resultCode, String message) {
        this.success = success;
        this.resultCode = resultCode;
        this.message = message;
    }


}
