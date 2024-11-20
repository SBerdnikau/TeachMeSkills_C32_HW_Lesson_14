package com.teachmeskills.lesson_14.task1.exception;

public class WrongDocumentException extends Exception {
    private int errorCode;

    public WrongDocumentException(String message) {
        super(message);
    }

    public WrongDocumentException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
