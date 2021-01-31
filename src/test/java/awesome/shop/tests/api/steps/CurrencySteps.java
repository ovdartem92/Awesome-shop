package awesome.shop.tests.api.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.CurrencyRequestBody;
import ru.awesome.shop.ta.product.http.body.response.CurrencyResponseBody;
import ru.awesome.shop.ta.product.microservices.CurrencyMicroservice;

public class CurrencySteps {
    private HttpClient httpClient = new HttpClient();
    private ApiTestContext apiTestContext;
    private CurrencyMicroservice currencyMicroservice;


    public CurrencySteps(ApiTestContext apiTestContext) {
        this.apiTestContext = apiTestContext;
        this.currencyMicroservice = new CurrencyMicroservice(this.httpClient, apiTestContext.getToken());
    }

    @When("^I send invalid request for changing currency \"(.*)\"$")
    public void setInvalidCurrency(String currency) throws ParseException {
        HttpResponse<CurrencyResponseBody> httpResponse;
        CurrencyRequestBody currencyRequestBody = new CurrencyRequestBody(currency);
        httpResponse = currencyMicroservice.changeCurrency(currencyRequestBody);
        int actualStatusCode = httpResponse.getStatusCode();
        String actualErrorMessage = httpResponse.getBody().getError();
        apiTestContext.setActualStatusCode(actualStatusCode);
        apiTestContext.setActualErrorMessage(actualErrorMessage);

    }

    @When("^I send valid request for changing currency \"(.*)\"$")
    public void setValidCurrency(String currency) throws ParseException {
        HttpResponse<CurrencyResponseBody> httpResponse;
        CurrencyRequestBody currencyRequestBody = new CurrencyRequestBody(currency);
        httpResponse = currencyMicroservice.changeCurrency(currencyRequestBody);
        int actualStatusCode = httpResponse.getStatusCode();
        String actualSuccessMessage = httpResponse.getBody().getSuccess();
        apiTestContext.setActualStatusCode(actualStatusCode);
        apiTestContext.setActualSuccessMessage(actualSuccessMessage);

    }

    @Then("^I should get currency status code (.*)$")
    public void getCurrencyStatusCode(int expectedStatusCode) {
        Assert.assertEquals(apiTestContext.getActualStatusCode(), expectedStatusCode,
                "Status Code isn't expected!");
    }

    @Then("^I should get currency error message \"(.*)\"$")
    public void getErrorCurrencyMessage(String expectedMessage) {
        Assert.assertEquals(apiTestContext.getActualErrorMessage(), expectedMessage, "Message is not expected!");
    }

    @Then("^I should get currency success message \"(.*)\"$")
    public void getSuccessCurrencyMessage(String expectedMessage) {
        Assert.assertEquals(apiTestContext.getActualSuccessMessage(), expectedMessage, "Message is not expected!");
    }
}
