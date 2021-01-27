package awesome.shop.tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import ru.awesome.shop.ta.framework.apiEngine.Routes;

public class CartApiService extends EndPoint{

    public Response addItem(String itemId, int amount, String token) {
        RestAssured.baseURI = getBaseUrl();
        RequestSpecification request = RestAssured.given();
        request.queryParam("token", token);
        JSONObject requestParams = new JSONObject();
        requestParams.put("product_id", itemId);
        requestParams.put("quantity", amount);
        request.params(requestParams);
        return request.post(Routes.addItem());
    }

    public Response checkItemInCart(String token) {
        RestAssured.baseURI = getBaseUrl();
        RequestSpecification request = RestAssured.given();
        request.queryParam("token", token);
        return request.post(Routes.openCart());
    }

    public Response editItemQuantity(String token, int quantity, int cartId) {
        RestAssured.baseURI = getBaseUrl();
        RequestSpecification request = RestAssured.given();
        request.queryParam("token", token);
        JSONObject requestParams = new JSONObject();
        requestParams.put("key", cartId);
        requestParams.put("quantity", quantity);
        request.params(requestParams);
        return request.post(Routes.editCart());
    }

    public Response removeItemFromCart(String token, int cartId) {
        System.out.println("TOKEN EDIT CART - " + token);
        RestAssured.baseURI = getBaseUrl();
        RequestSpecification request = RestAssured.given();
        request.queryParam("token", token);
        JSONObject requestParams = new JSONObject();
        requestParams.put("key", cartId);
        request.params(requestParams);
        return request.post(Routes.removeItem());
    }
}
