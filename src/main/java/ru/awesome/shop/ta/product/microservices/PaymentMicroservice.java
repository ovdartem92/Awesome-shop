package ru.awesome.shop.ta.product.microservices;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.body.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.AddressRequestBody;
import ru.awesome.shop.ta.product.http.body.request.PaymentRequestBody;
import ru.awesome.shop.ta.product.http.body.response.PaymentResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PaymentMicroservice extends BaseMicroservice {

    public PaymentMicroservice(HttpClient httpClient) {
        super(httpClient);
    }

    public HttpResponse<PaymentResponseBody> addPaymentAddress(AddressRequestBody paymentCreationRequestBody) throws IOException, ParseException {
        JSONObject requestBody = convertObjectToJson(paymentCreationRequestBody);
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("route", "api/payment/address");
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(commonUrl, queryParameters, requestBody);
        PaymentResponseBody paymentResponseBody = mapper.convertValue(httpResponse.getBody(), PaymentResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(), paymentResponseBody);
    }

    public HttpResponse<PaymentResponseBody> setPayments(PaymentRequestBody paymentCreationRequestBody) throws IOException, ParseException {
        JSONObject requestBody = convertObjectToJson(paymentCreationRequestBody);
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("route", "api/payment/method");
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(commonUrl, queryParameters, requestBody);
        PaymentResponseBody paymentResponseBody = mapper.convertValue(httpResponse.getBody(), PaymentResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(), paymentResponseBody);
    }

    public HttpResponse<PaymentResponseBody> getPayments() {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("route", "api/payment/methods");
        HttpResponse<JSONObject> httpResponse = this.httpClient.get(commonUrl, queryParameters);
        PaymentResponseBody paymentResponseBody = mapper.convertValue(httpResponse.getBody(), PaymentResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(), paymentResponseBody);
    }
}
