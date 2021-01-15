package awesome.shop.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.configuration.PropertyManager;
import ru.awesome.shop.ta.framework.exceptions.RegistrationException;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfo;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.product.bo.credentials.CredentialsFactory;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;
import ru.awesome.shop.ta.product.services.AccountRegistrationService;

public class RegistrationTest extends BaseConfigurationTest {
    private final AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage();
    private final AccountRegistrationService accountRegistrationService = new AccountRegistrationService();

    @DataProvider(name = "userWithInvalidProperty")
    public Object[][] getUserWithInvalidProperty() {
        return new Object[][] {
                { UserFactory.generateUserWithInvalidFirstName(),
                        "First Name shouldn't contains space character, special symbols, numerals" },
                { UserFactory.generateUserWithInvalidLastName(),
                        "Last Name shouldn't contains space character, special symbols, numerals." },
                { UserFactory.generateUserWithInvalidCity(),
                        "City shouldn't contains special symbols and numerals!" },
                { UserFactory.generateUserWithInvalidTelephone(),
                        "Telephone shouldn't contains space character, special symbols, numerals." },
        };
    }

    @BeforeMethod(description = "open registration page",
            groups = {"all", "negative", "positive"})
    public void openRegistrationPage() {
        accountRegistrationPage.open();
    }

    @Test(description = "***RegistrationTestWithEmptyProperties***\n" +
            "EPMFARMATS-13156: Check appearance First Name length warning\n" +
            "EPMFARMATS-13157: Check appearance Last Name length warning\n" +
            "EPMFARMATS-13158: Check appearance E-mail invalid warning\n" +
            "EPMFARMATS-13159: Check appearance Telephone length warning\n" +
            "EPMFARMATS-13160: Check appearance Address 1 length warning\n" +
            "EPMFARMATS-13161: Check appearance City length warning\n" +
            "EPMFARMATS-13163: Check appearance Postcode length warning\n" +
            "EPMFARMATS-13164: Check appearance Password length warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13156\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13157\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13158\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13159\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13160\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13161\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13163\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13164\n",
            expectedExceptions = {RegistrationException.class},
            groups = {"all", "positive"})
    public void checkAppearanceWithEmptyPropertiesWarning() throws RegistrationException {
        Credentials credentials = CredentialsFactory.generateEmptyCredentials();
        User invalidUser = new User.Builder(credentials).build();
        accountRegistrationService.register(invalidUser);
    }

    @Test(description = "***RegistrationTestsWithInvalidProperties***\n" +
            "EPMFARMATS-13181: check appearance First Name invalid warning\n" +
            "EPMFARMATS-13182: check appearance Last Name invalid warning\n" +
            "EPMFARMATS-13183: check appearance Telephone invalid warning\n" +
            "EPMFARMATS-13184: check appearance City invalid warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13181\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13182\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13183\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13184\n",
            dataProvider = "userWithInvalidProperty",
            expectedExceptions = {RegistrationException.class},
            groups = {"all", "negative"})
    public void checkAppearanceWithInvalidPropertyWarning(User invalidUser, String message) throws RegistrationException {
        accountRegistrationService.register(invalidUser);
    }

    @Test(description = "***CheckSuccessfulUserRegistration***\n" +
            "EPMFARMATS-13155: check successful user registration\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13155\n",
            groups = {"all", "positive"})
    public void checkSuccessfulUserRegistration() throws RegistrationException {
        User validUser = UserFactory.generateValidUser();
        accountRegistrationService.register(validUser);
    }

    @Test(description = "***CheckAppearanceEmailAlreadyRegisteredWarning***\n" +
            "EPMFARMATS-13166: check appearance E-mail already registered warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13166\n",
            expectedExceptions = {RegistrationException.class},
            groups = {"all", "positive"})
    public void checkAppearanceEmailAlreadyRegisteredWarning() throws RegistrationException {
        User validUser = UserFactory.generateValidUser();
        String validFirstName = validUser.getFirstName();
        String validLastName = validUser.getLastName();
        String validCompanyName = validUser.getCompanyName();
        ContactInfo validContactInfo = validUser.getContactInfo();
        String registeredEmail = PropertyManager.getEmail();
        String registeredPassword= PropertyManager.getPassword();
        Credentials registeredCredentials = new Credentials(registeredEmail, registeredPassword);
        User registeredUser = new User.Builder(registeredCredentials).firstName(validFirstName)
                .lastName(validLastName).companyName(validCompanyName).contactInfo(validContactInfo).build();

        accountRegistrationService.register(registeredUser);
        Assert.assertEquals(accountRegistrationPage.getDangerMessage(), "Warning: E-Mail Address is already registered!");
    }

    @Test(description = "***CheckAppearancePrivacyPolicyWarning***\n" +
            "EPMFARMATS-13154: check appearance Privacy Policy warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13154\n",
            expectedExceptions = {RegistrationException.class},
            groups = {"all", "positive"})
    public void checkAppearancePrivacyPolicyWarning() throws RegistrationException {
        User validUser = UserFactory.generateValidUser();
        accountRegistrationService.register(validUser, false, false);
        Assert.assertEquals(accountRegistrationPage.getDangerMessage(), "Warning: You must agree to the Privacy Policy!");
    }

    @Test(description = "***CheckAppearancePrivatePolicyWindow***\n" +
            "EPMFARMATS-13167: check appearance Private Policy window\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13167\n",
            groups = {"all", "positive"})
    public void checkAppearancePrivatePolicyWindow() {
        accountRegistrationPage.clickPrivacyPolicyLink();
        Assert.assertEquals(accountRegistrationPage.getPrivacyPolicyTitle(), "Privacy Policy");
    }
}
