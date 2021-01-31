package awesome.shop.tests.api.steps;

import io.cucumber.java.en.Then;
import org.testng.Assert;

public class StatusCodeSteps {
    private ApiTestContext apiTestContext;

    public StatusCodeSteps(ApiTestContext apiTestContext) {
        this.apiTestContext = apiTestContext;
    }

    @Then("^I should get status code (.*)$")
    public void verifyStatusCode(int expectedStatusCode) {
        Assert.assertEquals(apiTestContext.getActualStatusCode(), expectedStatusCode, "Status Code isn't expected!");
    }
}
