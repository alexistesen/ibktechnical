package com.ibk.ibktechnical.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {

  public static String generateRandomId(){
    return IntStream.range(0, 10)
        .mapToObj(i -> String.valueOf((int) (Math.random() * 10)))
        .collect(Collectors.joining());
  }

  public static String toJson(Object object) {
    try {
      return new ObjectMapper().writeValueAsString(object);
    } catch (Exception e) {
      return "{}";
    }
  }

}
