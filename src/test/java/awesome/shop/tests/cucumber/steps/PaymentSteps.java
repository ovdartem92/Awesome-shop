package awesome.shop.tests.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.awesome.shop.ta.product.microservices.PaymentMicroservice;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.body.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.AddressRequestBody;
import ru.awesome.shop.ta.product.http.body.response.PaymentRequestBody;
import ru.awesome.shop.ta.product.http.body.response.PaymentResponseBody;

import java.io.IOException;

public class PaymentSteps {
    HttpResponse<PaymentResponseBody> httpResponse;
    HttpClient httpClient = new HttpClient();
    PaymentMicroservice paymentMicroservice = new PaymentMicroservice(httpClient);
    AddressRequestBody addressRequestBody = new AddressRequestBody();
    PaymentRequestBody paymentRequestBody = new PaymentRequestBody();

    @When("I perform request to add payment address")
    public void iPerformRequestToAddPaymentAddress() throws IOException {
        httpResponse = paymentMicroservice.addPaymentAddress(addressRequestBody);
    }

    @When("I perform request to get payment method")
    public void iPerformRequestToGetPaymentMethod() throws IOException {
        httpResponse = paymentMicroservice.getPayments();
    }

    @When("I perform request to set payment method")
    public void iPerformRequestToSetPaymentMethod() throws IOException {
        httpResponse = paymentMicroservice.setPayments(paymentRequestBody);
    }

    @Then("I get status cod {int}")
    public void iGetStatusCod(int statusCodeExpected) {
        Assert.assertEquals(httpResponse.getResponseStatusCode(), statusCodeExpected);
    }

    @Then("I get success message")
    public void iGetSuccessMessage() {
        Assert.assertTrue(httpResponse.getBody().getSuccess().contains("Success"));
    }

    @Then("I get error message")
    public void iGetErrorMessage() {
        Assert.assertTrue(httpResponse.getBody().getError().contains("Warning"));
    }
}
