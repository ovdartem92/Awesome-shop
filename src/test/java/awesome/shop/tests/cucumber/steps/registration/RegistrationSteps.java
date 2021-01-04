package awesome.shop.tests.cucumber.steps.registration;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.util.Strings;
import ru.awesome.shop.ta.framework.exceptions.RegistrationException;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;
import ru.awesome.shop.ta.product.services.AccountRegistrationService;
import ru.awesome.shop.ta.product.services.NavigationService;

import java.util.List;
import java.util.Objects;

public class RegistrationSteps {
    private final AccountRegistrationService accountRegistrationService = new AccountRegistrationService();
    private final AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage();
    private final NavigationService navigationService = new NavigationService();
    private TextContext textContext;
    private User user;

    public RegistrationSteps(TextContext textContext) {
        this.textContext = textContext;
    }

    @Given("^I have opened the registration page$")
    public void iHaveOpenedTheRegistrationPage() {
        navigationService.navigateToAccountRegistrationPage();
    }

    @When("I register with data:")
    public void i_register_with_data(DataTable dataTable) {
//        List<Map<String, String>> signUpForm = dataTable.asMaps(String.class, String.class);
//        String email = Objects.requireNonNullElse(signUpForm.get(0).get("email"), "");
//        String password = Objects.requireNonNullElse(signUpForm.get(0).get("password"), "");
        List<String> emailRows = dataTable.row(0);
        List<String> passwordRows = dataTable.row(1);
        String email = Objects.requireNonNullElse(emailRows.get(1), "");
        String password = Objects.requireNonNullElse(passwordRows.get(1), "");
        Credentials credentials = new Credentials(email, password);
        user = UserFactory.generateUserWithCustomCredentials(credentials);
        try {
            accountRegistrationService.register(user);
        } catch (RegistrationException ex) {
            String errorMessage = ex.getMessage();
            textContext.setErrorMessage(errorMessage);
            System.out.println("ERROR: " + errorMessage);
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
            String errorMessage = ex.getMessage();
            textContext.setErrorMessage(errorMessage);
        }
    }

    @Then("^should get a window with a title \"([^\"]*)\"$")
    public void assertPrivacyPolicyTitle(String title) {
        String privacyPolicyTitle = accountRegistrationPage.getPrivacyPolicyTitle();
        Assert.assertEquals(privacyPolicyTitle, title);
    }

    @Then("^I should see registration error message \"([^\"]*)\"$")
    public void iShouldSeeRegistrationErrorMessage(String message) {
        String errorMessage = textContext.getErrorMessage();
        Assert.assertTrue(errorMessage.contains(message));
    }

    @Then("^registration should be successful$")
    public void assertRegistrationWithoutErrorMessage() {
        String errorMessage = textContext.getErrorMessage();
        Assert.assertTrue(Strings.isNullOrEmpty(errorMessage));
    }

    @When("^I click privacy policy link$")
    public void iClickPrivacyPolicyLink() {
        accountRegistrationPage.clickPrivacyPolicyLink();
    }

    @Then("^I should see \"([^\"]*)\" pop up window$")
    public void iShouldSeePopUpWindow(String title) {
        Assert.assertEquals(title, "Privacy Policy", "Incorrect window title");
    }


}
