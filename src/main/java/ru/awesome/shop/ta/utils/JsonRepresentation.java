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
        String jsonString = convertToJsonString(jsonObject);
        return gson.fromJson(jsonString, clazz);
    }

    public static JSONObject convertToJson(Object object) throws ParseException {
        String jsonString = convertToJsonString(object);
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(jsonString);
    }
}
