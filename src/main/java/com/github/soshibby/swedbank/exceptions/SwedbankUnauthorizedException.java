package com.github.soshibby.swedbank.exceptions;

/**
 * Created by Henrik on 30/01/2017.
 */
public class SwedbankUnauthorizedException extends Throwable {

    public SwedbankUnauthorizedException(String message) {
        super(message);
    }

    public SwedbankUnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

}
