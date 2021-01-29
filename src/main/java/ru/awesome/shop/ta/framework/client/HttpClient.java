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
    private final String baseUrl = "https://awesome-shop.01sh.ru";
    private final Map<String, String> defaultHeaders = new HashMap<>();
    private JSONObject body;
    private int codeResponse;
    private Response response;

    public HttpClient() {
    }

    public HttpResponse<JSONObject> get(String relativeUrl, Map<String, String> requestHeaders) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.headers(requestHeaders);
        response = request.get(relativeUrl);
        return prepareHttpResponse(response);
    }

    public HttpResponse<JSONObject> get(String relativeUrl) {
        return get(relativeUrl, defaultHeaders);
    }

    public HttpResponse<JSONObject> post(String relativeUrl, Map<String, String> requestHeaders, JSONObject requestBody, String token) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.queryParam("token", token);
        request.headers(requestHeaders);
        request.params(requestBody);
        response = request.post(relativeUrl);
        return prepareHttpResponse(response);
    }

    public HttpResponse<JSONObject> post(String relativeUrl, JSONObject requestBody, String token) {
        return post(relativeUrl, defaultHeaders, requestBody, token);
    }

    public HttpResponse<JSONObject> put(String relativeUrl, Map<String, String> requestHeaders, JSONObject requestBody) {
        Map<String, String> headers = new HashMap<>();
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.headers(requestHeaders);
        response = request.params(requestBody).put(relativeUrl);
        return prepareHttpResponse(response);
    }

    public HttpResponse<JSONObject> put(String relativeUrl, JSONObject requestBody) {
        return put(relativeUrl, defaultHeaders, requestBody);
    }

    public HttpResponse<JSONObject> delete(String relativeUrl, Map<String, String> requestHeaders) {
        Map<String, String> headers = new HashMap<>();
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.headers(requestHeaders);
        response = request.delete(relativeUrl);
        return prepareHttpResponse(response);
    }

    public HttpResponse<JSONObject> delete(String relativeUrl) {
        return delete(relativeUrl, defaultHeaders);
    }

    private HttpResponse<JSONObject> prepareHttpResponse(Response response) {
        JSONObject body = response.body().as(JSONObject.class);
        int responseCode = response.getStatusCode();
        Map<String, String> headers = new HashMap<>();
        for (Header header : response.headers()) {
            headers.put(header.getName(), header.getValue());
        }
        return new HttpResponse<>(responseCode, headers, body);
    }
}




