package ru.awesome.shop.ta.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Objects;

public final class JsonRepresentation {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private JsonRepresentation() {
        throw new AssertionError(String.format("Creation of instance of %s is prohibited.", JsonRepresentation.class));
    }

    public static String convertToJsonString(Object object) {
        Objects.requireNonNull(object, "Object cannot be null.");
        return gson.toJson(object);
    }

    public static <T> T convertFromJson(JSONObject jsonObject, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(jsonObject, clazz);
    }

    public static JSONObject convertToJson(Object object) throws JsonProcessingException, ParseException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(object);
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(jsonString);
    }
}
