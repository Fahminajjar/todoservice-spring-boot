package com.fahminajjar.todoservice.exception;

public class Error {
    private String error;
    private String message;

    public Error(String error, String message) {
        this.error = error;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
