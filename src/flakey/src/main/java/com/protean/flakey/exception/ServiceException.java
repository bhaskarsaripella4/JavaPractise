package com.protean.flakey.exception;


import lombok.*;
import org.springframework.http.*;

import java.security.*;

@Getter
@Setter
public class ServiceException extends RuntimeException{

    private static final long serialVersionUID = -2780866794479301073L;
    private final HttpStatus httpStatus;
    private final String errorResponse; // ErrorResponse


    protected ServiceException(HttpStatus httpStatus, String errorResponse){
        this.errorResponse = errorResponse;
        this.httpStatus = httpStatus;
    }

    public static ServiceException internalError(HttpStatus httpStatus, String errorResponse){
        return new ServiceException(httpStatus, errorResponse);
    }
}
