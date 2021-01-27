package awesome.shop.tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import ru.awesome.shop.ta.framework.apiEngine.AuthorizationRequest;
import ru.awesome.shop.ta.framework.apiEngine.Routes;


public class GetTokenService extends EndPoint {

    public Response getToken(String userName, String key) {
        RestAssured.baseURI = getBaseUrl();
        RequestSpecification request = RestAssured.given();
        AuthorizationRequest authorizationRequest = new AuthorizationRequest(userName, key);
        JSONObject requestParams = new JSONObject();
        requestParams.put("username", userName);
        requestParams.put("key", key);
        request.params(requestParams);
        return request.post(Routes.getToken());
    }
}
