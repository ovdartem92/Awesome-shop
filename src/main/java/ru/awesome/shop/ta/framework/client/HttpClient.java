package ru.awesome.shop.ta.framework.client;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import ru.awesome.shop.ta.product.http.body.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class HttpClient {
    private final String baseUrl = "https://awesome-shop.01sh.ru";
    private final Map<String, String> defaultHeaders = new HashMap<>();

    public HttpClient() {
        RestAssured.baseURI = baseUrl;
    }

    private Map<String, String> convertHeaders(Headers headers) {
        Map<String, String> buffer = new HashMap<>();
        for (Header header : headers.asList()) {
            buffer.put(header.getName(), header.getValue());
        }
        return buffer;
    }

    public HttpResponse<JSONObject> get(String relativeUrl, Map<String, String> requestHeaders) {
        int statusCode;
        Response response;
        JSONObject body;
        RequestSpecification request = RestAssured.given();
        request.headers(requestHeaders);
        response = request.get(relativeUrl);
        body = response.body().as(JSONObject.class);
        statusCode = response.getStatusCode();
        return new HttpResponse<>(statusCode, convertHeaders(response.headers()), body);
    }

    public HttpResponse<JSONObject> get(String relativeUrl) {
        return get(relativeUrl, defaultHeaders);
    }

    public HttpResponse<JSONObject> post(String relativeUrl, Map<String, String> requestHeaders, JSONObject requestBody) {
        int statusCode;
        Response response;
        JSONObject body;
        RequestSpecification request = RestAssured.given();
        request.headers(requestHeaders);
        request.params(requestBody);
        response = request.post(relativeUrl);
        body = response.getBody().as(JSONObject.class);
        statusCode = response.getStatusCode();
        return new HttpResponse<>(statusCode, convertHeaders(response.headers()), body);
    }

    public HttpResponse<JSONObject> post(String relativeUrl, JSONObject requestBody) {
        return post(relativeUrl, defaultHeaders, requestBody);
    }

    public HttpResponse<JSONObject> put(String relativeUrl, Map<String, String> requestHeaders, JSONObject requestBody) {
        int statusCode;
        Response response;
        JSONObject body;
        RequestSpecification request = RestAssured.given();
        request.headers(requestHeaders);
        response = request.params(requestBody).put(relativeUrl);
        body = response.body().as(JSONObject.class);
        statusCode = response.getStatusCode();
        return new HttpResponse<>(statusCode, convertHeaders(response.headers()), body);
    }

    public HttpResponse<JSONObject> put(String relativeUrl, JSONObject requestBody) {
        return put(relativeUrl, defaultHeaders, requestBody);
    }

    public HttpResponse<JSONObject> delete(String relativeUrl, Map<String, String> requestHeaders) {
        int statusCode;
        Response response;
        JSONObject body;
        RequestSpecification request = RestAssured.given();
        request.headers(requestHeaders);
        response = request.delete(relativeUrl);
        body = response.body().as(JSONObject.class);
        statusCode = response.getStatusCode();
        return new HttpResponse<>(statusCode, convertHeaders(response.headers()), body);
    }

    public HttpResponse<JSONObject> delete(String relativeUrl) {
        return delete(relativeUrl, defaultHeaders);
    }
}
