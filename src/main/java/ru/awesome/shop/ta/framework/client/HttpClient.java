package ru.awesome.shop.ta.framework.client;

import org.json.simple.JSONObject;
import ru.awesome.shop.ta.product.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class HttpClient {

    private final String baseUrl = "https://awesome-shop.01sh.ru/index.php?";
    private final Map<String, String> defaultHeaders = new HashMap<>();

    public HttpClient() {
        defaultHeaders.put();
    }

    public HttpResponse<JSONObject> get(String relativeUrl, Map<String, String> requestHeaders) {
        new HttpResponse<>()
    }


    public HttpResponse<JSONObject> get(String relativeUrl) {

        return get(relativeUrl, defaultHeaders);

    }


    public HttpResponse<JSONObject> post(String relativeUrl, Map<String, String> requestHeaders, JSONObject requestBody) {

    }


    public HttpResponse<JSONObject> post(String relativeUrl, JSONObject requestBody) {

        return post(relativeUrl, defaultHeaders, requestBody);

    }


    public HttpResponse<JSONObject> put(String relativeUrl, Map<String, String> requestHeaders, JSONObject requestBody) {

    }


    public HttpResponse<JSONObject> put(String relativeUrl, JSONObject requestBody) {

        return put(relativeUrl, defaultHeaders, requestBody);

    }


    public HttpResponse<JSONObject> delete(String relativeUrl, Map<String, String> requestHeaders) {

    }


    public HttpResponse<JSONObject> delete(String relativeUrl) {

        return delete(relativeUrl, defaultHeaders);

    }

}

