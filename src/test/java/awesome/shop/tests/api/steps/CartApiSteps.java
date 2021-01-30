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

public class CartApiSteps {
    private HttpClient httpClient = new HttpClient();
    private String actualSuccessCartMessage;
    private ApiTestContext apiTestContext;
    private CartMicroservice cartMicroservice;

    public CartApiSteps(ApiTestContext textContextApi) {
        this.apiTestContext = textContextApi;
        this.cartMicroservice = new CartMicroservice(httpClient, apiTestContext.getToken());
    }

    @When("^I add item to cart with item id (.*) and quantity (.*)$")
    public void addItemToCart(int itemId, int amount) throws JsonProcessingException, ParseException {
        AddItemRequestBody addItemRequestBody = new AddItemRequestBody(itemId, amount);
        HttpResponse<ChangeCartResponseBody> response = cartMicroservice.addItem(addItemRequestBody);
        ChangeCartResponseBody responseBody = response.getBody();
        actualSuccessCartMessage = responseBody.getSuccess();
        apiTestContext.setActualCodeResponse(response.getStatusCode());
    }

    @Then("^I see message success \"(.*)\"$")
    public void checkSuccessMessage(String message) {
        Assert.assertEquals(actualSuccessCartMessage, message,
                "Wrong success message");
    }

    @Then("^I see this item in the cart with item id (.*) and quantity (.*)$")
    public void checkItemInCart(int itemId, int quantity) {
        HttpResponse<OpenCartResponseBody> response = cartMicroservice.openCart();
        OpenCartResponseBody items = response.getBody();
        Product product = items.getProducts().get(0);
        int cartId = product.getCart_id();
        apiTestContext.setCartId(cartId);
        int actualItemId = product.getProduct_id();
        int actualQuantity = product.getQuantity();
        Assert.assertEquals(actualItemId, itemId, "Wrong product id in the cart");
        Assert.assertEquals(actualQuantity, quantity, "Wrong product quantity in the cart");
    }

    @When("^I edit item quantity (.*) in cart$")
    public void editQuantityInCart(int quantity) throws JsonProcessingException, ParseException {
        EditCartRequestBody editCartRequestBody = new EditCartRequestBody(apiTestContext.getCartId(), quantity);
        HttpResponse<ChangeCartResponseBody> response = cartMicroservice.editCart(editCartRequestBody);
        ChangeCartResponseBody body = response.getBody();
        actualSuccessCartMessage = body.getSuccess();
    }

    @Then("^I see this item in the cart with quantity (.*)$")
    public void checkQuantityItem(int expectedQuantity) {
        HttpResponse<OpenCartResponseBody> response = cartMicroservice.openCart();
        OpenCartResponseBody items = response.getBody();
        Product product = items.getProducts().get(0);
        int actualQuantity = product.getQuantity();
        Assert.assertEquals(actualQuantity, expectedQuantity, "Wrong product quantity in the cart");
    }

    @And("I have cart id")
    public void getCartId() {
        HttpResponse<OpenCartResponseBody> response = cartMicroservice.openCart();
        OpenCartResponseBody items = response.getBody();
        Product product = items.getProducts().get(0);
        int cartId = product.getCart_id();
        apiTestContext.setCartId(cartId);
    }

    @And("I remove item from cart")
    public void removeFromCart() throws JsonProcessingException, ParseException {
        RemoveItemRequestBody deleteItemRequestBody = new RemoveItemRequestBody(apiTestContext.getCartId());
        HttpResponse<ChangeCartResponseBody> response = cartMicroservice.removeItemFromCart(deleteItemRequestBody);
        ChangeCartResponseBody responseBody = response.getBody();
        actualSuccessCartMessage = responseBody.getSuccess();
        int statusCode = response.getStatusCode();
        apiTestContext.setActualCodeResponse(statusCode);
    }

    @And("I see that cart is empty")
    public void checkThatCartIsEmpty() {
        HttpResponse<OpenCartResponseBody> response = cartMicroservice.openCart();
        OpenCartResponseBody body = response.getBody();
        List<Product> products = body.getProducts();
        Assert.assertTrue(products.isEmpty(), "Products wasn't removed from cart");
    }

    @And("^I see response status code (.*)")
    public void iSeeResponseStatusCode(int expectedCode) {
        Assert.assertEquals(apiTestContext.getActualCodeResponse(), expectedCode, "Wrong response status code");
    }
}
