package awesome.shop.tests.api.Steps;

import awesome.shop.tests.api.CartApiService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import ru.awesome.shop.ta.framework.apiEngine.ChangeCartResponse;
import ru.awesome.shop.ta.framework.apiEngine.ItemResponse;
import ru.awesome.shop.ta.product.bo.Product;

import java.util.List;

public class CartSteps {
    private String actualSuccessCartMessage;
    private TextContextApi testContext;

    public CartSteps(TextContextApi textContextApi) {
        this.testContext = textContextApi;
    }

    @When("^I add item to cart with item id (.*) and quantity (.*)$")
    public void addItemToCart(String itemId, int amount) {
        Response response = CartApiService.addItem(itemId, amount, testContext.getToken());
        ChangeCartResponse addItemResponse = response.getBody().as(ChangeCartResponse.class);
        actualSuccessCartMessage = addItemResponse.getSuccess();
    }

    @Then("^I see message success \"(.*)\"$")
    public void checkSuccessMessage(String message) {
        Assert.assertEquals(actualSuccessCartMessage, message,
                "Wrong success message");
    }

    @Then("^I see this item in the cart with item id (.*) and quantity (.*)$")
    public void checkItemInCart(int itemId, int quantity) {
        Response response = CartApiService.checkItemInCart(testContext.getToken());
        ItemResponse items = response.getBody().as(ItemResponse.class);
        Product product = items.getProducts().get(0);
        int cartId = product.getCart_id();
        testContext.setCartId(cartId);
        int actualItemId = product.getProduct_id();
        int actualQuantity = product.getQuantity();
        Assert.assertEquals(actualItemId, itemId, "Wrong product id in the cart");
        Assert.assertEquals(actualQuantity, quantity, "Wrong product quantity in the cart");
    }

    @When("^I edit item quantity (.*) in cart$")
    public void editQuantityInCart(int quantity) {
        Response response = CartApiService.editItemQuantity(testContext.getToken(), quantity, testContext.getCartId());
        ChangeCartResponse changeCartResponse = response.getBody().as(ChangeCartResponse.class);
        actualSuccessCartMessage = changeCartResponse.getSuccess();
    }

    @Then("^I see this item in the cart with quantity (.*)$")
    public void checkQuantityItem(int expectedQuantity) {
        Response response = CartApiService.checkItemInCart(testContext.getToken());
        ItemResponse items = response.getBody().as(ItemResponse.class);
        Product product = items.getProducts().get(0);
        int actualQuantity = product.getQuantity();
        Assert.assertEquals(actualQuantity, expectedQuantity, "Wrong product quantity in the cart");
    }

    @And("I have cart id")
    public void getCartId() {
        Response response = CartApiService.checkItemInCart(testContext.getToken());
        ItemResponse items = response.getBody().as(ItemResponse.class);
        Product product = items.getProducts().get(0);
        int cartId = product.getCart_id();
        testContext.setCartId(cartId);
    }

    @And("I remove item from cart")
    public void removeFromCart() {
        Response response = CartApiService.removeItemFromCart(testContext.getToken(), testContext.getCartId());
        ChangeCartResponse changeCartResponse = response.getBody().as(ChangeCartResponse.class);
        actualSuccessCartMessage = changeCartResponse.getSuccess();
    }

    @And("I see that cart is empty")
    public void checkThatCartIsEmpty() {
        Response response = CartApiService.checkItemInCart(testContext.getToken());
        ItemResponse items = response.getBody().as(ItemResponse.class);
        List<Product> products = items.getProducts();
        Assert.assertTrue(products.isEmpty(), "Products wasn't removed from cart");
    }
}
