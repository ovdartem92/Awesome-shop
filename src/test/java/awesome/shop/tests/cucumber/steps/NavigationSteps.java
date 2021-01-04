package awesome.shop.tests.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import ru.awesome.shop.ta.framework.browser.Browser;
import ru.awesome.shop.ta.product.services.NavigationService;

public class NavigationSteps {
    private final NavigationService navigationService = new NavigationService();

    @Given("I have navigated to phones catalog")
    public void navigateToPhonesCatalog() {
        navigationService.navigateToPhonesCatalogPage();
    }

    @Given("I have navigated to laptops catalog")
    public void navigateToLaptopsCatalog() {
        navigationService.navigateToLaptopsCatalogPage();
    }

    @And("I navigate to cart")
    public void navigateToCart() {
        navigationService.navigateToCartPage();
    }

    @Given("I have navigated to home page")
    public void navigateToHomePage() {
        navigationService.navigateToHomePage();
    }

    @Then("I should navigated to {string} page")
    public void verifyPageTitle(String pageTitle) {
        String resultTitle = Browser.getInstance().getPageTitle();
        Assert.assertEquals(resultTitle, pageTitle);
    }
}
