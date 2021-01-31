package awesome.shop.tests.api.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.AddressRequestBody;
import ru.awesome.shop.ta.product.http.body.request.PaymentRequestBody;
import ru.awesome.shop.ta.product.http.body.response.PaymentResponseBody;
import ru.awesome.shop.ta.product.microservices.PaymentMicroservice;

import java.util.Map;
import java.util.Objects;

public class PaymentSteps {
    private HttpClient httpClient = new HttpClient();
    private PaymentMicroservice paymentMicroservice = new PaymentMicroservice(httpClient);
    private ApiTestContext apiTestContext;

    public PaymentSteps(ApiTestContext testContext) {
        Objects.requireNonNull(testContext, "ApiTestContext cannot be null");
        this.apiTestContext = testContext;
    }

    @When("^I perform request to add payment address$")
    public void addPaymentAddress(DataTable dataTable) throws ParseException {
        Objects.requireNonNull(dataTable, "DataTable cannot be null");
        Map<String, String> form = dataTable.asMap(String.class, String.class);
        AddressRequestBody addressRequestBody = new AddressRequestBody
                (form.get("First Name"), form.get("Last Name"), form.get("Address"),
                        form.get("City"), form.get("Country"), form.get("Zone_Id"));
        HttpResponse<PaymentResponseBody> httpResponse = paymentMicroservice.addPaymentAddress(addressRequestBody);
        apiTestContext.setActualStatusCode(httpResponse.getStatusCode());
        apiTestContext.setActualSuccessMessage(httpResponse.getBody().getSuccess());
    }

    @When("^I perform request to get payment method$")
    public void getPaymentMethod() {
        HttpResponse<PaymentResponseBody> httpResponse = paymentMicroservice.getPayments();
        apiTestContext.setActualStatusCode(httpResponse.getStatusCode());
        apiTestContext.setActualErrorMessage(httpResponse.getBody().getError());
    }

    @When("^I perform request to set payment method$")
    public void setPaymentMethod(DataTable dataTable) throws ParseException {
        Objects.requireNonNull(dataTable, "DataTable cannot be null");
        Map<String, String> form = dataTable.asMap(String.class, String.class);
        PaymentRequestBody paymentRequestBody = new PaymentRequestBody(form.get("Payment Method"));
        HttpResponse<PaymentResponseBody> httpResponse = paymentMicroservice.setPayments(paymentRequestBody);
        apiTestContext.setActualStatusCode(httpResponse.getStatusCode());
        apiTestContext.setActualSuccessMessage(httpResponse.getBody().getSuccess());
    }

    @And("^I should get error message \"(.*)\"$")
    public void getErrorMessage(String expectedMessage) {
        Assert.assertEquals(apiTestContext.getActualErrorMessage(), expectedMessage, "Message is not expected!");
    }

    @And("^I should get message \"(.*)\"$")
    public void getMessageFreeCheckout(String expectedMessage) {
        Assert.assertTrue(apiTestContext.getActualSuccessMessage().contains(expectedMessage),
                "Message is not expected!");
    }

    @And("^I should get success message \"(.*)\"$")
    public void getSuccessCurrencyMessage(String expectedMessage) {
        Assert.assertEquals(apiTestContext.getActualSuccessMessage(), expectedMessage, "Message is not expected!");
    }
}
