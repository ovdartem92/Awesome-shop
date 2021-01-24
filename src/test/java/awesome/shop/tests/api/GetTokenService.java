package awesome.shop.tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;


public class GetTokenService {
    private static final String baseUrl = "https://awesome-shop.01sh.ru";

    public static Response getToken(String userName, String key) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("key", key);
        requestParams.put("username", userName);
        request.params(requestParams);
        return request.post("/index.php?route=api/login");
    }
}
