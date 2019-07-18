package com.mongobee.mongobee.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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


  public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
    InputStream is = new FileInputStream(filePath);
    String line; // 用来保存每行读取的内容
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    line = reader.readLine(); // 读取第一行
    while (line != null) { // 如果 line 为空说明读完了
      buffer.append(line); // 将读到的内容添加到 buffer 中
      buffer.append("\n"); // 添加换行符
      line = reader.readLine(); // 读取下一行
    }
    reader.close();
    is.close();
  }
}
