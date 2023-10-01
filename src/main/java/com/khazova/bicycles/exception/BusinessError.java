package com.khazova.bicycles.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BusinessError {
    BICYCLE_NOT_FOUND("0100", "Велосипед с id '%s' отсутствует в базе", HttpStatus.NOT_FOUND);

    private final String errorCode;
    private final String description;
    private final HttpStatus httpStatus;

    BusinessError(String errorCode, String description, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
