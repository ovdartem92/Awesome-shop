package ru.awesome.shop.ta.product.microservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.product.http.body.request.CouponRequestBody;
import ru.awesome.shop.ta.product.http.body.response.CouponResponseBody;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.framework.client.Routes;
import ru.awesome.shop.ta.product.http.HttpResponse;

public class CouponMicroservice extends BaseMicroservice {

    public CouponMicroservice(HttpClient httpClient) {
        super(httpClient);
    }

    public HttpResponse<CouponResponseBody> useCoupon(CouponRequestBody couponRequestBody, String token) throws JsonProcessingException, ParseException {
        JSONObject requestBody = convertObjectToJson(couponRequestBody);
        HttpResponse httpResponse = this.httpClient.post(Routes.useCoupon(), requestBody, token);
        CouponResponseBody couponResponseBody = mapper.convertValue(httpResponse.getBody(), CouponResponseBody.class);
        httpResponse.setBody(couponResponseBody);
        return httpResponse;
    }
}
