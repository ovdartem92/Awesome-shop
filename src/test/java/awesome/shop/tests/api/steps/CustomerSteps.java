package awesome.shop.tests.api.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.CustomerRequestBody;
import ru.awesome.shop.ta.product.http.body.response.CustomerResponseBody;
import ru.awesome.shop.ta.product.microservices.CustomerMicroservice;

import java.util.Map;
import java.util.Objects;

public class CustomerSteps {
    private HttpClient httpClient = new HttpClient();
    private ApiTestContext apiTestContext;
    private CustomerMicroservice customerMicroservice;

    public CustomerSteps(ApiTestContext apiTestContext) {
        this.apiTestContext = apiTestContext;
        this.customerMicroservice = new CustomerMicroservice(this.httpClient, apiTestContext.getToken());
    }

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String listOfStringListsType(String cell) {
        return cell;
    }

    @When("^I modify the customer by passing parameters:$")
    public void editCustomer(DataTable dataTable) throws ParseException {
        Map<String, String> parameters = dataTable.asMap(String.class, String.class);
        String firstname = parameters.get("firstname");
        String lastname = parameters.get("lastname");
        String email = parameters.get("email");
        String telephone = parameters.get("telephone");
        CustomerRequestBody customerRequestBody = new CustomerRequestBody(firstname, lastname, email, telephone);
        HttpResponse<CustomerResponseBody> httpResponse = customerMicroservice.editCustomer(customerRequestBody);
        CustomerResponseBody body = httpResponse.getBody();
        apiTestContext.setActualSuccessMessage(body.getSuccess());
        apiTestContext.setActualErrorMessages(body.getError());
        System.out.println("Success: " + body.getSuccess());
        System.out.println("Error: " + body.getError());
        int codeResponse = httpResponse.getStatusCode();
        this.apiTestContext.setActualStatusCode(codeResponse);
    }

    @And("^I should see an error with a list of all invalid fields:$")
    public void checkCustomerErrorMessage(DataTable dataTable) {
        Map<String, String> expectedErrorMessages = dataTable.asMap(String.class, String.class);
        Map<String, String> actualErrorMessages = apiTestContext.getActualErrorMessages();
        Assert.assertEquals(actualErrorMessages, expectedErrorMessages,
                "The expected errors do not match the actual ones");
    }

    @And("^I should see a message \"(.*)\"$")
    public void checkOrderSuccessMessage(String expectedMessage) {
        Objects.requireNonNull(expectedMessage, "Expected message cannot be null.");
        String actualSuccessMessage = apiTestContext.getActualSuccessMessage();
        Assert.assertEquals(actualSuccessMessage, expectedMessage,
                "The expected error message does not match the actual one");
    }
}
