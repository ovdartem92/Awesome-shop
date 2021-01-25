package awesome.shop.tests.api.Steps;

import awesome.shop.tests.api.CouponService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import ru.awesome.shop.ta.framework.apiEngine.CouponResponse;

public class CouponSteps {
    private TextContextApi textContextApi;
    private String actualErrorMessage;

    public CouponSteps(TextContextApi textContextApi) {
        this.textContextApi = textContextApi;
    }

    @When("^I use wrong coupon (.*)$")
    public void useCoupon(int couponNumber) {
        CouponService couponService = new CouponService();
        Response response = couponService.useCoupon(textContextApi.getToken(), couponNumber);
        CouponResponse couponResponse = response.getBody().as(CouponResponse.class);
        actualErrorMessage = couponResponse.getError();
    }

    @Then("^I see message error \"(.*)\"$")
    public void checkMessageError(String expectedMessage) {
        Assert.assertEquals(actualErrorMessage, expectedMessage, "Wrong error message");
    }
}
