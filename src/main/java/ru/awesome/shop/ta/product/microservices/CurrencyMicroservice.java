package ru.awesome.shop.ta.product.microservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.CurrencyRequestBody;
import ru.awesome.shop.ta.product.http.body.response.CouponResponseBody;
import ru.awesome.shop.ta.product.http.body.response.CurrencyResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static ru.awesome.shop.ta.utils.JsonRepresentation.convertFromJson;
import static ru.awesome.shop.ta.utils.JsonRepresentation.convertToJson;

public class CurrencyMicroservice extends BaseMicroservice {
    private String token;

    public CurrencyMicroservice(HttpClient httpClient, String token) {
        super(httpClient);
        Objects.requireNonNull(token, "Token cannot be null");
        this.token = token;
    }

    public HttpResponse<CurrencyResponseBody> changeCurrency(CurrencyRequestBody currencyRequestBody) throws ParseException {
        Objects.requireNonNull(currencyRequestBody, "Currency Request Body cannot be null.");
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("token", this.token);
        queryParameters.put(ROUTE, "api/currency");
        JSONObject requestBody = convertToJson(currencyRequestBody);
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(COMMON_URL, queryParameters,
                requestBody);
        CurrencyResponseBody couponResponseBody = convertFromJson(httpResponse.getBody(), CurrencyResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                couponResponseBody);
    }
}
