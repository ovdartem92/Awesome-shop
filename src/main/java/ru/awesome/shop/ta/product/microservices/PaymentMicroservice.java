package ru.awesome.shop.ta.product.microservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.body.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.AddressRequestBody;
import ru.awesome.shop.ta.product.http.body.request.PaymentRequestBody;
import ru.awesome.shop.ta.product.http.body.response.PaymentResponseBody;

import java.io.IOException;

public class PaymentMicroservice {
    private HttpClient httpClient;

    public PaymentMicroservice(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public HttpResponse<PaymentResponseBody> addPaymentAddress(AddressRequestBody paymentCreationRequestBody) throws IOException {
        String relativeUrl = "/index.php?route=api/payment/address";
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(paymentCreationRequestBody);
        JSONObject jsonBody = mapper.readValue(jsonInString, JSONObject.class);
        HttpResponse<JSONObject> tokenResponse = this.httpClient.post(relativeUrl, jsonBody);
        JSONObject body = tokenResponse.getBody();
        PaymentResponseBody paymentResponseBody = mapper.readValue(body.toJSONString(), PaymentResponseBody.class);
        return new HttpResponse<PaymentResponseBody>(tokenResponse.getStatusCode(), tokenResponse.getHeaders(), paymentResponseBody);//NOSONAR
    }

    public HttpResponse<PaymentResponseBody> setPayments(PaymentRequestBody paymentCreationRequestBody) throws IOException {
        String relativeUrl = "/index.php?route=api/payment/method";
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(paymentCreationRequestBody);
        JSONObject jsonBody = mapper.readValue(jsonInString, JSONObject.class);
        HttpResponse<JSONObject> tokenResponse = this.httpClient.post(relativeUrl, jsonBody);
        JSONObject body = tokenResponse.getBody();
        PaymentResponseBody paymentResponseBody = mapper.readValue(body.toJSONString(), PaymentResponseBody.class);
        return new HttpResponse<PaymentResponseBody>(tokenResponse.getStatusCode(), tokenResponse.getHeaders(), paymentResponseBody);//NOSONAR
    }

    public HttpResponse<PaymentResponseBody> getPayments() throws IOException {
        String relativeUrl = "/index.php?route=api/payment/method";
        ObjectMapper mapper = new ObjectMapper();
        HttpResponse<JSONObject> tokenResponse = this.httpClient.get(relativeUrl);
        JSONObject body = tokenResponse.getBody();
        PaymentResponseBody paymentResponseBody = mapper.readValue(body.toJSONString(), PaymentResponseBody.class);
        return new HttpResponse<PaymentResponseBody>(tokenResponse.getStatusCode(), tokenResponse.getHeaders(), paymentResponseBody);//NOSONAR
    }
}
