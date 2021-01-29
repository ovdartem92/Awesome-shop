package awesome.shop.tests.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.awesome.shop.ta.framework.apiEngine.*;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;

public class LoginApiTestItWorks {
    private SoftAssert softAssert = new SoftAssert();
    private String baseUrl = "https://awesome-shop.01sh.ru";
    private int expectedCode = 200;
    private String token;
    private String actualSuccessCartMassage = "Success: You have modified your shopping cart!";
    private int cartId;
    private CartApiService cartApiService = new CartApiService();
    private GetTokenService getTokenService = new GetTokenService();

    @Test
    public void getToken() {
        String key = "bBL8a7Pfnr8olMEdFvrNxHBwGnGuwHlAu72JSybQDjCsKOQpnBeJp5kbY4TuPStaDt33i6PI922NmGEfXS1dlh2uIfTaSqQwTd1KvgueOE1q4GLUWnjaKqMsKrvfdHC5nOrJBDEj9Zb88NDO2k4dYxmrKW2bgc156nJLOVrOVSkVLQRlFxKAVkuG9vypNiNEhB2eOSRvpn58UKW6YiscedNgTmy8QHCZTzyih8qCrYngI3YMqaXHdGKu0Vq6kgfm";
        String userName = "Autotest";
        Response response = getTokenService.getToken(userName, key);
        AuthorizationResponse authorizationResponse = response.getBody().as(AuthorizationResponse.class);
        token = authorizationResponse.getToken();
        System.out.println(token);
        Headers headers = response.headers();
        for(Header head: headers){
            System.out.println("Name ------" + head.getName()+ " Value------" + head.getValue());
        }

    }

    @Test(dependsOnMethods = "getToken")
    public void addItemToCart() {
        Response response = cartApiService.addItem("43", 2, token);
        ChangeCartResponse addItemResponse = response.getBody().as(ChangeCartResponse.class);
        String expectedSuccessCartMessage = addItemResponse.getSuccess();
        Assert.assertEquals(expectedSuccessCartMessage, actualSuccessCartMassage,
                "Wrong success message");
    }

    @Test(dependsOnMethods = "addItemToCart")
    public void checkItemInCart() {
        Response response =cartApiService.checkItemInCart(token);
        ItemResponse item = response.getBody().as(ItemResponse.class);
        System.out.println(item.toString());
        cartId = item.getProducts().get(0).getCart_id();
        System.out.println("CART ID--------------------------" + cartId);
        System.out.println(response.asString());
    }

    @Test(dependsOnMethods = "checkItemInCart")
    public void editCart() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.queryParam("token", token);
        JSONObject requestParams = new JSONObject();
        requestParams.put("key", cartId);
        requestParams.put("quantity", "5");
        request.params(requestParams);
        Response response = request.post("/index.php?route=api/cart/edit");
        ChangeCartResponse changeCartResponse = response.getBody().as(ChangeCartResponse.class);
        String expectedSuccessCartMessage = changeCartResponse.getSuccess();
        int actualCode = response.getStatusCode();
        softAssert.assertEquals(actualCode, expectedCode, "Wrong status code");
        softAssert.assertEquals(expectedSuccessCartMessage, actualSuccessCartMassage,
                "Wrong success message");
        softAssert.assertAll();
        checkItemInCart();
    }

    @Test(dependsOnMethods = "editCart")
    public void removeItemFromCart() {
        System.out.println("TOKEN EDIT CART - " + token);
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        request.queryParam("token", token);
        JSONObject requestParams = new JSONObject();
        requestParams.put("key", cartId);
        request.params(requestParams);
        Response response = request.post("/index.php?route=api/cart/remove");
        ChangeCartResponse changeCartResponse = response.getBody().as(ChangeCartResponse.class);
        String expectedSuccessCartMessage = changeCartResponse.getSuccess();
        int actualCode = response.getStatusCode();
        softAssert.assertEquals(actualCode, expectedCode, "Wrong status code");
        softAssert.assertEquals(expectedSuccessCartMessage, actualSuccessCartMassage,
                "Wrong success message");
        softAssert.assertAll();
        RequestSpecification request1 = RestAssured.given();
        request1.queryParam("token", token);
        Response response1 = request.post("/index.php?route=api/cart/products");
        ItemResponse item = response1.getBody().as(ItemResponse.class);
        Assert.assertTrue(item.getProducts().isEmpty());
        System.out.println(response1.asString());
    }

    //    @Test(dependsOnMethods = "getToken")
    @Test
    public void useCouponTest() throws JsonProcessingException, ParseException {
//        RestAssured.baseURI = baseUrl;
//        RequestSpecification request = RestAssured.given();
//        request.header("Content-Type", "application/json");
        CouponRequest couponRequest = new CouponRequest(2222);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(couponRequest);
        JSONParser parser = new JSONParser();
        JSONObject couponJsonRequestBody = (JSONObject) parser.parse(jsonString);
        HttpClient httpClient = new HttpClient();
        HttpResponse httpResponse = httpClient.post("api/coupon", couponJsonRequestBody);
        System.out.println(httpResponse.getResponseStatusCode());
        System.out.println(httpResponse.getHeaders().toString());
        System.out.println(httpResponse.getBody().toString());

//
//        Response response = request.body(couponRequest).post("/index.php?route=api/coupon");
//        CouponResponse couponResponse = response.getBody().as(CouponResponse.class);
//        String errorMessage = couponResponse.getError();
//        Assert.assertEquals(errorMessage, "Warning: Coupon is either invalid, expired or reached it's usage limit!",
//                "Wrong error message");
    }
}
