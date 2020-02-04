package com.bestprice.util;

public class Verifier {
    public static void verifyNotNull(Object variant, final String message) {
        if(variant == null) {
            throw new VerifierException(message);
        }
    }

    public static void verifyNotEmpty(String variant, final String message) {
        if (!(variant != null && variant.length() > 0)) {
            throw new VerifierException(message);
        }
    }
}
