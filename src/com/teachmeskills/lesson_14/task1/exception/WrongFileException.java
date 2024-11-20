package com.teachmeskills.lesson_14.task1.exception;

public class WrongFileException extends Exception {
    private int errorCode;

    public WrongFileException(String message) {
        super(message);
    }

    public WrongFileException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
