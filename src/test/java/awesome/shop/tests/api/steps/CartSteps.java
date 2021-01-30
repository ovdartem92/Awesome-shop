package awesome.shop.tests.api.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
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
        this.apiTestContext.setActualSuccessMessage(actualSuccessMessage);
        this.apiTestContext.setActualStatusCode(actualStatusCode);
    }

    @Then("^I should see message success \"(.*)\"$")
    public void checkSuccessMessage(String message) {
        Assert.assertEquals(this.apiTestContext.getActualSuccessMessage(), message,
                "Wrong success message");
    }

    @Then("^I should see this item in the cart with item id (.*)$")
    public void checkItemInCart(int itemId) {
        List<Product> products = this.apiTestContext.getProducts();
        Product product = products.get(0);
        int actualItemId = product.getProduct_id();
        Assert.assertEquals(actualItemId, itemId, "Wrong product id in the cart");
    }


    @When("^I open cart$")
    public void openCart() {
        HttpResponse<OpenCartResponseBody> response = cartMicroservice.openCart();
        OpenCartResponseBody items = response.getBody();
        this.apiTestContext.setProducts(items.getProducts());
    }

    @When("^I edit item quantity (.*) in cart$")
    public void editQuantityInCart(int quantity) throws JsonProcessingException, ParseException {
        List<Product> products = apiTestContext.getProducts();
        Product product = products.get(0);
        int cartId = product.getCart_id();
        EditCartRequestBody editCartRequestBody = new EditCartRequestBody(cartId, quantity);
        HttpResponse<ChangeCartResponseBody> response = cartMicroservice.editCart(editCartRequestBody);
        ChangeCartResponseBody body = response.getBody();
        String actualSuccessMessage = body.getSuccess();
        int actualStatusCode = response.getStatusCode();
        this.apiTestContext.setActualStatusCode(actualStatusCode);
        this.apiTestContext.setActualSuccessMessage(actualSuccessMessage);
    }

    @Then("^I should see this item in the cart with quantity (.*)$")
    public void checkQuantityItem(int expectedQuantity) {
        List<Product> products = this.apiTestContext.getProducts();
        Product product = products.get(0);
        int actualQuantity = product.getQuantity();
        Assert.assertEquals(actualQuantity, expectedQuantity, "Wrong product quantity in the cart");
    }

    @When("I remember cart id")
    public void getCartId() {
        HttpResponse<OpenCartResponseBody> response = cartMicroservice.openCart();
        OpenCartResponseBody items = response.getBody();
        this.apiTestContext.setProducts(items.getProducts());
    }

    @When("I remove item from cart")
    public void removeFromCart() throws JsonProcessingException, ParseException {
        List<Product> products = this.apiTestContext.getProducts();
        Product product = products.get(0);
        int cartId = product.getCart_id();
        RemoveItemRequestBody deleteItemRequestBody = new RemoveItemRequestBody(cartId);
        HttpResponse<ChangeCartResponseBody> response = cartMicroservice.removeItemFromCart(deleteItemRequestBody);
        ChangeCartResponseBody responseBody = response.getBody();
        String actualSuccessMessage = responseBody.getSuccess();
        this.apiTestContext.setActualSuccessMessage(actualSuccessMessage);
        int statusCode = response.getStatusCode();
        this.apiTestContext.setActualStatusCode(statusCode);
    }

    @Then("I should see that cart is empty")
    public void checkThatCartIsEmpty() {
        List<Product> products = this.apiTestContext.getProducts();
        Assert.assertTrue(products.isEmpty(), "Products wasn't removed from cart");
    }

    @Then("^I should see response status code (.*)")
    public void checkStatusCode(int expectedCode) {
        Assert.assertEquals(this.apiTestContext.getActualStatusCode(), expectedCode, "Wrong response status code");
    }
}
