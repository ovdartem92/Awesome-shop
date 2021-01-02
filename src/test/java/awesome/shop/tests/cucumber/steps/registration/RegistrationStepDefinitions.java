package awesome.shop.tests.cucumber.steps.registration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.util.Strings;
import ru.awesome.shop.ta.framework.exceptions.RegistrationException;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;
import ru.awesome.shop.ta.product.services.AccountRegistrationService;
import ru.awesome.shop.ta.product.services.NavigationService;

public class RegistrationStepDefinitions {
    private final AccountRegistrationService accountRegistrationService = new AccountRegistrationService();
    private final AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage();
    private final NavigationService navigationService = new NavigationService();
    private String errorMessage;
    private User user;

    @Given("the user open the registration page")
    public void openRegistrationPage() {
        navigationService.navigateToAccountRegistrationPage();
    }

    @Given("the User with {string} parameters")
    public void setUser(String userType) {
        user = UserRegistrationFactory.getUser(userType);
    }

    @When("the User tries to register")
    public void registerUser() {
        try {
            accountRegistrationService.register(user);
        } catch (RegistrationException ex) {
            errorMessage = ex.getMessage();
        }
    }

    @When("the user clicks on a link with user agreement")
    public void clickPrivacyPolicy() {
        accountRegistrationPage.clickPrivacyPolicyLink();
    }

    @When("the user tries to register without clicking on the checkbox of the Privacy Policy")
    public void registerUserWithoutAgreeingPrivacyPolicy() {
        boolean isSubscribed = false;
        boolean isPrivacyPolicyChecked = false;
        try {
            accountRegistrationService.register(user, isSubscribed, isPrivacyPolicyChecked);
        } catch (RegistrationException ex) {
            errorMessage = ex.getMessage();
        }
    }

    @Then("the user should get a window with a title {string}")
    public void assertPrivacyPolicyTitle(String title) {
        String privacyPolicyTitle = accountRegistrationPage.getPrivacyPolicyTitle();
        Assert.assertEquals(privacyPolicyTitle, title);
    }

    @Then("throw a registration error with message {string}")
    public void assertRegistrationErrorMessage(String message) {
        Assert.assertTrue(errorMessage.contains(message));
    }

    @Then("the User does not receive registration errors")
    public void assertRegistrationWithoutErrorMessage() {
        Assert.assertTrue(Strings.isNullOrEmpty(errorMessage));
    }
}
