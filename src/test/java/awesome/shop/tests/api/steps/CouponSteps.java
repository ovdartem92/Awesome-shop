package awesome.shop.tests.api.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.CouponRequestBody;
import ru.awesome.shop.ta.product.http.body.response.CouponResponseBody;
import ru.awesome.shop.ta.product.microservices.CouponMicroservice;

public class CouponSteps {
    private HttpClient httpClient = new HttpClient();
    private ApiTestContext apiTestContext;
    private CouponMicroservice couponMicroservice;

    public CouponSteps(ApiTestContext apiTestContext) {
        this.apiTestContext = apiTestContext;
        this.couponMicroservice = new CouponMicroservice(this.httpClient, apiTestContext.getToken());
    }

    @When("^I use wrong coupon (.*)$")
    public void useCoupon(int couponNumber) throws ParseException {
        CouponRequestBody couponRequestBody = new CouponRequestBody(couponNumber);
        HttpResponse<CouponResponseBody> response = couponMicroservice.useCoupon(couponRequestBody);
        CouponResponseBody couponResponseBody = response.getBody();
        String actualErrorMessage = couponResponseBody.getError();
        this.apiTestContext.setActualErrorMessage(actualErrorMessage);
        int codeResponse = response.getStatusCode();
        this.apiTestContext.setActualStatusCode(codeResponse);
    }

    @Then("^I should see message error \"(.*)\"$")
    public void checkErrorMessage(String expectedMessage) {
        Assert.assertEquals(this.apiTestContext.getActualErrorMessage(), expectedMessage, "Wrong error message");
    }
}
