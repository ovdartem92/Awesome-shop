package awesome.shop.tests.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.product.pages.CartPage;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.LaptopsCatalogPage;
import ru.awesome.shop.ta.product.pages.PhonesCatalogPage;
import ru.awesome.shop.ta.product.pages.popups.CartTotalPopup;
import ru.awesome.shop.ta.product.services.CartService;
import ru.awesome.shop.ta.product.services.NavigationService;

public class CartSteps {
    private final NavigationService navigationService = new NavigationService();
    private final PhonesCatalogPage phonesCatalogPage = new PhonesCatalogPage();
    private final LaptopsCatalogPage laptopsCatalogPage = new LaptopsCatalogPage();
    private final CartService cartService = new CartService();
    private final CartPage cartPage = new CartPage();
    private final HomePage homePage = new HomePage();

    @Given("user navigate to phones catalog")
    public void navigateToPhonesCatalog() {
        navigationService.navigateToPhonesCatalogPage();
    }

    @Given("user navigate to home page")
    public void navigateToHome() {
        navigationService.navigateToHomePage();
    }

    @And("user navigate to laptops catalog")
    public void navigateToLaptopsCatalog() {
        navigationService.navigateToLaptopsCatalogPage();
    }

    @And("user navigate to cart")
    public void navigateToCart() {
        navigationService.navigateToCartPage();
    }

    @When("user click cart button")
    public void clickCartButton() {
        homePage.clickCartTotalButton();
    }

    @When("user add phone {string} to cart")
    public void addPhoneToCart(String phoneName) {
        phonesCatalogPage.clickAddPhoneToCartButton(phoneName);
    }

    @And("user add laptop {string} to cart")
    public void addLaptopToCart(String laptopName) {
        laptopsCatalogPage.clickAddLaptopToCartButton(laptopName);
    }

    @And("user set quantity {int} for product {string}")
    public void setQuantity(int quantity, String productName) {
        cartService.updateProductQuantity(productName, quantity);
    }

    @And("user remove product {string} from cart")
    public void removeProductFromCart(String productName) {
        cartService.deleteProduct(productName);
    }

    @And("user click checkout expecting success")
    public void clickCheckoutExpectingSuccess() {
        cartPage.clickCheckoutButton();
    }

    @And("user click checkout expecting failure")
    public void clickCheckoutExpectingFailure() {
        cartPage.clickCheckoutButtonExpectingFailure();
    }

    @And("user click continue")
    public void clickContinue() {
        cartPage.clickContinueButton();
    }

    @And("user click continue shopping")
    public void clickContinueShopping() {
        cartPage.clickContinueShoppingButton();
    }

    @Then("user check that product name into cart the same as phone {string}")
    public void verifyName(String productName) {
        String nameIntoCart = cartPage.getItemName(productName);
        Assert.assertEquals(nameIntoCart, productName, "The names aren't equals!");
    }

    @Then("user check that products number is more than {int}")
    public void verifyNumber(int number) {
        int size = cartPage.getNumberOfCartItems();
        Assert.assertTrue(size > number, "The size of product list less then " + number);
    }

    @Then("user check that quantity for product {string} the same as {int}")
    public void verifyQuantity(String productName, int quantity) {
        int resultQuantity = cartService.getProductQuantity(productName);
        Assert.assertEquals(resultQuantity, quantity, "Quantities aren't equals!");
    }

    @Then("user check that was navigated to {string} page")
    public void verifyPage(String pageTitle) {
        String resultTitle = Browser.getInstance().getPageTitle();
        Assert.assertEquals(resultTitle, pageTitle);
    }

    @Then("user check that quantity warning message is appeared")
    public void verifyQuantityWarning() {
        String warningQuantityMessage = cartService.getQuantityWarning();
        Assert.assertEquals(warningQuantityMessage,
                "Products marked with *** are not available in the desired quantity or not in stock!\n" + "×",
                "There is no warning about quantity on page!");
    }

    @Then("user check that empty cart message is appeared")
    public void verifyEmptyCart() {
        String emptyCartMessage = cartService.getEmptyCartMessage();
        Assert.assertEquals(emptyCartMessage, "Your shopping cart is empty!", "Messages aren't equals");
    }

    @Then("user check that empty cart message from pupUp is appeared")
    public void verifyEmptyCartFromPopUp() {
        String messageFromPopup = new CartTotalPopup().getEmptyCartMessage();
        Assert.assertEquals(messageFromPopup, "Your shopping cart is empty!", "Messages aren't equals");
    }

    @Then("user check that product name is {string} and price is {string}")
    public void verifyProductNameAndPrice(String productName, String productPrice) {
        String nameProductFromCart = cartService.getProductName(productName);
        String priceProductFromCart = cartService.getProductPrice(productName);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(nameProductFromCart, productName, "The names of product aren't equals!");
        softAssert.assertEquals(priceProductFromCart, productPrice, "The costs of product aren't equals!");
        softAssert.assertAll();
    }
}
