package ru.awesome.shop.ta.product.microservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.body.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.TokenRequestBody;
import ru.awesome.shop.ta.product.http.body.request.TokenResponseBody;

import java.io.IOException;

public class AuthenticationMicroservice {
    private HttpClient httpClient;

    public AuthenticationMicroservice(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public HttpResponse<TokenResponseBody> generateToken(TokenRequestBody tokenRequestBody) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(tokenRequestBody);
        JSONObject jsonBody = mapper.readValue(result, JSONObject.class);
        HttpResponse<JSONObject> tokenResponse = this.httpClient.post("/index.php?route=api/login", jsonBody);
        JSONObject body = tokenResponse.getBody();
        TokenResponseBody tokenResponseBody = mapper.readValue(body.toJSONString(), TokenResponseBody.class);
        return new HttpResponse<>(tokenResponse.getResponseStatusCode(), tokenResponse.getHeaders(), tokenResponseBody);
    }
}
