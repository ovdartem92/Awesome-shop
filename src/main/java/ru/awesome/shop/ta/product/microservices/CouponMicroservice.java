package ru.awesome.shop.ta.product.microservices;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.product.http.body.request.CouponRequestBody;
import ru.awesome.shop.ta.product.http.body.response.CouponResponseBody;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static ru.awesome.shop.ta.utils.JsonRepresentation.convertFromJson;
import static ru.awesome.shop.ta.utils.JsonRepresentation.convertToJson;

public class CouponMicroservice extends BaseMicroservice {
    private String token;

    public CouponMicroservice(HttpClient httpClient, String token) {
        super(httpClient);
        Objects.requireNonNull(token, "Token cannot be null");
        this.token = token;
    }

    public HttpResponse<CouponResponseBody> useCoupon(CouponRequestBody couponRequestBody) throws ParseException {
        Objects.requireNonNull(couponRequestBody, "Coupon response body cannot be null");
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("token", this.token);
        queryParameters.put(ROUTE, "api/coupon");
        JSONObject requestBody = convertToJson(couponRequestBody);
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(COMMON_URL, queryParameters,
                requestBody);
        CouponResponseBody couponResponseBody = convertFromJson(httpResponse.getBody(), CouponResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                couponResponseBody);
    }
}
