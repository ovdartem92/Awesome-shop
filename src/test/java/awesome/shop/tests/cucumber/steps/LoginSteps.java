package awesome.shop.tests.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.awesome.shop.ta.framework.configuration.PropertyManager;
import ru.awesome.shop.ta.product.pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @When("user open LoginPage")
    public void openLoginPage() {
        loginPage.open();
    }

    @When("user type valid email")
    public void typeValidEmail() {
        loginPage.typeEmailAddress(PropertyManager.getEmail());
    }

    @When("user type valid password")
    public void typeValidPassword() {
        loginPage.typePassword(PropertyManager.getPassword());
    }

    @When("user click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("text {string} is displayed")
    public void verifyTextIsDisplayed(String text) {
        Assert.assertEquals(text, "My Account", "The final text isn't equals expected!");
    }
}
