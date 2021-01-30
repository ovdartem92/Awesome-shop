package ru.awesome.shop.ta.product.microservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.product.http.body.request.CouponRequestBody;
import ru.awesome.shop.ta.product.http.body.response.CouponResponseBody;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CouponMicroservice extends BaseMicroservice {
    private String token;

    public CouponMicroservice(HttpClient httpClient, String token) {
        super(httpClient);
        this.token = token;
    }

    public HttpResponse<CouponResponseBody> useCoupon(CouponRequestBody couponRequestBody)
            throws JsonProcessingException, ParseException {
        Objects.requireNonNull(couponRequestBody, "Coupon response body cannot be null");
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("token", this.token);
        queryParameters.put("route", "api/coupon");
        JSONObject requestBody = convertObjectToJson(couponRequestBody);
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(commonUrl, queryParameters,
                requestBody);
        CouponResponseBody couponResponseBody = mapper.convertValue(httpResponse.getBody(), CouponResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                couponResponseBody);
    }
}
