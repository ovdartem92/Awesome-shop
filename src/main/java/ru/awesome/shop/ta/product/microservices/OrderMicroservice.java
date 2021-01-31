package ru.awesome.shop.ta.product.microservices;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.response.OrderResponseBody;
import ru.awesome.shop.ta.product.http.body.request.OrderRequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static ru.awesome.shop.ta.utils.JsonRepresentation.convertFromJson;
import static ru.awesome.shop.ta.utils.JsonRepresentation.convertToJson;

public class OrderMicroservice extends BaseMicroservice {
    private String token;

    public OrderMicroservice(HttpClient httpClient, String token) {
        super(httpClient);
        Objects.requireNonNull(token, "Token cannot be null");
        this.token = token;
    }

    public HttpResponse<OrderResponseBody> addOrder(OrderRequestBody requestBody) throws ParseException {
        String relativeUrl = "api/order/add";
        return performRequest(relativeUrl, requestBody);
    }

    public HttpResponse<OrderResponseBody> editOrder(OrderRequestBody requestBody) throws ParseException {
        String relativeUrl = "api/order/edit";
        return performRequest(relativeUrl, requestBody);
    }

    public HttpResponse<OrderResponseBody> deleteOrder(OrderRequestBody requestBody) throws ParseException {
        String relativeUrl = "api/order/delete";
        return performRequest(relativeUrl, requestBody);
    }

    public HttpResponse<OrderResponseBody> getOrderInfo(OrderRequestBody requestBody) throws ParseException {
        String relativeUrl = "api/order/info";
        return performRequest(relativeUrl, requestBody);
    }

    public HttpResponse<OrderResponseBody> getOrderHistory(OrderRequestBody requestBody) throws ParseException {
        String relativeUrl = "api/order/history";
        return performRequest(relativeUrl, requestBody);
    }

    private HttpResponse<OrderResponseBody> performRequest(String relativeUrl, OrderRequestBody orderRequestBody)
            throws ParseException {
        Objects.requireNonNull(orderRequestBody, "Customer request body cannot be null");
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("token", this.token);
        queryParameters.put(ROUTE, relativeUrl);
        JSONObject requestBody = convertToJson(orderRequestBody);
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(COMMON_URL, queryParameters, requestBody);
        OrderResponseBody orderResponseBody = convertFromJson(httpResponse.getBody(), OrderResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(),
                httpResponse.getHeaders(), orderResponseBody);
    }

}
