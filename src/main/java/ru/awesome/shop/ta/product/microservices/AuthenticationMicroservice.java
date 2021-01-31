package ru.awesome.shop.ta.product.microservices;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.TokenRequestBody;
import ru.awesome.shop.ta.product.http.body.response.TokenResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static ru.awesome.shop.ta.utils.JsonRepresentation.convertFromJson;
import static ru.awesome.shop.ta.utils.JsonRepresentation.convertToJson;

public class AuthenticationMicroservice extends BaseMicroservice {

    public AuthenticationMicroservice(HttpClient httpClient) {
        super(httpClient);
    }

    public HttpResponse<TokenResponseBody> generateToken(TokenRequestBody tokenRequestBody) throws ParseException {
        Objects.requireNonNull(tokenRequestBody, "Token response body cannot be null");
        JSONObject requestBody = convertToJson(tokenRequestBody);
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("route", "api/login");
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(commonUrl, queryParameters, requestBody);
        TokenResponseBody tokenResponseBody = convertFromJson(httpResponse.getBody(), TokenResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(), tokenResponseBody);
    }
}
