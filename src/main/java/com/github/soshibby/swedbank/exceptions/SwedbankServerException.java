package com.github.soshibby.swedbank.exceptions;

/**
 * Created by Henrik on 30/01/2017.
 */
public class SwedbankServerException extends Exception {

    public SwedbankServerException(String message) {
        super(message);
    }

    public SwedbankServerException(String message, Throwable cause) {
        super(message, cause);
    }

}
