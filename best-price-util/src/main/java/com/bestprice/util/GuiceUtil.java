package com.bestprice.util;

import java.util.HashMap;
import java.util.Map;

public class GuiceUtil {

    public static final Map<String, Object> objectByClassName = new HashMap<>();

    public static <T> T getObjectByClass(final Class<T> clazz) {
        return (T) objectByClassName.get(clazz.getName());
    }
}
