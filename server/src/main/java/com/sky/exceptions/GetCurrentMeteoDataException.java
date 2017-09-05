package com.sky.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by fmandryka on 28.08.2017.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class GetCurrentMeteoDataException extends AppException {
    public GetCurrentMeteoDataException(String message) {
        super(message);
    }
}
