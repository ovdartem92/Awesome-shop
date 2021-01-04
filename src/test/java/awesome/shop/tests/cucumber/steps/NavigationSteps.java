package awesome.shop.tests.cucumber.steps;

import io.cucumber.java.en.Given;
import ru.awesome.shop.ta.product.services.NavigationService;

public class NavigationSteps {

    @Given("^I have opened login page$")
    public void openLoginPage() {
        NavigationService navigationService = new NavigationService();
        navigationService.navigateToLoginPage();
    }
}
