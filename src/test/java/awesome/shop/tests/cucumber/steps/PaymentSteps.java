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
    private TestContext testContext;

    public PaymentSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("I perform request to add payment address")
    public void addPaymentAddress(DataTable dataTable) throws IOException {
        Map<String, String> form = dataTable.asMap(String.class, String.class);
        AddressRequestBody addressRequestBody = new AddressRequestBody
                (form.get("First Name"), form.get("Last Name"), form.get("Address"),
                        form.get("City"), form.get("Country"), form.get("Zone_Id"));
        httpResponse = paymentMicroservice.addPaymentAddress(addressRequestBody);
    }

    @When("I perform request to get payment method")
    public void getPaymentMethod() throws IOException {
        httpResponse = paymentMicroservice.getPayments();
    }

    @When("I perform request to set payment method")
    public void setPaymentMethod(DataTable dataTable) throws IOException {
        Map<String, String> form = dataTable.asMap(String.class, String.class);
        PaymentRequestBody paymentRequestBody = new PaymentRequestBody(form.get("Payment Method"));
        httpResponse = paymentMicroservice.setPayments(paymentRequestBody);
    }

    @Then("I get status cod {int}")
    public void getStatusCod(int statusCodeExpected) {
        Assert.assertEquals(httpResponse.getStatusCode(), statusCodeExpected);
    }

    @Then("I get success message: {string}")
    public void getSuccessMessage(String expectedMessage) {
        Assert.assertEquals(httpResponse.getBody().getSuccess(), expectedMessage);
    }

    @Then("I get error message: {string}")
    public void getErrorMessage(String expectedMessage) {
        Assert.assertEquals(httpResponse.getBody().getError(), expectedMessage);
    }
}
