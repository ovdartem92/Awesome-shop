package ru.awesome.shop.ta.framework.client;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import ru.awesome.shop.ta.product.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class HttpClient {
    private final String baseUrl = "http://localhost:9999";
    private final Map<String, String> defaultHeaders = new HashMap<>();
    private JSONObject body;
    private int codeResponse;

    public HttpClient() {
        defaultHeaders.put("Content-Type", "application/json");
    }

    public HttpResponse<JSONObject> get(String relativeUrl, Map<String, String> requestHeaders) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.headers(requestHeaders);
        request.get(relativeUrl);
        Response response = request.get(relativeUrl);
        body = response.body().as(JSONObject.class);
        codeResponse = response.getStatusCode();
        Map<String, String> headers = new HashMap<>();
        for (Header header : response.headers()) {
            headers.put(header.getName(), header.getValue());
        }
        return new HttpResponse<>(codeResponse, headers, body);
    }

    public HttpResponse<JSONObject> get(String relativeUrl) {
        return get(relativeUrl, defaultHeaders);
    }

    public HttpResponse<JSONObject> post(String relativeUrl, Map<String, String> requestHeaders, JSONObject requestBody) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.headers(requestHeaders);
        Response response = request.body(requestBody).post(relativeUrl);
        body = response.body().as(JSONObject.class);
        codeResponse = response.getStatusCode();
        Map<String, String> headers = new HashMap<>();
        for (Header header : response.headers()) {
            headers.put(header.getName(), header.getValue());
        }
        return new HttpResponse<>(codeResponse, headers, body);
    }

    public HttpResponse<JSONObject> post(String relativeUrl, JSONObject requestBody) {
        return post(relativeUrl, defaultHeaders, requestBody);
    }

    public HttpResponse<JSONObject> put(String relativeUrl, Map<String, String> requestHeaders, JSONObject requestBody) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.headers(requestHeaders);
        Response response = request.body(requestBody).put(relativeUrl);
        body = response.body().as(JSONObject.class);
        codeResponse = response.getStatusCode();
        Map<String, String> headers = new HashMap<>();
        for (Header header : response.headers()) {
            headers.put(header.getName(), header.getValue());
        }
        return new HttpResponse<>(codeResponse, headers, body);
    }

    public HttpResponse<JSONObject> put(String relativeUrl, JSONObject requestBody) {
        return put(relativeUrl, defaultHeaders, requestBody);
    }

    public HttpResponse<JSONObject> delete(String relativeUrl, Map<String, String> requestHeaders) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.headers(requestHeaders);
        Response response = request.delete(relativeUrl);
        body = response.body().as(JSONObject.class);
        codeResponse = response.getStatusCode();
        Map<String, String> headers = new HashMap<>();
        for (Header header : response.headers()) {
            headers.put(header.getName(), header.getValue());
        }
        return new HttpResponse<>(codeResponse, headers, body);
    }

    public HttpResponse<JSONObject> delete(String relativeUrl) {
        return delete(relativeUrl, defaultHeaders);
    }
}
