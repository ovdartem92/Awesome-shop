package ru.awesome.shop.ta.product.microservices;

import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.OrderCreationRequestBody;
import ru.awesome.shop.ta.product.http.body.response.OrderCreationResponseBody;

public class OrderMicroservice {
    private HttpClient httpClient;
    public OrderMicroservice(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

// OrderCreationRequestBody - POJO

// OrderCreationResponseBody - POJO

    public HttpResponse<OrderCreationResponseBody> createOrder(OrderCreationRequestBody orderCreationRequestBody) {

        String orderCreationUrl = "api/order/add";

// TODO: Convert orderCreationRequestBody to JSONObject

        JSONObject orderCreationJsonRequestBody = . . .;

        HttpResponse<JSONObject> orderResponse = this.httpClient.post(orderCreationUrl, orderCreationJsonRequestBody);

        JSONObject body = orderResponse.getBody();

// TODO: Convert body (JSONObject) to instance of OrderCreationResponseBody

. . .

    }
}
