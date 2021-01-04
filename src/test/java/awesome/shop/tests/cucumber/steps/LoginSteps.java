package awesome.shop.tests.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import rp.org.apache.http.auth.AuthenticationException;
import ru.awesome.shop.ta.framework.configuration.PropertyManager;
import ru.awesome.shop.ta.framework.logging.Log;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;
import ru.awesome.shop.ta.product.services.AccountService;
import ru.awesome.shop.ta.product.services.AuthenticationService;
import ru.awesome.shop.ta.product.services.NavigationService;

import java.util.HashMap;
import java.util.Map;

public class LoginSteps {

    private static final String VALID_EMAIL = PropertyManager.getEmail();
    private static final String VALID_PASSWORD = PropertyManager.getPassword();
    private AuthenticationService authenticationService = new AuthenticationService();

    @Given("^login page is opened$")
    public void openLoginPage() {
        NavigationService navigationService = new NavigationService();
        navigationService.navigateToLoginPage();
    }

    @Then("^My Account label is appeared$")
    public void checkMyAccountName() {
        AccountService accountService = new AccountService();
        String myAccountName = accountService.getAccountName();
        Assert.assertEquals(myAccountName, "My Account", "Incorrect account name");
    }

    @And("^login with valid credentials$")
    public void userLoginWithValidCredentials() throws AuthenticationException {
        authenticationService.login(VALID_EMAIL, VALID_PASSWORD);
    }

    @And("^click logout button$")
    public void clickLogoutButton() {
        authenticationService.logout();
    }

    @Then("^Logout page is opened and breadcrumble has Logout text$")
    public void logoutPageIsOpenedAndBreadcrumbleHasLogoutText() {
        String actualBreadcrumbLogoutText = authenticationService.getBreadcrumbLogoutText();
        Assert.assertEquals(actualBreadcrumbLogoutText, "Logout",
                "Incorrect breadcrumbls logout text");
    }

    @When("^login with invalid credentials (.*)$")
    public void loginWithInvalidCredentialsUser(String invalidUser) {
        Map<String, User> invalidUsers = new HashMap<>();
        invalidUsers.put("userWithInvalidPassword", UserFactory.generateUserWithRegisteredCredentialsWithInvalidPassword());
        invalidUsers.put("userWithInvalidEmail", UserFactory.generateUserWithRegisteredCredentialsWithInvalidEmail());
        User userWithInvalidCredentials = invalidUsers.get(invalidUser);
        Credentials invalidCredentials = userWithInvalidCredentials.getCredentials();
        String email = invalidCredentials.getEmail();
        String password = invalidCredentials.getPassword();
        try {
            authenticationService.login(email, password);
        } catch (AuthenticationException e) {
            Log.info(e.getMessage());
        }
    }

    @Then("Error message with text {string} is appeared")
    public void errorMessageWithTextIsAppeared(String expectedErrorMessageText) {
        String actualErrorTextMessage = authenticationService.getErrorMessageTet();
        Assert.assertEquals(actualErrorTextMessage, expectedErrorMessageText,
                "Incorrect error message text");
    }
}
