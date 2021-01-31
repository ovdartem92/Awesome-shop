package ru.awesome.shop.ta.framework.client;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import ru.awesome.shop.ta.product.http.body.HttpResponse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HttpClient {
    private final String BASE_URL = "https://awesome-shop.01sh.ru";
    private final Map<String, String> defaultHeaders = new HashMap<>();

    public HttpClient() {
        RestAssured.baseURI = BASE_URL;
    }

    public HttpResponse<JSONObject> get(String relativeUrl, Map<String,
            String> queryParameters, Map<String, String> requestHeaders) {
        Objects.requireNonNull(relativeUrl, "Relative URL cannot be null.");    //NOSONAR
        Objects.requireNonNull(queryParameters, "Query parameters cannot be null.");
        Objects.requireNonNull(requestHeaders, "Request header URL cannot be null."); //NOSONAR
        RequestSpecification request = RestAssured.given();
        request.queryParams(queryParameters);
        request.headers(requestHeaders);
        Response response = request.get(relativeUrl);
        return prepareHttpResponse(response);
    }

    public HttpResponse<JSONObject> get(String relativeUrl) {
        return get(relativeUrl, Collections.emptyMap(), defaultHeaders);
    }

    public HttpResponse<JSONObject> get(String relativeUrl, Map<String,
            String> queryParameters) {
        return get(relativeUrl, queryParameters, defaultHeaders);
    }

    public HttpResponse<JSONObject> post(String relativeUrl, Map<String,
            String> queryParameters, JSONObject requestBody) {
        return post(relativeUrl, queryParameters, defaultHeaders, requestBody);
    }

    public HttpResponse<JSONObject> post(String relativeUrl, Map<String, String> queryParameters,
                                         Map<String, String> requestHeaders, JSONObject requestBody) {
        Objects.requireNonNull(relativeUrl, "Relative URL cannot be null.");
        Objects.requireNonNull(queryParameters, "Query parameters cannot be null.");
        Objects.requireNonNull(requestHeaders, "Request header cannot be null."); //NOSONAR
        Objects.requireNonNull(requestBody, "Request body cannot be null.");
        RequestSpecification request = RestAssured.given();
        request.queryParams(queryParameters);
        request.headers(requestHeaders);
        request.params(requestBody);
        Response response = request.post(relativeUrl);
        return prepareHttpResponse(response);
    }

    public HttpResponse<JSONObject> post(String relativeUrl, JSONObject requestBody) {
        return post(relativeUrl, Collections.emptyMap(), defaultHeaders, requestBody);
    }

    public HttpResponse<JSONObject> put(String relativeUrl, Map<String,
            String> requestHeaders, JSONObject requestBody) {
        Objects.requireNonNull(relativeUrl, "Relative URL cannot be null.");
        Objects.requireNonNull(requestHeaders, "Request header cannot be null.");
        Objects.requireNonNull(requestBody, "Request body cannot be null.");
        RequestSpecification request = RestAssured.given();
        request.headers(requestHeaders);
        Response response = request.params(requestBody).put(relativeUrl);
        return prepareHttpResponse(response);
    }

    public HttpResponse<JSONObject> put(String relativeUrl, JSONObject requestBody) {
        return put(relativeUrl, defaultHeaders, requestBody);
    }

    public HttpResponse<JSONObject> delete(String relativeUrl, Map<String, String> requestHeaders) {
        Objects.requireNonNull(relativeUrl, "Relative URL cannot be null.");
        Objects.requireNonNull(requestHeaders, "Request header cannot be null.");
        RequestSpecification request = RestAssured.given();
        request.headers(requestHeaders);
        Response response = request.delete(relativeUrl);
        return prepareHttpResponse(response);
    }

    public HttpResponse<JSONObject> delete(String relativeUrl) {
        return delete(relativeUrl, defaultHeaders);
    }

    private HttpResponse<JSONObject> prepareHttpResponse(Response response) {
        Objects.requireNonNull(response, "Response cannot be null.");
        JSONObject body = response.body().as(JSONObject.class);
        int responseCode = response.getStatusCode();
        Map<String, String> headers = convertHeaders(response.headers());
        return new HttpResponse<>(responseCode, headers, body);
    }

    private Map<String, String> convertHeaders(Headers headers) {
        Objects.requireNonNull(headers, "Headers cannot be null.");
        Map<String, String> headersMap = new HashMap<>();
        for (Header header : headers) {
            headersMap.put(header.getName(), header.getValue());
        }
        return headersMap;
    }
}
