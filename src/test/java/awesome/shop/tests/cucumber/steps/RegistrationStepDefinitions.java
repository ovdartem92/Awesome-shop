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
import ru.awesome.shop.ta.product.services.AccountRegistrationService;
import ru.awesome.shop.ta.product.services.NavigationService;

import static java.lang.String.format;

public class RegistrationStepDefinitions {
    private final AccountRegistrationService accountRegistrationService = new AccountRegistrationService();
    private final NavigationService navigationService = new NavigationService();
    private String errorMessage;
    private User user;

    private User userFactory(String type) {
        User user = null;
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
            default:
                throw new IllegalArgumentException(format("Unexpected user type: %s", type));
        }
        return user;
    }

    @Given("the User with {string} parameters")
    public void theUserWithParameters(String userType) {
        user = userFactory(userType);
    }

    @When("the User tries to register")
    public void theUserTriesToRegister() {
        try {
            accountRegistrationService.register(user);
        } catch (RegistrationException ex) {
            errorMessage = ex.getMessage();
        }
    }

    @Then("the User does not receive registration errors")
    public void theUserDoesNotReceiveRegistrationErrors() {

    }

    @Given("the user open the registration page")
    public void theUserOpenTheRegistrationPage() {
        navigationService.navigateToAccountRegistrationPage();
    }

    @Then("throw a registration error with message {string}")
    public void throwARegistrationErrorWithMessage(String message) {
        Assert.assertTrue(errorMessage.contains(message));
    }

    @When("the user tries to register without clicking on the checkbox of the Privacy Policy")
    public void theUserTriesToRegisterWithoutClickingOnTheCheckboxOfThePrivacyPolicy() {
        boolean isSubscribed = false;
        boolean isPrivacyPolicyChecked = false;
        try {
            accountRegistrationService.register(user, isSubscribed, isPrivacyPolicyChecked);
        } catch (RegistrationException ex) {
            errorMessage = ex.getMessage();
        }
    }
}
