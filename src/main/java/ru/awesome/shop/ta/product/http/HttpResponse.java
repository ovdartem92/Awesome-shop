package ru.awesome.shop.ta.product.http;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.Map;

public class HttpResponse<T> {
    private int responseStatusCode;
    private Map<String, String> headers;
    private T body;

    public HttpResponse(int responseStatusCode, Map<String, String> headers, T body) {
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put();
        request.response()
                .statusCode(responseStatusCode)
                .headers(headers)
                .body(requestParams.);


    }

    public int getResponseStatusCode() {
        return responseStatusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public T getBody() {
        return body;
    }
}
