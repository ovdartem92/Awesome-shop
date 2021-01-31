package ru.awesome.shop.ta.product.microservices;

import ru.awesome.shop.ta.framework.client.HttpClient;

import java.util.Objects;

public class BaseMicroservice {
    protected HttpClient httpClient;
    protected String commonUrl = "/index.php";

    public BaseMicroservice(HttpClient httpClient) {
        Objects.requireNonNull(httpClient, "Http client cannot be null");
        this.httpClient = httpClient;
    }
}
