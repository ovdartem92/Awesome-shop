package ru.awesome.shop.ta.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Objects;

public final class JsonRepresentation {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private JsonRepresentation() {
        throw new AssertionError(String.format("Creation of instance of %s is prohibited.", JsonRepresentation.class));
    }

    public static String convertToJson(Object object) {
        Objects.requireNonNull(object, "Object cannot be null.");
        return gson.toJson(object);
    }
}