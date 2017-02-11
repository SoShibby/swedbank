package com.github.soshibby.swedbank.exceptions;

/**
 * Created by Henrik on 30/01/2017.
 */
public class SwedbankUserException extends Throwable {

    public SwedbankUserException(String message) {
        super(message);
    }

    public SwedbankUserException(String message, Throwable cause) {
        super(message, cause);
    }

}
