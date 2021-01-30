package awesome.shop.tests.api.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.CouponRequestBody;
import ru.awesome.shop.ta.product.http.body.response.CouponResponseBody;
import ru.awesome.shop.ta.product.microservices.CartMicroservice;
import ru.awesome.shop.ta.product.microservices.CouponMicroservice;

public class CouponSteps {
    private HttpClient httpClient = new HttpClient();
    private ApiTestContext apiTestContext;
    private String actualErrorMessage;
    private CouponMicroservice couponMicroservice;

    public CouponSteps(ApiTestContext textContextApi) {
        this.apiTestContext = textContextApi;
        this.couponMicroservice = new CouponMicroservice(this.httpClient, apiTestContext.getToken());
    }

    @When("^I use wrong coupon (.*)$")
    public void useCoupon(int couponNumber) throws JsonProcessingException, ParseException {
        CouponRequestBody couponRequestBody = new CouponRequestBody(couponNumber);
        HttpResponse<CouponResponseBody> response = couponMicroservice.useCoupon(couponRequestBody);
        CouponResponseBody couponResponseBody = response.getBody();
        actualErrorMessage = couponResponseBody.getError();
        int codeResponse = response.getStatusCode();
        this.apiTestContext.setActualCodeResponse(codeResponse);
    }

    @Then("^I see message error \"(.*)\"$")
    public void checkMessageError(String expectedMessage) {
        Assert.assertEquals(actualErrorMessage, expectedMessage, "Wrong error message");
    }
}
