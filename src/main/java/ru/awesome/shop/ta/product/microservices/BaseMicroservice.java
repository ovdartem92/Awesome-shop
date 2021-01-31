package ru.awesome.shop.ta.product.microservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.framework.client.HttpClient;

import java.util.Objects;

public class BaseMicroservice {
    protected HttpClient httpClient;
    protected ObjectMapper mapper = new ObjectMapper();
    protected String commonUrl = "/index.php";

    public BaseMicroservice(HttpClient httpClient) {
        Objects.requireNonNull(httpClient, "HttpClient cannot be null");
        this.httpClient = httpClient;
    }

    protected JSONObject convertObjectToJson(Object object) throws ParseException, JsonProcessingException {
        String jsonString = mapper.writeValueAsString(object);
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(jsonString);
    }
}
