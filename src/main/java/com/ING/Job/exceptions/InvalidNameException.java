package com.ING.Job.exceptions;

public class InvalidNameException extends RuntimeException {
    public InvalidNameException(String invalidUserName) {
        super(invalidUserName);
    }
}
