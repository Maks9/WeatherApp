package com.sky.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class GetCurrentMeteoDataException extends AppException {
    public GetCurrentMeteoDataException(String message) {
        super(message);
    }
}
