package awesome.shop.tests.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.LaptopsCatalogPage;
import ru.awesome.shop.ta.product.pages.PhonesCatalogPage;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;
import ru.awesome.shop.ta.product.services.CartService;

public class CartSteps {
    private final PhonesCatalogPage phonesCatalogPage = new PhonesCatalogPage();
    private final LaptopsCatalogPage laptopsCatalogPage = new LaptopsCatalogPage();
    private final CartService cartService = new CartService();
    private final CartPage cartPage = new CartPage();
    private final HomePage homePage = new HomePage();
    private final CartTotalPopup cartTotalPopup = new CartTotalPopup();

    @When("I click cart button")
    public void clickCartButton() {
        homePage.clickCartTotalButton();
    }

    @When("I add phone {string} to cart")
    public void addPhoneToCart(String phoneName) {
        phonesCatalogPage.clickAddPhoneToCartButton(phoneName);
    }

    @And("I add laptop {string} to cart")
    public void addLaptopToCart(String laptopName) {
        laptopsCatalogPage.clickAddLaptopToCartButton(laptopName);
    }

    @And("I set quantity {int} for product {string}")
    public void setQuantityForProduct(int quantity, String productName) {
        cartService.updateProductQuantity(productName, quantity);
    }

    @And("I remove product {string} from cart")
    public void removeProductFromCart(String productName) {
        cartService.deleteProduct(productName);
    }

    @And("I click checkout expecting success")
    public void clickCheckoutExpectingSuccess() {
        cartPage.clickCheckoutButton();
    }

    @And("I click checkout expecting failure")
    public void clickCheckoutExpectingFailure() {
        cartPage.clickCheckoutButtonExpectingFailure();
    }

    @And("I click continue")
    public void clickContinue() {
        cartPage.clickContinueButton();
    }

    @And("I click continue shopping")
    public void clickContinueShopping() {
        cartPage.clickContinueShoppingButton();
    }

    @Then("The product name into cart should be the same as {string}")
    public void verifyNameOfProduct(String productName) {
        String nameIntoCart = cartPage.getItemName(productName);
        Assert.assertEquals(nameIntoCart, productName, "The names aren't equals!");
    }

    @Then("The number of products into cart should be more than {int}")
    public void verifyProductsIntoCartNumber(int number) {
        int size = cartPage.getNumberOfCartItems();
        Assert.assertTrue(size > number, "The size of product list less then " + number);
    }

    @Then("The quantity for product {string} should be {int}")
    public void verifyQuantityOfProduct(String productName, int quantity) {
        int resultQuantity = cartService.getProductQuantity(productName);
        Assert.assertEquals(resultQuantity, quantity, "Quantities aren't equals!");
    }

    @Then("The quantity warning message should be displayed")
    public void verifyQuantityWarning() {
        String warningQuantityMessage = cartService.getQuantityWarning();
        Assert.assertEquals(warningQuantityMessage,
                "Products marked with *** are not available in the desired quantity or not in stock!\n" + "×",
                "There is no warning about quantity on page!");
    }

    @Then("The empty cart message should be displayed")
    public void verifyEmptyCartMessage() {
        String emptyCartMessage = cartService.getEmptyCartMessage();
        Assert.assertEquals(emptyCartMessage, "Your shopping cart is empty!", "Messages aren't equals");
    }

    @Then("The empty cart message from pupUp should be displayed")
    public void verifyEmptyCartMessageFromPopUp() {
        String messageFromPopup = cartTotalPopup.getEmptyCartMessage();
        Assert.assertEquals(messageFromPopup, "Your shopping cart is empty!", "Messages aren't equals");
    }


    @Then("The product name should be {string}")
    public void theProductNameShouldBe(String productName) {
        String nameProductFromCart = cartService.getProductName(productName);
        Assert.assertEquals(nameProductFromCart, productName, "The names of product aren't equals!");
    }

    @Then("The product price for {string} should be {string}")
    public void theProductPriceShouldBe(String productName, String productPrice) {
        String priceProductFromCart = cartService.getProductPrice(productName);
        Assert.assertEquals(priceProductFromCart, productPrice, "The costs of product aren't equals!");
    }
}
