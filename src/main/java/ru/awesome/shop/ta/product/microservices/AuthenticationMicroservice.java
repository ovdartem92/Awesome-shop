package ru.awesome.shop.ta.product.microservices;

import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.TokenRequestBody;
import ru.awesome.shop.ta.product.http.body.response.TokenResponseBody;

public class AuthenticationMicroservice {
    private HttpClient httpClient;

    public AuthenticationMicroservice(HttpClient httpClient) {
        this.httpClient = httpClient;
    }


// TokenRequestBody - POJO

// TokenResponseBody - POJO

    public HttpResponse<TokenResponseBody> generateToken(TokenRequestBody tokenRequestBody) {

        String tokenUrl = "api / login";

// TODO: Convert tokenRequestBody to JSONObject

        JSONObject tokenJsonRequestBody = . . .;

        HttpResponse<JSONObject> tokenResponse = this.httpClient.post(tokenUrl, tokenJsonRequestBody);

        JSONObject body = tokenResponse.getBody();

// TODO: Convert body (JSONObject) to instance of TokenResponseBody

. . .

    }
}
