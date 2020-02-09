package com.bestprice.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/** DeSerializes the {@link String} passed to it into given Type T */
public final class Deserializer {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  public static <T> T deserialize(String content, Class<T> type) throws IOException {
    return MAPPER.readValue(content, type);
  }
}
