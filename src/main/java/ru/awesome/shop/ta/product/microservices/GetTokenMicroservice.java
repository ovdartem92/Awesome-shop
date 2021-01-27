package ru.awesome.shop.ta.product.microservices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.TokenRequestBody;
import ru.awesome.shop.ta.product.http.body.response.TokenResponseBody;

public class GetTokenMicroservice {
    private HttpClient httpClient;

    public GetTokenMicroservice(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public HttpResponse<TokenResponseBody> generateToken(TokenRequestBody tokenRequestBody) throws JsonProcessingException, ParseException {
        String tokenUrl = "api/login";
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(tokenRequestBody);
        JSONParser parser = new JSONParser();
        RestAssured.defaultParser = Parser.JSON;
        JSONObject tokenJsonRequestBody = (JSONObject) parser.parse(jsonString);
        HttpResponse<JSONObject> tokenResponse = this.httpClient.post(tokenUrl, tokenJsonRequestBody);
        TokenResponseBody tokenResponseBody = mapper.convertValue(tokenResponse.getBody(), TokenResponseBody.class);
        HttpResponse<TokenResponseBody> httpResponse = new HttpResponse<>(tokenResponse.getResponseStatusCode(),
                tokenResponse.getHeaders(), tokenResponseBody);
        return httpResponse;
    }
}
