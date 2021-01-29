//package awesome.shop.tests.api.Steps;
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.DataTableType;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.response.Response;
//import org.testng.Assert;
//
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class CustomerSteps {
//    private Response response;
//
//    @DataTableType(replaceWithEmptyString = "[blank]")
//    public String listOfStringListsType(String cell) {
//        return cell;
//    }
//
//    @When("^I modify the customer by passing parameters:$")
//    public void editCustomer(DataTable dataTable) {
//        Map<String, String> requestBody = dataTable.asMap(String.class, String.class);
//        CustomerService customerService = new CustomerService();
//        this.response = customerService.getEditCustomerResponse(requestBody);
//    }
//
//    @Then("^I should see an error with a list of all invalid fields$")
//    public void checkCustomerErrorMessageWithAllInvalidFields() {
//        Map<String, String> expectedErrorMessages = new HashMap();
//        expectedErrorMessages.put("firstname", "First Name must be between 1 and 32 characters!");
//        expectedErrorMessages.put("lastname", "Last Name must be between 1 and 32 characters!");
//        expectedErrorMessages.put("email", "E-Mail Address does not appear to be valid!");
//        expectedErrorMessages.put("telephone", "Telephone must be between 3 and 32 characters!");
//
//        Map<String, String> actualErrorMessages = response.getBody().jsonPath().getMap("error");
//        Assert.assertEquals(actualErrorMessages, expectedErrorMessages);
//    }
//
//    @Then("^I should see a message \"(.*)\"$")
//    public void checkCustomerSuccessMessage(String message) {
//        String successMessage = response.getBody().jsonPath().getString("success");
//        Assert.assertEquals(successMessage, message);
//    }
//}
//
