package awesome.shop.tests.cucumber.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.body.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.AddressRequestBody;
import ru.awesome.shop.ta.product.http.body.request.PaymentRequestBody;
import ru.awesome.shop.ta.product.http.body.response.PaymentResponseBody;
import ru.awesome.shop.ta.product.microservices.PaymentMicroservice;

import java.io.IOException;
import java.util.Map;

public class PaymentSteps {
    private HttpResponse<PaymentResponseBody> httpResponse;
    private HttpClient httpClient = new HttpClient();
    private PaymentMicroservice paymentMicroservice = new PaymentMicroservice(httpClient);
    private TextContextApi testContext;

    public PaymentSteps(TextContextApi testContext) {
        this.testContext = testContext;
    }

    @When("I perform request to add payment address")
    public void addPaymentAddress(DataTable dataTable) throws IOException {
        Map<String, String> form = dataTable.asMap(String.class, String.class);
        AddressRequestBody addressRequestBody = new AddressRequestBody
                (form.get("First Name"), form.get("Last Name"), form.get("Address"),
                        form.get("City"), form.get("Country"), form.get("Zone_Id"));
        httpResponse = paymentMicroservice.addPaymentAddress(addressRequestBody);
        testContext.setActualCodeResponse(httpResponse.getStatusCode());
        testContext.setActualBodyMessage(httpResponse.getBody().getMessage());
    }

    @When("I perform request to get payment method")
    public void getPaymentMethod() throws IOException {
        httpResponse = paymentMicroservice.getPayments();
        testContext.setActualCodeResponse(httpResponse.getStatusCode());
        testContext.setActualBodyMessage(httpResponse.getBody().getMessage());
    }

    @When("I perform request to set payment method")
    public void setPaymentMethod(DataTable dataTable) throws IOException {
        Map<String, String> form = dataTable.asMap(String.class, String.class);
        PaymentRequestBody paymentRequestBody = new PaymentRequestBody(form.get("Payment Method"));
        httpResponse = paymentMicroservice.setPayments(paymentRequestBody);
        testContext.setActualCodeResponse(httpResponse.getStatusCode());
        testContext.setActualBodyMessage(httpResponse.getBody().getMessage());
    }

    @Then("I get status cod {int}")
    public void checkStatusCod(int statusCodeExpected) {
        Assert.assertEquals(testContext.getActualCodeResponse(), statusCodeExpected,
                statusCodeExpected + " does not match");
    }

    @Then("I get message: {string}")
    public void checkMessage(String expectedMessage) {
        Assert.assertEquals(testContext.getActualBodyMessage(), expectedMessage,
                expectedMessage + " not displayed");
    }
}
