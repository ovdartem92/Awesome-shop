package ru.awesome.shop.ta.product.microservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.framework.client.Routes;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.TokenRequestBody;
import ru.awesome.shop.ta.product.http.body.response.TokenResponseBody;

public class AuthorizationMicroservice extends BaseMicroservice {

    public AuthorizationMicroservice(HttpClient httpClient) {
        super(httpClient);
    }

    public HttpResponse<TokenResponseBody> getToken(TokenRequestBody tokenRequestBody, String token) throws JsonProcessingException, ParseException {
        JSONObject requestBody = convertObjectToJson(tokenRequestBody);
        HttpResponse httpResponse = this.httpClient.post(Routes.getToken(), requestBody, token);
        TokenResponseBody tokenResponseBody = mapper.convertValue(httpResponse.getBody(), TokenResponseBody.class);
        httpResponse.setBody(tokenResponseBody);
        return httpResponse;
    }
}
