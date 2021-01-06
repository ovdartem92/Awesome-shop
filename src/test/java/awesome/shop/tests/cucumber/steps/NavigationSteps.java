package awesome.shop.tests.cucumber.steps;

import io.cucumber.java.en.Given;
import ru.awesome.shop.ta.product.services.NavigationService;

public class NavigationSteps {
    private NavigationService navigationService = new NavigationService();

    @Given("^I have opened login page$")
    public void openLoginPage() {
        navigationService.navigateToLoginPage();
    }

    @Given("^I have opened home page$")
    public void openHomePage() {
        navigationService.navigateToHomePage();
    }
}
