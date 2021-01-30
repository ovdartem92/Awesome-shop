package ru.awesome.shop.ta.product.microservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.AddItemRequestBody;
import ru.awesome.shop.ta.product.http.body.request.RemoveItemRequestBody;
import ru.awesome.shop.ta.product.http.body.request.EditCartRequestBody;
import ru.awesome.shop.ta.product.http.body.response.ChangeCartResponseBody;
import ru.awesome.shop.ta.product.http.body.response.OpenCartResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CartMicroservice extends BaseMicroservice {
    private String token;

    public CartMicroservice(HttpClient httpClient, String token) {
        super(httpClient);
        Objects.requireNonNull(token, "Token cannot be null");
        this.token = token;

    }

    public HttpResponse<ChangeCartResponseBody> addItem(AddItemRequestBody addItemRequestBody)
            throws JsonProcessingException, ParseException {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("token", this.token);
        queryParameters.put("route", "api/cart/add");
        JSONObject requestBody = convertObjectToJson(addItemRequestBody);
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(commonUrl,
                queryParameters, requestBody);
        ChangeCartResponseBody changeCartResponseBody = mapper.convertValue(httpResponse.getBody(),
                ChangeCartResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                changeCartResponseBody);
    }

    public HttpResponse<OpenCartResponseBody> openCart() {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("token", this.token);
        queryParameters.put("route", "api/cart/products");
        JSONObject requestBody = new JSONObject();
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(commonUrl,
                queryParameters, requestBody);
        OpenCartResponseBody openCartResponseBody = mapper.convertValue(httpResponse.getBody(),
                OpenCartResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                openCartResponseBody);
    }

    public HttpResponse<ChangeCartResponseBody> editCart(EditCartRequestBody editCartRequestBody)
            throws JsonProcessingException, ParseException {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("token", this.token);
        queryParameters.put("route", "api/cart/edit");
        JSONObject requestBody = convertObjectToJson(editCartRequestBody);
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(commonUrl, queryParameters,
                requestBody);
        ChangeCartResponseBody changeCartResponseBody = mapper.convertValue(httpResponse.getBody(),
                ChangeCartResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                changeCartResponseBody);
    }

    public HttpResponse<ChangeCartResponseBody> removeItemFromCart(RemoveItemRequestBody deleteItemRequestBody)
            throws JsonProcessingException, ParseException {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("token", this.token);
        queryParameters.put("route", "api/cart/remove");
        JSONObject requestBody = convertObjectToJson(deleteItemRequestBody);
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(commonUrl,
                queryParameters, requestBody);
        ChangeCartResponseBody changeCartResponseBody = mapper.convertValue(httpResponse.getBody(),
                ChangeCartResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                changeCartResponseBody);
    }
}
