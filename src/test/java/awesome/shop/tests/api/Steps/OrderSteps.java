//package awesome.shop.tests.api.Steps;
//
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.response.Response;
//import org.testng.Assert;
//
//
//public class OrderSteps {
//    private Response response;
//    private final OrderService orderService = new OrderService();
//
//    @When("^I add an empty order$")
//    public void addOrder() {
//        this.response = orderService.getAddOrderResponse();
//    }
//
//    @When("^I edit an order$")
//    public void editOrder() {
//        this.response = orderService.getEditOrderResponse();
//    }
//
//    @When("^I delete an order$")
//    public void deleteOrder() {
//        this.response = orderService.getDeleteOrderResponse();
//    }
//
//    @When("^I get info about the order$")
//    public void getOrderInfo() {
//        this.response = orderService.getOrderInfoResponse();
//    }
//
//    @When("^I get history about the order$")
//    public void getOrderHistory() {
//        this.response = orderService.getOrderHistoryResponse();
//    }
//
//    @Then("^I should see an error message \"(.*)\"$")
//    public void checkOrderErrorMessage(String message) {
//        String errorMessage = response.getBody().jsonPath().getString("error");
//        Assert.assertEquals(message, errorMessage);
//    }
//}
//
