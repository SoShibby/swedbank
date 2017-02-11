package com.github.soshibby.swedbank.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Henrik on 31/01/2017.
 */
public class Config {

    private static JsonNode config;

    static {
        try {
            InputStream inputStream = Config.class.getClassLoader().getResourceAsStream("config.json");
            config = new ObjectMapper().readTree(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String asString(String key) {
        return config.get(key).asText();
    }

}
