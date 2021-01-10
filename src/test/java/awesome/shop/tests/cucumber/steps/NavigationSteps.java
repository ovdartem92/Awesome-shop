package awesome.shop.tests.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.product.services.NavigationService;

public class NavigationSteps {
    private final NavigationService navigationService = new NavigationService();

    @Given("^I have opened login page$")
    public void openLoginPage() {
        navigationService.navigateToLoginPage();
    }

    @Given("^I have opened home page$")
    public void openHomePage() {
        navigationService.navigateToHomePage();
    }

    @Given("I navigate to phones catalog")
    public void navigateToPhonesCatalog() {
        navigationService.navigateToPhonesCatalogPage();
    }

    @Given("I navigate to laptops catalog")
    public void navigateToLaptopsCatalog() {
        navigationService.navigateToLaptopsCatalogPage();
    }

    @When("I navigate to cart")
    public void navigateToCart() {
        navigationService.navigateToCartPage();
    }

    @Then("I should be navigated to {string} page")
    public void verifyPageTitle(String pageTitle) {
        String resultTitle = Browser.getInstance().getPageTitle();
        Assert.assertEquals(resultTitle, pageTitle);
    }
}
