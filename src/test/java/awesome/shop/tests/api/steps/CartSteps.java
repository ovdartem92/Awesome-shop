package awesome.shop.tests.api.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.AddItemRequestBody;
import ru.awesome.shop.ta.product.http.body.request.RemoveItemRequestBody;
import ru.awesome.shop.ta.product.http.body.request.EditCartRequestBody;
import ru.awesome.shop.ta.product.http.body.response.ChangeCartResponseBody;
import ru.awesome.shop.ta.product.http.body.response.OpenCartResponseBody;
import ru.awesome.shop.ta.product.bo.Product;
import ru.awesome.shop.ta.product.microservices.CartMicroservice;

import java.util.List;

public class CartSteps {
    private HttpClient httpClient = new HttpClient();
    private String actualSuccessCartMessage;
    private int actualStatusCode;
    private TextContextApi testContext;
    private CartMicroservice cartMicroservice = new CartMicroservice(httpClient);

    public CartSteps(TextContextApi textContextApi) {
        this.testContext = textContextApi;
    }

    @When("^I add item to cart with item id (.*) and quantity (.*)$")
    public void addItemToCart(int itemId, int amount) throws JsonProcessingException, ParseException {
        AddItemRequestBody addItemRequestBody = new AddItemRequestBody(itemId, amount);
        HttpResponse<ChangeCartResponseBody> response = cartMicroservice.addItem(addItemRequestBody, testContext.getToken());
        ChangeCartResponseBody responseBody = response.getBody();
        actualSuccessCartMessage = responseBody.getSuccess();
        actualStatusCode = response.getResponseStatusCode();
    }

    @Then("^I see message success \"(.*)\"$")
    public void checkSuccessMessage(String message) {
        Assert.assertEquals(actualSuccessCartMessage, message,
                "Wrong success message");
    }

    @Then("^I see this item in the cart with item id (.*) and quantity (.*)$")
    public void checkItemInCart(int itemId, int quantity) {
        HttpResponse<OpenCartResponseBody> response = cartMicroservice.openCart(testContext.getToken());
        OpenCartResponseBody items = response.getBody();
        System.out.println(items.toString());
        Product product = items.getProducts().get(0);
        int cartId = product.getCart_id();
        testContext.setCartId(cartId);
        int actualItemId = product.getProduct_id();
        int actualQuantity = product.getQuantity();
        Assert.assertEquals(actualItemId, itemId, "Wrong product id in the cart");
        Assert.assertEquals(actualQuantity, quantity, "Wrong product quantity in the cart");
    }

    @When("^I edit item quantity (.*) in cart$")
    public void editQuantityInCart(int quantity) throws JsonProcessingException, ParseException {
        EditCartRequestBody editCartRequestBody = new EditCartRequestBody(testContext.getCartId(), quantity);
        actualSuccessCartMessage = cartMicroservice.editCart(editCartRequestBody, testContext.getToken()).getBody().getSuccess();
    }

    @Then("^I see this item in the cart with quantity (.*)$")
    public void checkQuantityItem(int expectedQuantity) {
        HttpResponse<OpenCartResponseBody> response = cartMicroservice.openCart(testContext.getToken());
        OpenCartResponseBody items = response.getBody();
        Product product = items.getProducts().get(0);
        int actualQuantity = product.getQuantity();
        Assert.assertEquals(actualQuantity, expectedQuantity, "Wrong product quantity in the cart");
    }

    @And("I have cart id")
    public void getCartId() {
        HttpResponse<OpenCartResponseBody> response = cartMicroservice.openCart(testContext.getToken());
        OpenCartResponseBody items = response.getBody();
        System.out.println(items.toString());
        Product product = items.getProducts().get(0);
        int cartId = product.getCart_id();
        testContext.setCartId(cartId);
        System.out.println(testContext.getCartId());
    }

    @And("I remove item from cart")
    public void removeFromCart() throws JsonProcessingException, ParseException {
        RemoveItemRequestBody deleteItemRequestBody = new RemoveItemRequestBody(testContext.getCartId());
        HttpResponse<ChangeCartResponseBody> response = cartMicroservice.removeItemFromCart(deleteItemRequestBody, testContext.getToken());
        ChangeCartResponseBody responseBody = response.getBody();
        actualSuccessCartMessage = responseBody.getSuccess();
        actualStatusCode = response.getResponseStatusCode();
    }

    @And("I see that cart is empty")
    public void checkThatCartIsEmpty() {
        HttpResponse<OpenCartResponseBody> response = cartMicroservice.openCart(testContext.getToken());
        OpenCartResponseBody body = response.getBody();
        List<Product> products = body.getProducts();
        Assert.assertTrue(products.isEmpty(), "Products wasn't removed from cart");


//        Response response = cartApiService.checkItemInCart(testContext.getToken());
//        OpenCartResponseBody items = response.getBody().as(OpenCartResponseBody.class);
//        List<Product> products = items.getProducts();
//        Assert.assertTrue(products.isEmpty(), "Products wasn't removed from cart");
    }

    @And("^I see response status code (.*)")
    public void iSeeResponseStatusCode(int expectedCode) {
        Assert.assertEquals(actualStatusCode, expectedCode, "Wrong response status code");
    }
}
