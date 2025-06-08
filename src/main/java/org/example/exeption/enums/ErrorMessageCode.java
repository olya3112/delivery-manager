package org.example.exeption.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessageCode {

    DATA_NOT_FOUND(1);

    private final int code;
}
