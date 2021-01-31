package awesome.shop.tests.api.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.AddVoucherRequestBody;
import ru.awesome.shop.ta.product.http.body.request.ApplyVoucherRequestBody;
import ru.awesome.shop.ta.product.http.body.response.AddVoucherResponseBody;
import ru.awesome.shop.ta.product.http.body.response.ApplyVoucherResponseBody;
import ru.awesome.shop.ta.product.microservices.VoucherMicroservice;

import java.util.Map;

public class VoucherSteps {
    private HttpClient httpClient = new HttpClient();
    private ApiTestContext apiTestContext;
    private VoucherMicroservice voucherMicroservice;

    public VoucherSteps(ApiTestContext apiTestContext) {
        this.apiTestContext = apiTestContext;
        this.voucherMicroservice = new VoucherMicroservice(this.httpClient, apiTestContext.getToken());
    }

    @When("^I send request for applying existing voucher \"(.*)\"$")
    public void applyingExistingVoucher(String voucher) throws ParseException {
        HttpResponse<ApplyVoucherResponseBody> httpResponse;
        ApplyVoucherRequestBody applyVoucherRequestBody = new ApplyVoucherRequestBody(voucher);
        httpResponse = voucherMicroservice.applyExistingVoucher(applyVoucherRequestBody);
        int actualStatusCode = httpResponse.getStatusCode();
        String actualErrorMessage = httpResponse.getBody().getError();
        apiTestContext.setActualStatusCode(actualStatusCode);
        apiTestContext.setActualErrorMessage(actualErrorMessage);
    }

    @Then("^I should get applying voucher error message \"(.*)\"$")
    public void getInvalidVoucherMessage(String expectedMessage) {
        Assert.assertEquals(apiTestContext.getActualErrorMessage(), expectedMessage, "Message is not expected!");
    }

    @When("^I send request for adding new voucher")
    public void sendRequestForAddingNewVoucher(DataTable dataTable) throws ParseException {
        Map<String, String> requestBody = dataTable.asMap(String.class, String.class);
        HttpResponse<AddVoucherResponseBody> httpResponse;
        AddVoucherRequestBody addVoucherRequestBody = new AddVoucherRequestBody(requestBody);
        httpResponse = voucherMicroservice.addNewVoucher(addVoucherRequestBody);
        int actualStatusCode = httpResponse.getStatusCode();
        String actualSuccessMessage = httpResponse.getBody().getSuccess();
        apiTestContext.setActualStatusCode(actualStatusCode);
        apiTestContext.setActualSuccessMessage(actualSuccessMessage);

    }

    @Then("^I should get voucher status code (.*)$")
    public void getAddVoucherStatusCode(int expectedStatusCode) {
        Assert.assertEquals(apiTestContext.getActualStatusCode(), expectedStatusCode, "Status Code isn't expected!");
    }

    @And("^I should get add voucher success message \"(.*)\"$")
    public void getAddVoucherSuccessMessage(String expectedMessage) {
        Assert.assertEquals(apiTestContext.getActualSuccessMessage(), expectedMessage, "Message is not expected!");
    }
}
