package awesome.shop.tests.api;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.awesome.shop.ta.framework.apiEngine.CouponRequest;
import ru.awesome.shop.ta.framework.apiEngine.Routes;

public class CouponService extends EndPoint {

    public Response useCoupon(String token, int couponNumber) {
        RestAssured.baseURI = getBaseUrl();
        RequestSpecification request = RestAssured.given();
        request.queryParam("token", token);
        request.header("Content-Type", "application/json");
        CouponRequest couponRequest = new CouponRequest(couponNumber);
        Response response =request.body(couponRequest).post(Routes.useCoupon());
        for( Header header: response.headers()) {
            System.out.println("HEADER===============" + header.toString());
        }
        return response;
    }
}
