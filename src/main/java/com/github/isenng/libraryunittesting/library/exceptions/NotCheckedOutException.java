package com.github.isenng.libraryunittesting.library.exceptions;

public class NotCheckedOutException extends LibraryException {
    public NotCheckedOutException() {
    }

    public NotCheckedOutException(String message) {
        super(message);
    }

    public NotCheckedOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCheckedOutException(Throwable cause) {
        super(cause);
    }

    public NotCheckedOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
