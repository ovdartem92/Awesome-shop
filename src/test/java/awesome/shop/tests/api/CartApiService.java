package awesome.shop.tests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class CartApiService {
    private static final String baseUrl = "https://awesome-shop.01sh.ru";

    public static Response addItem(String itemId, int amount, String token) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.queryParam("token", token);
        JSONObject requestParams = new JSONObject();
        requestParams.put("product_id", itemId);
        requestParams.put("quantity", amount);
        request.params(requestParams);
        return request.post("/index.php?route=api/cart/add");
    }

    public static Response checkItemInCart(String token) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.queryParam("token", token);
        return request.post("/index.php?route=api/cart/products");
    }

    public static Response editItemQuantity(String token, int quantity, int cartId) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.queryParam("token", token);
        JSONObject requestParams = new JSONObject();
        requestParams.put("key", cartId);
        requestParams.put("quantity", quantity);
        request.params(requestParams);
        return request.post("/index.php?route=api/cart/edit");
    }

    public static Response removeItemFromCart(String token, int cartId) {
        System.out.println("TOKEN EDIT CART - " + token);
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.queryParam("token", token);
        JSONObject requestParams = new JSONObject();
        requestParams.put("key", cartId);
        request.params(requestParams);
        return request.post("/index.php?route=api/cart/remove");
    }
}
