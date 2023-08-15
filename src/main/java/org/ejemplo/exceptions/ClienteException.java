package org.ejemplo.exceptions;

import org.springframework.http.HttpStatus;

public class ClienteException extends Exception {

    private HttpStatus statusCode;
    private String causa;
    public ClienteException(HttpStatus status, String message, String cause) {
        super(message);
        this.causa = cause;
        this.statusCode = status;
    }

    public HttpStatus getStatus(){
        return statusCode;
    }
}