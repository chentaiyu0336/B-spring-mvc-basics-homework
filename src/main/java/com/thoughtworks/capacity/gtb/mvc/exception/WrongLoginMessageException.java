package com.thoughtworks.capacity.gtb.mvc.exception;

public class WrongLoginMessageException extends RuntimeException {
    public WrongLoginMessageException(String message) {
        super(message);
    }
}
