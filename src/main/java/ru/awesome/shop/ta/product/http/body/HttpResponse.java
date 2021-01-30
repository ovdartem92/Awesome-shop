package ru.awesome.shop.ta.product.http.body;

import java.util.Map;

public class HttpResponse<T> {
    private int statusCode;
    private Map<String, String> headers;
    private T body;

    public HttpResponse(int responseStatusCode, Map<String, String> headers, T body) {
        this.statusCode = responseStatusCode;
        this.headers = headers;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public T getBody() {
        return body;
    }
}
