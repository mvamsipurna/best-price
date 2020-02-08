package com.bestprice.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/** Class that serializes any Java object passed to it as {@link String} */
public final class Serializer {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public static String serialize(Object objectToSerialize) throws JsonProcessingException {
        return MAPPER.writeValueAsString(objectToSerialize);
    }
}
