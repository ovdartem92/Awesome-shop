package ru.awesome.shop.ta.framework.client;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import ru.awesome.shop.ta.product.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HttpClient {
    private static final String BASE_URL = "https://awesome-shop.01sh.ru";
    private final Map<String, String> defaultHeaders = new HashMap<>();

    public HttpClient() {
        RestAssured.baseURI = BASE_URL;
    }

    private HttpResponse<JSONObject> get(String relativeUrl, Map<String, String> queryParameters,
                                         Map<String, String> requestHeaders) {
        RequestSpecification request = RestAssured.given();
        request.queryParams(queryParameters);
        request.headers(requestHeaders);
        Response response = request.get(relativeUrl);
        return prepareHttpResponse(response);
    }

    public HttpResponse<JSONObject> get(String relativeUrl, Map<String, String> queryParameters) {
        Objects.requireNonNull(relativeUrl, "Relative URL cannot be null.");    //NOSONAR
        Objects.requireNonNull(queryParameters, "Query parameters cannot be null.");
        return get(relativeUrl, queryParameters, defaultHeaders);
    }

    public HttpResponse<JSONObject> post(String relativeUrl, Map<String, String> queryParameters, JSONObject requestBody) {
        Objects.requireNonNull(relativeUrl, "Relative URL cannot be null.");           //NOSONAR
        Objects.requireNonNull(queryParameters, "Query parameters cannot be null.");
        Objects.requireNonNull(requestBody, "Request body cannot be null");
        return post(relativeUrl, queryParameters, defaultHeaders, requestBody);
    }

    private HttpResponse<JSONObject> post(String relativeUrl, Map<String, String> queryParameters,
                                          Map<String, String> requestHeaders, JSONObject requestBody) {
        RequestSpecification request = RestAssured.given();
        request.queryParams(queryParameters);
        request.headers(requestHeaders);
        request.params(requestBody);
        Response response = request.post(relativeUrl);
        return prepareHttpResponse(response);
    }

    private HttpResponse<JSONObject> put(String relativeUrl, Map<String, String> requestHeaders, JSONObject requestBody) {
        RequestSpecification request = RestAssured.given();
        request.headers(requestHeaders);
        Response response = request.params(requestBody).put(relativeUrl);
        return prepareHttpResponse(response);
    }

    public HttpResponse<JSONObject> put(String relativeUrl, JSONObject requestBody) {
        Objects.requireNonNull(relativeUrl, "Relative URL cannot be null.");               //NOSONAR
        Objects.requireNonNull(requestBody, "Request body cannot be null");
        return put(relativeUrl, defaultHeaders, requestBody);
    }

    private HttpResponse<JSONObject> delete(String relativeUrl, Map<String, String> requestHeaders) {
        RequestSpecification request = RestAssured.given();
        request.headers(requestHeaders);
        Response response = request.delete(relativeUrl);
        return prepareHttpResponse(response);
    }

    public HttpResponse<JSONObject> delete(String relativeUrl) {
        Objects.requireNonNull(relativeUrl, "Relative URL cannot be null.");      //NOSONAR
        return delete(relativeUrl, defaultHeaders);
    }

    private HttpResponse<JSONObject> prepareHttpResponse(Response response) {
        JSONObject body = response.body().as(JSONObject.class);
        int responseCode = response.getStatusCode();
        Map<String, String> headers = convertHeaders(response.headers());
        return new HttpResponse<>(responseCode, headers, body);
    }

    private Map<String, String> convertHeaders(Headers headers) {
        Map<String, String> headersMap = new HashMap<>();
        for (Header header : headers) {
            headersMap.put(header.getName(), header.getValue());
        }
        return headersMap;
    }
}
