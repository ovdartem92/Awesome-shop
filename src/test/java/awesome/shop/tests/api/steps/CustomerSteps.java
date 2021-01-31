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

import java.util.HashMap;
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

    @When("^I modify the customer by passing all empty parameters$")
    public void editCustomer() throws ParseException {
        String firstname = "";
        String lastname = "";
        String email = "";
        String telephone = "";
        CustomerRequestBody customerRequestBody = new CustomerRequestBody(firstname, lastname, email, telephone);
        HttpResponse<CustomerResponseBody> httpResponse = customerMicroservice.editCustomer(customerRequestBody);
        CustomerResponseBody body = httpResponse.getBody();
        apiTestContext.setActualErrorMessages(body.getError());
        int codeResponse = httpResponse.getStatusCode();
        this.apiTestContext.setActualStatusCode(codeResponse);
    }

    @When("^I modify the customer by passing valid parameters:$")
    public void editCustomer(DataTable dataTable) throws ParseException {
        Map<String, String> parameters = dataTable.asMap(String.class, String.class);
        String firstname = parameters.get("firstname");
        String lastname = parameters.get("lastname");
        String email = parameters.get("email");
        String telephone = parameters.get("telephone");
        CustomerRequestBody customerRequestBody = new CustomerRequestBody(firstname, lastname, email, telephone);
        HttpResponse<CustomerResponseBody> httpResponse = customerMicroservice.editCustomer(customerRequestBody);
        CustomerResponseBody body = httpResponse.getBody();
        apiTestContext.setActualErrorMessage(body.getSuccess());
        int codeResponse = httpResponse.getStatusCode();
        this.apiTestContext.setActualStatusCode(codeResponse);
    }

    @And("I should see an error with a list of all invalid fields")
    public void checkCustomerErrorMessage() {
        Map<String, String> expectedErrorMessages = new HashMap();
        expectedErrorMessages.put("firstname", "First Name must be between 1 and 32 characters!");
        expectedErrorMessages.put("lastname", "Last Name must be between 1 and 32 characters!");
        expectedErrorMessages.put("email", "E-Mail Address does not appear to be valid!");
        expectedErrorMessages.put("telephone", "Telephone must be between 3 and 32 characters!");

        Map<String, String> actualErrorMessages = apiTestContext.getActualErrorMessages();
        Assert.assertEquals(actualErrorMessages, expectedErrorMessages,
                "The expected errors do not match the actual ones");
    }

    @And("^I should see a message \"(.*)\"$")
    public void checkOrderErrorMessage(String expectedMessage) {
        Objects.requireNonNull(expectedMessage, "Expected message cannot be null.");
        String actualMessage = apiTestContext.getActualErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage,
                "The expected error message does not match the actual one");
    }
}
