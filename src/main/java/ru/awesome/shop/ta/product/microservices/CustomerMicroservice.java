package ru.awesome.shop.ta.product.microservices;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.CustomerRequestBody;
import ru.awesome.shop.ta.product.http.body.response.CustomerResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static ru.awesome.shop.ta.utils.JsonRepresentation.convertFromJson;
import static ru.awesome.shop.ta.utils.JsonRepresentation.convertToJson;

public class CustomerMicroservice extends BaseMicroservice {
    private String token;

    public CustomerMicroservice(HttpClient httpClient, String token) {
        super(httpClient);
        Objects.requireNonNull(token, "Customer cannot be null");
        this.token = token;
    }

    public HttpResponse<CustomerResponseBody> editCustomer(CustomerRequestBody customerRequestBody)
            throws ParseException {
        Objects.requireNonNull(customerRequestBody, "Customer request body cannot be null");
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("token", this.token);
        queryParameters.put(ROUTE, "api/customer");
        JSONObject requestBody = convertToJson(customerRequestBody);
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(COMMON_URL, queryParameters, requestBody);
        CustomerResponseBody customerResponseBody = convertFromJson(httpResponse.getBody(), CustomerResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(), customerResponseBody);
    }
}
