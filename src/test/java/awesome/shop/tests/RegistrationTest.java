package awesome.shop.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.configuration.PropertyManager;
import ru.awesome.shop.ta.product.bo.address.Address;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfo;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;
import ru.awesome.shop.ta.product.pages.SuccessfulAccountRegistrationPage;

public class RegistrationTest extends BaseConfigurationTest {
    private AccountRegistrationPage registrationPage = new AccountRegistrationPage();
    private final User validUser = UserFactory.generateValidUser();

    @DataProvider(name = "userWithEmptyProperty")
    public Object[][] getUserWithEmptyProperty() {
        return new Object[][] {
                { UserFactory.generateUserWithEmptyFirstName(), "First Name must be between 1 and 32 characters!" },
                { UserFactory.generateUserWithEmptyLastName(), "Last Name must be between 1 and 32 characters!" },
                { UserFactory.generateUserWithEmptyEmail(), "E-Mail Address does not appear to be valid!" },
                { UserFactory.generateUserWithEmptyTelephone(), "Telephone must be between 3 and 32 characters!" },
                { UserFactory.generateUserWithEmptyFirstAddress(), "Address 1 must be between 3 and 128 characters!" },
                { UserFactory.generateUserWithEmptyCity(), "City must be between 2 and 128 characters!" },
                { UserFactory.generateUserWithEmptyRegion(), "Please select a region / state!" },
                { UserFactory.generateUserWithEmptyPostCode(), "Postcode must be between 2 and 10 characters!" },
                { UserFactory.generateUserWithEmptyPassword(), "Password must be between 4 and 20 characters!" },
        };
    }

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
        registrationPage.open();
    }

    @Test(description = "***RegistrationTestsWithEmptyProperties***\n" +
            "EPMFARMATS-13156: Check appearance First Name length warning\n" +
            "EPMFARMATS-13157: check appearance Last Name length warning\n" +
            "EPMFARMATS-13158: check appearance E-mail invalid warning\n" +
            "EPMFARMATS-13159: check appearance Telephone length warning\n" +
            "EPMFARMATS-13160: check appearance Address 1 length warning\n" +
            "EPMFARMATS-13161: check appearance City length warning\n" +
            "EPMFARMATS-13162: check appearance Region / State isn't selected warning\n" +
            "EPMFARMATS-13163: check appearance Postcode length warning\n" +
            "EPMFARMATS-13164: check appearance Password length warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13156\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13157\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13158\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13159\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13160\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13161\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13162\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13163\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13164\n",
            dataProvider = "userWithEmptyProperty",
            groups = {"all", "positive"})
    public void checkAppearanceWithEmptyPropertyWarning(User user, String message) {
        Credentials credentials = user.getCredentials();
        ContactInfo contactInfo = user.getContactInfo();
        Address address = user.getContactInfo().getAddress();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String company = user.getCompanyName();
        String email = credentials.getEmail();
        String password = credentials.getPassword();
        String telephoneNumber = contactInfo.getTelephoneNumber();
        String faxNumber = contactInfo.getFaxNumber();
        String firstAddress = address.getFirstAddress();
        String secondAddress = address.getSecondAddress();
        String country = address.getCountry();
        String region = address.getRegion();
        String city = address.getCity();
        String postCode = address.getPostCode();

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(email);
        registrationPage.typeTelephone(telephoneNumber);
        registrationPage.typeFax(faxNumber);
        registrationPage.typeCompany(company);
        registrationPage.typeFirstAddress(firstAddress);
        registrationPage.typeSecondAddress(secondAddress);
        registrationPage.typeCity(city);
        registrationPage.typePostcode(postCode);
        registrationPage.selectRegion(region);
        registrationPage.typePassword(password);
        registrationPage.typePasswordConfirm(password);
        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
        registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), message);
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
            groups = {"all", "negative"})
    public void checkAppearanceWithInvalidPropertyWarning(User user, String message) {
        Credentials credentials = user.getCredentials();
        ContactInfo contactInfo = user.getContactInfo();
        Address address = user.getContactInfo().getAddress();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String company = user.getCompanyName();
        String email = credentials.getEmail();
        String password = credentials.getPassword();
        String telephoneNumber = contactInfo.getTelephoneNumber();
        String faxNumber = contactInfo.getFaxNumber();
        String firstAddress = address.getFirstAddress();
        String secondAddress = address.getSecondAddress();
        String country = address.getCountry();
        String region = address.getRegion();
        String city = address.getCity();
        String postCode = address.getPostCode();

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(email);
        registrationPage.typeTelephone(telephoneNumber);
        registrationPage.typeFax(faxNumber);
        registrationPage.typeCompany(company);
        registrationPage.typeFirstAddress(firstAddress);
        registrationPage.typeSecondAddress(secondAddress);
        registrationPage.typeCity(city);
        registrationPage.typePostcode(postCode);
        registrationPage.selectRegion(region);
        registrationPage.typePassword(password);
        registrationPage.typePasswordConfirm(password);
        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
        registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), message);
    }

    @Test(description = "***CheckSuccessfulUserRegistration***\n" +
            "EPMFARMATS-13155: check successful user registration\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13155\n",
            groups = {"all", "positive"})
    public void checkSuccessfulUserRegistration() {
        Credentials credentials = validUser.getCredentials();
        ContactInfo contactInfo = validUser.getContactInfo();
        Address address = validUser.getContactInfo().getAddress();
        String firstName = validUser.getFirstName();
        String lastName = validUser.getLastName();
        String company = validUser.getCompanyName();
        String email = credentials.getEmail();
        String password = credentials.getPassword();
        String telephoneNumber = contactInfo.getTelephoneNumber();
        String faxNumber = contactInfo.getFaxNumber();
        String firstAddress = address.getFirstAddress();
        String secondAddress = address.getSecondAddress();
        String country = address.getCountry();
        String region = address.getRegion();
        String city = address.getCity();
        String postCode = address.getPostCode();

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(email);
        registrationPage.typeTelephone(telephoneNumber);
        registrationPage.typeFax(faxNumber);
        registrationPage.typeCompany(company);
        registrationPage.typeFirstAddress(firstAddress);
        registrationPage.typeSecondAddress(secondAddress);
        registrationPage.typeCity(city);
        registrationPage.typePostcode(postCode);
        registrationPage.selectRegion(region);
        registrationPage.typePassword(password);
        registrationPage.typePasswordConfirm(password);
        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(successfulAccountRegistrationPage.getAccountCreationMessage(), "Your Account Has Been Created!");
    }

    @Test(description = "***CheckAppearanceEmailAlreadyRegisteredWarning***\n" +
            "EPMFARMATS-13166: check appearance E-mail already registered warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13166\n",
            groups = {"all", "positive"})
    public void checkAppearanceEmailAlreadyRegisteredWarning() {
        String registeredEmail = PropertyManager.getEmail();
        String registeredPassword= PropertyManager.getPassword();
        Credentials registeredCredentials = new Credentials(registeredEmail, registeredPassword);
        User registeredUser = new User.Builder(registeredCredentials).firstName(validUser.getFirstName())
                .lastName(validUser.getLastName()).companyName(validUser.getCompanyName())
                .contactInfo(validUser.getContactInfo()).build();

        Credentials credentials = registeredUser.getCredentials();
        ContactInfo contactInfo = registeredUser.getContactInfo();
        Address address = registeredUser.getContactInfo().getAddress();
        String firstName = registeredUser.getFirstName();
        String lastName = registeredUser.getLastName();
        String company = registeredUser.getCompanyName();
        String email = credentials.getEmail();
        String password = credentials.getPassword();
        String telephoneNumber = contactInfo.getTelephoneNumber();
        String faxNumber = contactInfo.getFaxNumber();
        String firstAddress = address.getFirstAddress();
        String secondAddress = address.getSecondAddress();
        String country = address.getCountry();
        String region = address.getRegion();
        String city = address.getCity();
        String postCode = address.getPostCode();

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(email);
        registrationPage.typeTelephone(telephoneNumber);
        registrationPage.typeFax(faxNumber);
        registrationPage.typeCompany(company);
        registrationPage.typeFirstAddress(firstAddress);
        registrationPage.typeSecondAddress(secondAddress);
        registrationPage.typeCity(city);
        registrationPage.typePostcode(postCode);
        registrationPage.selectRegion(region);
        registrationPage.typePassword(password);
        registrationPage.typePasswordConfirm(password);
        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
        registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getDangerMessage(), "Warning: E-Mail Address is already registered!");
    }

    @Test(description = "***CheckAppearancePasswordConfirmationLengthWarning***\n" +
            "EPMFARMATS-13165: check appearance Password Confirmation warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13165\n",
            groups = {"all", "positive"})
    public void checkAppearancePasswordConfirmationLengthWarning() {
        String emptyPasswordConfirm = "";
        Credentials credentials = validUser.getCredentials();
        ContactInfo contactInfo = validUser.getContactInfo();
        Address address = validUser.getContactInfo().getAddress();
        String firstName = validUser.getFirstName();
        String lastName = validUser.getLastName();
        String company = validUser.getCompanyName();
        String email = credentials.getEmail();
        String password = credentials.getPassword();
        String telephoneNumber = contactInfo.getTelephoneNumber();
        String faxNumber = contactInfo.getFaxNumber();
        String firstAddress = address.getFirstAddress();
        String secondAddress = address.getSecondAddress();
        String country = address.getCountry();
        String region = address.getRegion();
        String city = address.getCity();
        String postCode = address.getPostCode();

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(email);
        registrationPage.typeTelephone(telephoneNumber);
        registrationPage.typeFax(faxNumber);
        registrationPage.typeCompany(company);
        registrationPage.typeFirstAddress(firstAddress);
        registrationPage.typeSecondAddress(secondAddress);
        registrationPage.typeCity(city);
        registrationPage.typePostcode(postCode);
        registrationPage.selectRegion(region);
        registrationPage.typePassword(password);
        registrationPage.typePasswordConfirm(emptyPasswordConfirm); // empty password
        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
        registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), "Password confirmation does not match password!");
    }


    @Test(description = "***CheckAppearancePrivacyPolicyWarning***\n" +
            "EPMFARMATS-13154: check appearance Privacy Policy warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13154\n",
            groups = {"all", "positive"})
    public void checkAppearancePrivacyPolicyWarning(User user) {
        Credentials credentials = validUser.getCredentials();
        ContactInfo contactInfo = validUser.getContactInfo();
        Address address = validUser.getContactInfo().getAddress();
        String firstName = validUser.getFirstName();
        String lastName = validUser.getLastName();
        String company = validUser.getCompanyName();
        String email = credentials.getEmail();
        String password = credentials.getPassword();
        String telephoneNumber = contactInfo.getTelephoneNumber();
        String faxNumber = contactInfo.getFaxNumber();
        String firstAddress = address.getFirstAddress();
        String secondAddress = address.getSecondAddress();
        String country = address.getCountry();
        String region = address.getRegion();
        String city = address.getCity();
        String postCode = address.getPostCode();

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(email);
        registrationPage.typeTelephone(telephoneNumber);
        registrationPage.typeFax(faxNumber);
        registrationPage.typeCompany(company);
        registrationPage.typeFirstAddress(firstAddress);
        registrationPage.typeSecondAddress(secondAddress);
        registrationPage.typeCity(city);
        registrationPage.typePostcode(postCode);
        registrationPage.selectRegion(region);
        registrationPage.typePassword(password);
        registrationPage.typePasswordConfirm(password);
//        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
        registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getDangerMessage(), "Warning: You must agree to the Privacy Policy!");
    }

    @Test(description = "***CheckAppearancePrivatePolicyWindow***\n" +
            "EPMFARMATS-13167: check appearance Private Policy window\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13167\n",
            groups = {"all", "positive"})
    public void checkAppearancePrivatePolicyWindow() {
        registrationPage.clickPrivacyPolicyLink();
        Assert.assertEquals(registrationPage.getPrivacyPolicyTitle(), "Privacy Policy");
    }
}
