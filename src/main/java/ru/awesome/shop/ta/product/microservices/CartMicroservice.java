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

public class CartMicroservice extends BaseMicroservice {
    public CartMicroservice(HttpClient httpClient) {
        super(httpClient);
    }

    public HttpResponse<ChangeCartResponseBody> addItem(AddItemRequestBody addItemRequestBody, String token) throws JsonProcessingException, ParseException {
        JSONObject requestBody = convertObjectToJson(addItemRequestBody);
        HttpResponse httpResponse = this.httpClient.post(Routes.addItem(), requestBody, token);
        ChangeCartResponseBody changeCartResponseBody = mapper.convertValue(httpResponse.getBody(), ChangeCartResponseBody.class);
        httpResponse.setBody(changeCartResponseBody);
        return httpResponse;
    }

    public HttpResponse<OpenCartResponseBody> openCart(String token) {
        JSONObject requestBody = new JSONObject();
        HttpResponse httpResponse = this.httpClient.post(Routes.openCart(), requestBody, token);
        OpenCartResponseBody openCartResponseBody = mapper.convertValue(httpResponse.getBody(), OpenCartResponseBody.class);
        httpResponse.setBody(openCartResponseBody);
        return httpResponse;
    }

    public HttpResponse<ChangeCartResponseBody> editCart(EditCartRequestBody editCartRequestBody, String token) throws JsonProcessingException, ParseException {
        JSONObject requestBody = convertObjectToJson(editCartRequestBody);
        HttpResponse httpResponse = this.httpClient.post(Routes.editCart(), requestBody, token);
        ChangeCartResponseBody changeCartResponseBody = mapper.convertValue(httpResponse.getBody(), ChangeCartResponseBody.class);
        httpResponse.setBody(changeCartResponseBody);
        return httpResponse;
    }

    public HttpResponse<ChangeCartResponseBody> removeItemFromCart(RemoveItemRequestBody deleteItemRequestBody, String token) throws JsonProcessingException, ParseException {
        JSONObject requestBody = convertObjectToJson(deleteItemRequestBody);
        HttpResponse httpResponse = this.httpClient.post(Routes.removeItem(), requestBody, token);
        ChangeCartResponseBody changeCartResponseBody = mapper.convertValue(httpResponse.getBody(), ChangeCartResponseBody.class);
        httpResponse.setBody(changeCartResponseBody);
        return httpResponse;
    }
}
