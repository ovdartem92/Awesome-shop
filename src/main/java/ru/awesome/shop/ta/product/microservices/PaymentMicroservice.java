package ru.awesome.shop.ta.product.microservices;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.AddressRequestBody;
import ru.awesome.shop.ta.product.http.body.request.PaymentRequestBody;
import ru.awesome.shop.ta.product.http.body.response.PaymentResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static ru.awesome.shop.ta.utils.JsonRepresentation.convertFromJson;
import static ru.awesome.shop.ta.utils.JsonRepresentation.convertToJson;

public class PaymentMicroservice extends BaseMicroservice {

    public PaymentMicroservice(HttpClient httpClient) {
        super(httpClient);
    }

    public HttpResponse<PaymentResponseBody> addPaymentAddress
            (AddressRequestBody addressRequestBody) throws ParseException, org.json.simple.parser.ParseException {
        Objects.requireNonNull(addressRequestBody, "AddressRequestBody cannot be null");
        JSONObject requestBody = convertToJson(addressRequestBody);
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("route", "api/payment/address");//NOSONAR
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(COMMON_URL, queryParameters, requestBody);
        PaymentResponseBody paymentResponseBody = convertFromJson(httpResponse.getBody(), PaymentResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(), paymentResponseBody);
    }

    public HttpResponse<PaymentResponseBody> setPayments
            (PaymentRequestBody paymentCreationRequestBody) throws ParseException {
        Objects.requireNonNull(paymentCreationRequestBody, "PaymentRequestBody cannot be null");
        JSONObject requestBody = convertToJson(paymentCreationRequestBody);
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("route", "api/payment/method");
        ru.awesome.shop.ta.product.http.HttpResponse<JSONObject> httpResponse = this.httpClient.post(COMMON_URL, queryParameters, requestBody);
        PaymentResponseBody paymentResponseBody = convertFromJson(httpResponse.getBody(), PaymentResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(), paymentResponseBody);
    }

    public HttpResponse<PaymentResponseBody> getPayments() {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("route", "api/payment/methods");
        HttpResponse<JSONObject> httpResponse = this.httpClient.get(COMMON_URL, queryParameters);
        PaymentResponseBody paymentResponseBody = convertFromJson(httpResponse.getBody(), PaymentResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(), paymentResponseBody);
    }
}
