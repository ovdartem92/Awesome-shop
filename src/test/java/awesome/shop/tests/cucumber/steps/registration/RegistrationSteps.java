package awesome.shop.tests.cucumber.steps.registration;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.awesome.shop.ta.framework.configuration.PropertyManager;
import ru.awesome.shop.ta.framework.exceptions.RegistrationException;
import ru.awesome.shop.ta.product.bo.address.Address;
import ru.awesome.shop.ta.product.bo.address.Region;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfo;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;
import ru.awesome.shop.ta.product.pages.SuccessfulAccountRegistrationPage;
import ru.awesome.shop.ta.product.services.AccountRegistrationService;
import ru.awesome.shop.ta.product.services.NavigationService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RegistrationSteps {
    private final String REGISTERED_EMAIL = "alexandr_ladygin@mail.ru";
    private final String REGISTERED_PASSWORD = "qwerty12345";
    private final AccountRegistrationService accountRegistrationService = new AccountRegistrationService();
    private final AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage();
    private final SuccessfulAccountRegistrationPage successfulRegistrationPage = new SuccessfulAccountRegistrationPage();
    private final NavigationService navigationService = new NavigationService();
    private TestContext testContext;
    private User user;

    public RegistrationSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("^I have opened the registration page$")
    public void openRegistrationPage() {
        navigationService.navigateToAccountRegistrationPage();
    }

    @When("^I register with data:$")
    public void registerWithData(DataTable dataTable) {
        List<Map<String, String>> signUpForm = dataTable.asMaps(String.class, String.class);
        User validUser = UserFactory.generateValidUser();
        Credentials validCredentials = validUser.getCredentials();
        ContactInfo validContactInfo = validUser.getContactInfo();
        Address validAddress = validContactInfo.getAddress();
        Region region = validAddress.getRegion();

        for (Map<String, String> form : signUpForm) {
            String email;
            String password;
            String firstName = Objects.requireNonNullElse(form.get("First Name"), validUser.getFirstName());
            String lastName = Objects.requireNonNullElse(form.get("Last Name"), validUser.getLastName());
            String telephone = Objects.requireNonNullElse(form.get("Telephone"), validContactInfo.getTelephoneNumber());
            String fax = Objects.requireNonNullElse(form.get("Fax"), validContactInfo.getFaxNumber());
            String company = Objects.requireNonNullElse(form.get("Company"), validUser.getCompanyName());
            String firstAddress = Objects.requireNonNullElse(form.get("First Address"), validAddress.getFirstAddress());
            String secondAddress = Objects.requireNonNullElse(form.get("Second Address"), validAddress.getSecondAddress());
            String city = Objects.requireNonNullElse(form.get("City"), validAddress.getCity());
            String postCode = Objects.requireNonNullElse(form.get("Postcode"), validAddress.getPostCode());

            if (REGISTERED_EMAIL.equals(form.get("Email")) || REGISTERED_PASSWORD.equals(form.get("Password"))) {
                email = PropertyManager.getEmail();
                password = PropertyManager.getPassword();
            } else {
                email = Objects.requireNonNullElse(form.get("Email"), validCredentials.getEmail());
                password = Objects.requireNonNullElse(form.get("Password"), validCredentials.getPassword());
            }
            Credentials credentials = new Credentials(email, password);
            Address address = new Address(firstAddress, secondAddress, city, postCode, region);
            ContactInfo contactInfo = new ContactInfo(telephone, fax, address);
            user = new User.Builder(credentials).firstName(firstName).lastName(lastName)
                    .companyName(company).contactInfo(contactInfo).build();
        }

        try {
            accountRegistrationService.register(user);
        } catch (RegistrationException ex) {
            String errorMessage = ex.getMessage();
            String[] split = errorMessage.split(":");
            testContext.setErrorMessage(split[0]);
        }
    }

    @When("^I register with empty data$")
    public void registerWithEmptyData() {
        String email = "";
        String password = "";
        Credentials credentials = new Credentials(email, password);
        user = new User.Builder(credentials).build();
        try {
            accountRegistrationService.register(user);
        } catch (RegistrationException ex) {
            String errorMessage = ex.getMessage();
            String[] split = errorMessage.split(":");
            testContext.setErrorMessage(split[0]);
        }
    }

    @When("^I am registering as a user with the consent to the license agreement is \"(.*)\"$")
    public void registerWithValidData(String isAgreeWithLicense) {
        boolean isSubscribed = false;
        boolean isAgree = isAgreeWithLicense.equals("true");
        user = UserFactory.generateValidUser();
        try {
            accountRegistrationService.register(user, isSubscribed, isAgree);
        } catch (RegistrationException ex) {
            String errorMessage = ex.getMessage();
            String[] split = errorMessage.split(":");
            testContext.setErrorMessage(split[2].trim());
        }
    }

    @When("^I click privacy policy link$")
    public void clickPrivacyPolicyLink() {
        accountRegistrationPage.clickPrivacyPolicyLink();
    }

    @Then("^I should see registration error message \"(.*)\"$")
    public void checkRegistrationErrorMessage(String expectedErrorMessage) {
        String errorMessage = testContext.getErrorMessage();
        Assert.assertEquals(errorMessage, expectedErrorMessage,
                "The expected error message does not match the actual one");
    }

    @Then("^I should see \"(.*)\" pop up window$")
    public void checkPopUpWindowTitle(String expectedTitle) {
        Assert.assertEquals( "Privacy Policy", expectedTitle, "Incorrect pop up window title");
    }

    @Then("^I should see home page$")
    public void checkPageTitle() {
        Assert.assertEquals(successfulRegistrationPage.getPageTitle(), "Your Account Has Been Created!",
                "Incorrect page title");
    }
}
