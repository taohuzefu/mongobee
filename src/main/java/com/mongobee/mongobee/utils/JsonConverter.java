package com.mongobee.mongobee.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class JsonConverter {

  public static String convertObjectToJsonString(Object object) throws JsonProcessingException {
    return new ObjectMapper().writeValueAsString(object);
  }

  public static <E> E convertJsonToObject(String jsonPath, TypeReference<E> typeReference)
      throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    Resource classPathResource = new ClassPathResource(jsonPath);
    return objectMapper.readValue(classPathResource.getInputStream(), typeReference);
  }

  public static <T> T convertJsonToObject(String jsonPath, Class<T> clazz) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    Resource classPathResource = new ClassPathResource(jsonPath);
    return mapper.readValue(classPathResource.getInputStream(), clazz);
  }
}
