package com.github.soshibby.swedbank.util;

/**
 * Created by Henrik on 30/01/2017.
 */
public class Base64 {

    public static String encode(String value) {
        return new String(java.util.Base64.getEncoder().encode(value.getBytes()));
    }

}
