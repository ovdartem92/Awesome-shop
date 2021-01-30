package ru.awesome.shop.ta.product.microservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.TokenRequestBody;
import ru.awesome.shop.ta.product.http.body.response.TokenResponseBody;

import java.util.HashMap;
import java.util.Map;

public class AuthorizationMicroservice extends BaseMicroservice {

    public AuthorizationMicroservice(HttpClient httpClient) {
        super(httpClient);
    }

    public HttpResponse<TokenResponseBody> generateToken(TokenRequestBody tokenRequestBody)
            throws JsonProcessingException, ParseException {
        JSONObject requestBody = convertObjectToJson(tokenRequestBody);
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("route", "api/login");
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(commonUrl, queryParameters, requestBody);
        TokenResponseBody tokenResponseBody = mapper.convertValue(httpResponse.getBody(), TokenResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(),
                httpResponse.getHeaders(), tokenResponseBody);
    }
}
