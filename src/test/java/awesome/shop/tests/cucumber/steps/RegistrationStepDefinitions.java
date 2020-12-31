package awesome.shop.tests.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.awesome.shop.ta.framework.configuration.PropertyManager;
import ru.awesome.shop.ta.framework.exceptions.RegistrationException;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfo;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.product.bo.credentials.CredentialsFactory;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;
import ru.awesome.shop.ta.product.services.AccountRegistrationService;
import ru.awesome.shop.ta.product.services.NavigationService;

import static java.lang.String.format;

public class RegistrationStepDefinitions {
    private final AccountRegistrationService accountRegistrationService = new AccountRegistrationService();
    private final AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage();
    private final NavigationService navigationService = new NavigationService();
    private String errorMessage;
    private User user;

    private User userFactory(String type) {
        User user;
        switch (type) {
            case "validUser":
                user = UserFactory.generateValidUser();
                break;
            case "emptyUser":
                Credentials credentials = CredentialsFactory.generateEmptyCredentials();
                user = new User.Builder(credentials).build();
                break;
            case "registeredUser":
                User validUser = UserFactory.generateValidUser();
                String validFirstName = validUser.getFirstName();
                String validLastName = validUser.getLastName();
                String validCompanyName = validUser.getCompanyName();
                ContactInfo validContactInfo = validUser.getContactInfo();
                String registeredEmail = PropertyManager.getEmail();
                String registeredPassword= PropertyManager.getPassword();
                Credentials registeredCredentials = new Credentials(registeredEmail, registeredPassword);
                user = new User.Builder(registeredCredentials).firstName(validFirstName)
                        .lastName(validLastName).companyName(validCompanyName).contactInfo(validContactInfo).build();
                break;
            case "userWithInvalidFirstName":
                user = UserFactory.generateUserWithInvalidFirstName();
                break;
            case "userWithInvalidLastName":
                user = UserFactory.generateUserWithInvalidLastName();
                break;
            case "userWithInvalidCity":
                user = UserFactory.generateUserWithInvalidCity();
                break;
            case "userWithInvalidTelephone":
                user = UserFactory.generateUserWithInvalidTelephone();
                break;
            default:
                throw new IllegalArgumentException(format("Unexpected user type: %s", type));
        }
        return user;
    }

    @Given("the user open the registration page")
    public void openRegistrationPage() {
        navigationService.navigateToAccountRegistrationPage();
    }

    @Given("the User with {string} parameters")
    public void setUser(String userType) {
        user = userFactory(userType);
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
    public void registerUserWithoutCheckPrivacyPolicy() {
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

    @Then("throw a registration error with information about invalid fields")
    public void assertRegistrationErrorWithInvalidMessage() {
        Assert.assertTrue(errorMessage.contains("Registration failed"));
    }
}
