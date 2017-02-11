package com.github.soshibby.swedbank.util;

/**
 * Created by Henrik on 30/01/2017.
 */
public class Assert {

    public static void notNull(Object compare, String errorMessage) {
        if (compare == null) {
            throw new RuntimeException("Assertion 'notNull' failed. " + errorMessage);
        }
    }

    public static void notEmpty(String str, String errorMessage) {
        if (str == null || str.isEmpty()) {
            throw new RuntimeException("Assertion 'notEmpty' failed. " + errorMessage);
        }
    }

    public static void notFalse(Boolean bool, String errorMessage) {
        if (!bool) {
            throw new RuntimeException("Assertion 'notFalse' failed. " + errorMessage);
        }
    }

    public static void greaterEqualThan(int value, int greaterOrEqual, String errorMessage) {
        if (value < greaterOrEqual) {
            throw new RuntimeException("Assertion 'greaterEqualThan' failed. " + errorMessage);
        }
    }
}
