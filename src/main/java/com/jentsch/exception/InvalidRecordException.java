package com.jentsch.exception;

public class InvalidRecordException extends RuntimeException{
    public InvalidRecordException(String message) {
        super(message);
    }
}