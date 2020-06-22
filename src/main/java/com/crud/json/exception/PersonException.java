package com.crud.json.exception;

public class PersonException extends RuntimeException {
    private ErrorType errorType;
    public PersonException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public enum ErrorType {NOT_FOUND}
}
