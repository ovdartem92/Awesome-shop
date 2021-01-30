package awesome.shop.tests.api.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.bo.Product;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.AddItemRequestBody;
import ru.awesome.shop.ta.product.http.body.request.EditCartRequestBody;
import ru.awesome.shop.ta.product.http.body.request.RemoveItemRequestBody;
import ru.awesome.shop.ta.product.http.body.response.ChangeCartResponseBody;
import ru.awesome.shop.ta.product.http.body.response.OpenCartResponseBody;
import ru.awesome.shop.ta.product.microservices.CartMicroservice;
import org.json.simple.parser.ParseException;

import java.util.List;

public class CartSteps {
    private HttpClient httpClient = new HttpClient();
    private ApiTestContext apiTestContext;
    private CartMicroservice cartMicroservice;

    public CartSteps(ApiTestContext apiTestContext) {
        this.apiTestContext = apiTestContext;
        this.cartMicroservice = new CartMicroservice(httpClient, apiTestContext.getToken());
    }

    @When("^I add item to cart with item id (.*) and quantity (.*)$")
    public void addItemToCart(int itemId, int amount) throws JsonProcessingException, ParseException {
        AddItemRequestBody addItemRequestBody = new AddItemRequestBody(itemId, amount);
        HttpResponse<ChangeCartResponseBody> response = cartMicroservice.addItem(addItemRequestBody);
        ChangeCartResponseBody responseBody = response.getBody();
        String actualSuccessMessage = responseBody.getSuccess();
        int actualStatusCode = response.getStatusCode();
        apiTestContext.setActualSuccessMessage(actualSuccessMessage);
        apiTestContext.setActualCodeResponse(actualStatusCode);
    }

    @Then("^I should see message success \"(.*)\"$")
    public void checkSuccessMessage(String message) {
        Assert.assertEquals(apiTestContext.getActualSuccessMessage(), message,
                "Wrong success message");
    }

    @Then("^I should see this item in the cart with item id (.*) and quantity (.*)$")
    public void checkItemInCart(int itemId, int quantity) {
        int actualItemId = apiTestContext.getProduct().getProduct_id();
        int actualQuantity = apiTestContext.getProduct().getQuantity();
        Assert.assertEquals(actualItemId, itemId, "Wrong product id in the cart");
        Assert.assertEquals(actualQuantity, quantity, "Wrong product quantity in the cart");
    }


    @When("^I open cart$")
    public void openCart() {
        HttpResponse<OpenCartResponseBody> response = cartMicroservice.openCart();
        OpenCartResponseBody items = response.getBody();
        Product product = items.getProducts().get(0);
        apiTestContext.setProduct(product);
    }

    @When("^I edit item quantity (.*) in cart$")
    public void editQuantityInCart(int quantity) throws JsonProcessingException, ParseException {
        int cartId = apiTestContext.getProduct().getCart_id();
        EditCartRequestBody editCartRequestBody = new EditCartRequestBody(cartId, quantity);
        HttpResponse<ChangeCartResponseBody> response = cartMicroservice.editCart(editCartRequestBody);
        ChangeCartResponseBody body = response.getBody();
        String actualSuccessMessage = body.getSuccess();
        apiTestContext.setActualSuccessMessage(actualSuccessMessage);
    }

    @Then("^I should see this item in the cart with quantity (.*)$")
    public void checkQuantityItem(int expectedQuantity) {
        HttpResponse<OpenCartResponseBody> response = cartMicroservice.openCart();
        OpenCartResponseBody items = response.getBody();
        Product product = items.getProducts().get(0);
        int actualQuantity = product.getQuantity();
        Assert.assertEquals(actualQuantity, expectedQuantity, "Wrong product quantity in the cart");
    }

    @When("I remember cart id")
    public void getCartId() {
        HttpResponse<OpenCartResponseBody> response = cartMicroservice.openCart();
        OpenCartResponseBody items = response.getBody();
        Product product = items.getProducts().get(0);
        apiTestContext.setProduct(product);
    }

    @When("I remove item from cart")
    public void removeFromCart() throws JsonProcessingException, ParseException {
        int cartId = apiTestContext.getProduct().getCart_id();
        RemoveItemRequestBody deleteItemRequestBody = new RemoveItemRequestBody(cartId);
        HttpResponse<ChangeCartResponseBody> response = cartMicroservice.removeItemFromCart(deleteItemRequestBody);
        ChangeCartResponseBody responseBody = response.getBody();
        String actualSuccessMessage = responseBody.getSuccess();
        apiTestContext.setActualSuccessMessage(actualSuccessMessage);
        int statusCode = response.getStatusCode();
        apiTestContext.setActualCodeResponse(statusCode);
    }

    @Then("I should see that cart is empty")
    public void checkThatCartIsEmpty() {
        HttpResponse<OpenCartResponseBody> response = cartMicroservice.openCart();
        OpenCartResponseBody body = response.getBody();
        List<Product> products = body.getProducts();
        Assert.assertTrue(products.isEmpty(), "Products wasn't removed from cart");
    }

    @Then("^I should see response status code (.*)")
    public void iSeeResponseStatusCode(int expectedCode) {
        Assert.assertEquals(apiTestContext.getActualCodeResponse(), expectedCode, "Wrong response status code");
    }
}
