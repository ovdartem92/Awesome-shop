package awesome.shop.tests.api.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.OrderRequestBody;
import ru.awesome.shop.ta.product.http.body.response.OrderResponseBody;
import ru.awesome.shop.ta.product.microservices.OrderMicroservice;

import java.util.Objects;

public class OrderSteps {
    private HttpClient httpClient = new HttpClient();
    private ApiTestContext apiTestContext;
    private OrderMicroservice orderMicroservice;
    private final String emptyKey = "";

    public OrderSteps(ApiTestContext apiTestContext) {
        this.apiTestContext = apiTestContext;
        this.orderMicroservice = new OrderMicroservice(this.httpClient, apiTestContext.getToken());
    }

    @When("^I add an empty order$")
    public void addOrder() throws ParseException {
        OrderRequestBody orderRequestBody = new OrderRequestBody(emptyKey);
        HttpResponse<OrderResponseBody> httpResponse = orderMicroservice.addOrder(orderRequestBody);
        OrderResponseBody body = httpResponse.getBody();
        apiTestContext.setActualErrorMessage(body.getError());
        int codeResponse = httpResponse.getStatusCode();
        this.apiTestContext.setActualStatusCode(codeResponse);
    }

    @When("^I edit an order$")
    public void editOrder() throws ParseException {
        OrderRequestBody orderRequestBody = new OrderRequestBody(emptyKey);
        HttpResponse<OrderResponseBody> httpResponse = orderMicroservice.editOrder(orderRequestBody);
        OrderResponseBody body = httpResponse.getBody();
        apiTestContext.setActualErrorMessage(body.getError());
        int codeResponse = httpResponse.getStatusCode();
        this.apiTestContext.setActualStatusCode(codeResponse);
    }

    @When("^I delete an order$")
    public void deleteOrder() throws ParseException {
        OrderRequestBody orderRequestBody = new OrderRequestBody(emptyKey);
        HttpResponse<OrderResponseBody> httpResponse = orderMicroservice.deleteOrder(orderRequestBody);
        OrderResponseBody body = httpResponse.getBody();
        apiTestContext.setActualErrorMessage(body.getError());
        int codeResponse = httpResponse.getStatusCode();
        this.apiTestContext.setActualStatusCode(codeResponse);
    }

    @When("^I get info about the order$")
    public void getOrderInfo() throws ParseException {
        OrderRequestBody orderRequestBody = new OrderRequestBody(emptyKey);
        HttpResponse<OrderResponseBody> httpResponse = orderMicroservice.getOrderInfo(orderRequestBody);
        OrderResponseBody body = httpResponse.getBody();
        apiTestContext.setActualErrorMessage(body.getError());
        int codeResponse = httpResponse.getStatusCode();
        this.apiTestContext.setActualStatusCode(codeResponse);
    }

    @When("^I get history about the order$")
    public void getOrderHistory() throws ParseException {
        OrderRequestBody orderRequestBody = new OrderRequestBody(emptyKey);
        HttpResponse<OrderResponseBody> httpResponse = orderMicroservice.getOrderHistory(orderRequestBody);
        OrderResponseBody body = httpResponse.getBody();
        apiTestContext.setActualErrorMessage(body.getError());
        int codeResponse = httpResponse.getStatusCode();
        this.apiTestContext.setActualStatusCode(codeResponse);
    }

    @And("^I should see an error message \"(.*)\"$")
    public void checkOrderErrorMessage(String expectedMessage) {
        Objects.requireNonNull(expectedMessage, "Expected message cannot be null.");
        String actualMessage = apiTestContext.getActualErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage,
                "The expected error message does not match the actual one");
    }
}
