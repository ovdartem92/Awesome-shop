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

    @Given("^user open the registration page$")
    public void openRegistrationPage() {
        navigationService.navigateToAccountRegistrationPage();
    }

    @Given("^user with \"([^\"]*)\" parameters$")
    public void setUser(String userType) {
        user = UserRegistrationFactory.getUser(userType);
    }

    @When("^user tries to register$")
    public void registerUser() {
        try {
            accountRegistrationService.register(user);
        } catch (RegistrationException ex) {
            errorMessage = ex.getMessage();
        }
    }

    @When("^user clicks on a link with user agreement$")
    public void clickPrivacyPolicy() {
        accountRegistrationPage.clickPrivacyPolicyLink();
    }

    @When("^user tries to register without clicking on the checkbox of the Privacy Policy$")
    public void registerUserWithoutAgreeingPrivacyPolicy() {
        boolean isSubscribed = false;
        boolean isPrivacyPolicyChecked = false;
        try {
            accountRegistrationService.register(user, isSubscribed, isPrivacyPolicyChecked);
        } catch (RegistrationException ex) {
            errorMessage = ex.getMessage();
        }
    }

    @Then("^should get a window with a title \"([^\"]*)\"$")
    public void assertPrivacyPolicyTitle(String title) {
        String privacyPolicyTitle = accountRegistrationPage.getPrivacyPolicyTitle();
        Assert.assertEquals(privacyPolicyTitle, title);
    }

    @Then("^registration error should be thrown with message \"([^\"]*)\"$")
    public void assertRegistrationErrorMessage(String message) {
        Assert.assertTrue(errorMessage.contains(message));
    }

    @Then("^registration should be successful$")
    public void assertRegistrationWithoutErrorMessage() {
        Assert.assertTrue(Strings.isNullOrEmpty(errorMessage));
    }
}
