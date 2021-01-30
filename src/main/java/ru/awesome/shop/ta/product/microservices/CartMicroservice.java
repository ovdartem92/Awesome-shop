package ru.awesome.shop.ta.product.microservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.framework.client.Routes;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.AddItemRequestBody;
import ru.awesome.shop.ta.product.http.body.request.RemoveItemRequestBody;
import ru.awesome.shop.ta.product.http.body.request.EditCartRequestBody;
import ru.awesome.shop.ta.product.http.body.response.ChangeCartResponseBody;
import ru.awesome.shop.ta.product.http.body.response.OpenCartResponseBody;

import java.util.HashMap;
import java.util.Map;

public class CartMicroservice extends BaseMicroservice {
    public CartMicroservice(HttpClient httpClient) {
        super(httpClient);
    }

    public HttpResponse<ChangeCartResponseBody> addItem(AddItemRequestBody addItemRequestBody, String token)
            throws JsonProcessingException, ParseException {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("token", token);
        JSONObject requestBody = convertObjectToJson(addItemRequestBody);
        HttpResponse httpResponse = this.httpClient.post(Routes.addItem(), queryParameters, requestBody);
        ChangeCartResponseBody changeCartResponseBody = mapper.convertValue(httpResponse.getBody(),
                ChangeCartResponseBody.class);
        return new HttpResponse<ChangeCartResponseBody>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                changeCartResponseBody);
    }

    public HttpResponse<OpenCartResponseBody> openCart(String token) {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("token", token);
        JSONObject requestBody = new JSONObject();
        HttpResponse httpResponse = this.httpClient.post(Routes.openCart(), queryParameters, requestBody);
        OpenCartResponseBody openCartResponseBody = mapper.convertValue(httpResponse.getBody(),
                OpenCartResponseBody.class);
        return new HttpResponse<OpenCartResponseBody>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                openCartResponseBody);
    }

    public HttpResponse<ChangeCartResponseBody> editCart(EditCartRequestBody editCartRequestBody, String token)
            throws JsonProcessingException, ParseException {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("token", token);
        JSONObject requestBody = convertObjectToJson(editCartRequestBody);
        HttpResponse httpResponse = this.httpClient.post(Routes.editCart(), queryParameters, requestBody);
        ChangeCartResponseBody changeCartResponseBody = mapper.convertValue(httpResponse.getBody(),
                ChangeCartResponseBody.class);
        return new HttpResponse<ChangeCartResponseBody>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                changeCartResponseBody);
    }

    public HttpResponse<ChangeCartResponseBody> removeItemFromCart(RemoveItemRequestBody deleteItemRequestBody,
                                                                   String token) throws JsonProcessingException, ParseException {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("token", token);
        JSONObject requestBody = convertObjectToJson(deleteItemRequestBody);
        HttpResponse httpResponse = this.httpClient.post(Routes.removeItem(), queryParameters, requestBody);
        ChangeCartResponseBody changeCartResponseBody = mapper.convertValue(httpResponse.getBody(), ChangeCartResponseBody.class);
        return new HttpResponse<ChangeCartResponseBody>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                changeCartResponseBody);
    }
}
