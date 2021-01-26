package ru.awesome.shop.ta.product.http;

import java.util.Map;

public class HttpResponse<T> {
    private int responseStatusCode;
    private Map<String, String> headers;
    private T body;

    public HttpResponse(int responseStatusCode, Map<String, String> headers, T body) {

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
