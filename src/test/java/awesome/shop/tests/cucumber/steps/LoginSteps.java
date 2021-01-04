package awesome.shop.tests.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import rp.org.apache.http.auth.AuthenticationException;
import ru.awesome.shop.ta.framework.configuration.PropertyManager;
import ru.awesome.shop.ta.product.services.AccountService;
import ru.awesome.shop.ta.product.services.AuthenticationService;

public class LoginSteps {
    private static final String VALID_EMAIL = PropertyManager.getEmail();
    private static final String VALID_PASSWORD = PropertyManager.getPassword();
    private AuthenticationService authenticationService = new AuthenticationService();
    private TestContext testContext;

    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @When("^I login with valid credentials$")
    public void userLoginWithValidCredentials() throws AuthenticationException {
        authenticationService.login(VALID_EMAIL, VALID_PASSWORD);
    }

    @Then("^I should see (.*) account name$")
    public void checkMyAccountName(String expectedAccountName) {
        AccountService accountService = new AccountService();
        String actualAccountName = accountService.getAccountName();
        Assert.assertEquals(actualAccountName, expectedAccountName, "Incorrect account name");
    }

    @And("^I click logout button$")
    public void clickLogoutButton() {
        authenticationService.logout();
    }

    @Then("^Logout page with title (.*) should be opened$")
    public void checkThatLogoutPageIsOpened(String expectedPageTitle) {
        String actualPageTitle = authenticationService.getLogoutPageTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Incorrect logout page title");
    }

    @And("^I should see that breadcrumb contains (.*) text$")
    public void checkBreadcrumb(String expectedBreadcrumbText) {
        String actualBreadcrumbLogoutText = authenticationService.getBreadcrumbLogoutText();
        Assert.assertEquals(actualBreadcrumbLogoutText, expectedBreadcrumbText,
                "Incorrect breadcrumbls logout text");
    }

    @When("^I login with (.*) email and (.*) password$")
    public void iLoginWithEmailEmailAndPasswordPassword(String email, String password) {
        try {
            authenticationService.login(email, password);
        } catch (AuthenticationException e) {
            testContext.errorMessage = e.getMessage().replace("Authentication failed", "").trim();
        }
    }

    @Then("^I should see authentication error message (.*)$")
    public void iShouldSeeAuthenticationErrorMessageErrorMessage(String expectedErrorMessage) {
        Assert.assertEquals(testContext.errorMessage, expectedErrorMessage, "Incorrect error message text");
    }
}
