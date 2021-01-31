package ru.awesome.shop.ta.product.microservices;

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

import static ru.awesome.shop.ta.utils.JsonRepresentation.convertFromJson;
import static ru.awesome.shop.ta.utils.JsonRepresentation.convertToJson;

public class CartMicroservice extends BaseMicroservice {
    private String token;
    private Map<String, String> queryParameters;

    public CartMicroservice(HttpClient httpClient, String token) {
        super(httpClient);
        Objects.requireNonNull(token, "Token cannot be null");
        this.token = token;
        queryParameters = new HashMap<>();
        queryParameters.put("token", this.token);
    }

    public HttpResponse<ChangeCartResponseBody> addItem(AddItemRequestBody addItemRequestBody) throws ParseException {
        Objects.requireNonNull(addItemRequestBody, "Add item response body cannot be null");
        queryParameters.put("route", "api/cart/add");  //NOSONAR
        JSONObject requestBody = convertToJson(addItemRequestBody);
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(commonUrl,
                queryParameters, requestBody);
        ChangeCartResponseBody changeCartResponseBody = convertFromJson(httpResponse.getBody(),
                ChangeCartResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                changeCartResponseBody);
    }

    public HttpResponse<OpenCartResponseBody> openCart() {
        queryParameters.put("route", "api/cart/products"); //NOSONAR
        JSONObject requestBody = new JSONObject();
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(commonUrl,
                queryParameters, requestBody);
        OpenCartResponseBody openCartResponseBody = convertFromJson(httpResponse.getBody(),
                OpenCartResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                openCartResponseBody);
    }

    public HttpResponse<ChangeCartResponseBody> editCart(EditCartRequestBody editCartRequestBody)
            throws ParseException {
        Objects.requireNonNull(editCartRequestBody, "Edit cart response body cannot be null");
        queryParameters.put("route", "api/cart/edit"); //NOSONAR
        JSONObject requestBody = convertToJson(editCartRequestBody);
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(commonUrl, queryParameters,
                requestBody);
        ChangeCartResponseBody changeCartResponseBody = convertFromJson(httpResponse.getBody(),
                ChangeCartResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                changeCartResponseBody);
    }

    public HttpResponse<ChangeCartResponseBody> removeItemFromCart(RemoveItemRequestBody removeItemRequestBody)
            throws ParseException {
        Objects.requireNonNull(removeItemRequestBody, "Remove item response body cannot be null");
        queryParameters.put("route", "api/cart/remove"); //NOSONAR
        JSONObject requestBody = convertToJson(removeItemRequestBody);
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(commonUrl,
                queryParameters, requestBody);
        ChangeCartResponseBody changeCartResponseBody = convertFromJson(httpResponse.getBody(),
                ChangeCartResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                changeCartResponseBody);
    }
}
