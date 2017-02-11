package com.github.soshibby.swedbank.exceptions;

/**
 * Created by Henrik on 31/01/2017.
 */
public class SwedbankAuthenticationException extends Exception {

    public SwedbankAuthenticationException(String message) {
        super(message);
    }

    public SwedbankAuthenticationException(String message, Throwable e) {
        super(message, e);
    }

}
