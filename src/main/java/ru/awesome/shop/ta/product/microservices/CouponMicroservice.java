package ru.awesome.shop.ta.product.microservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.product.http.body.request.CouponRequestBody;
import ru.awesome.shop.ta.product.http.body.response.CouponResponseBody;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.framework.client.Routes;
import ru.awesome.shop.ta.product.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class CouponMicroservice extends BaseMicroservice {

    public CouponMicroservice(HttpClient httpClient) {
        super(httpClient);
    }

    public HttpResponse<CouponResponseBody> useCoupon(CouponRequestBody couponRequestBody, String token)
            throws JsonProcessingException, ParseException {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("token", token);
        JSONObject requestBody = convertObjectToJson(couponRequestBody);
        HttpResponse httpResponse = this.httpClient.post(Routes.useCoupon(), queryParameters, requestBody);
        CouponResponseBody couponResponseBody = mapper.convertValue(httpResponse.getBody(), CouponResponseBody.class);
        return new HttpResponse<CouponResponseBody>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                couponResponseBody);
    }
}
