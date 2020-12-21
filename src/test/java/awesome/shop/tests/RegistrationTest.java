package awesome.shop.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.bo.address.Address;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfo;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;
import ru.awesome.shop.ta.product.pages.AccountRegistrationPage;
import ru.awesome.shop.ta.product.pages.BasePage;
import ru.awesome.shop.ta.product.pages.SuccessfulAccountRegistrationPage;

public class RegistrationTest extends BasePage {
    private AccountRegistrationPage registrationPage = new AccountRegistrationPage();

    @DataProvider(name = "validUser")
    public Object[][] getValidUser() {
        return new Object[][]{{UserFactory.generateValidUser()}};
    }

    @DataProvider(name = "userWithInvalidCity")
    public Object[][] getUserWithInvalidCity() {
        return new Object[][]{{UserFactory.generateUserWithInvalidCity()}};
    }

    @DataProvider(name = "userWithEmptyCity")
    public Object[][] getUserWithEmptyCity() {
        return new Object[][]{{UserFactory.generateUserWithEmptyCity()}};
    }

    /* Email has already registered. */

    @DataProvider(name = "userWithEmptyEmail")
    public Object[][] getUserWithEmptyEmail() {
        return new Object[][]{{UserFactory.generateUserWithEmptyEmail()}};
    }

    @DataProvider(name = "userWithInvalidEmail")
    public Object[][] getUserWithInvalidEmail() {
        return new Object[][]{{UserFactory.generateUserWithInvalidEmail()}};
    }

    @DataProvider(name = "userWithEmptyFirstAddress")
    public Object[][] getUserWithEmptyFirstAddress() {
        return new Object[][]{{UserFactory.generateUserWithEmptyFirstAddress()}};
    }

    @DataProvider(name = "userWithInvalidFirstName")
    public Object[][] getUserWithInvalidFirstName() {
        return new Object[][]{{UserFactory.generateUserWithInvalidFirstName()}};
    }

    @DataProvider(name = "userWithEmptyFirstName")
    public Object[][] getUserWithEmptyFirstName() {
        return new Object[][]{{UserFactory.generateUserWithEmptyFirstName()}};
    }

    @DataProvider(name = "userWithInvalidLastName")
    public Object[][] getUserWithInvalidLastName() {
        return new Object[][]{{UserFactory.generateUserWithInvalidLastName()}};
    }

    @DataProvider(name = "userWithEmptyLastName")
    public Object[][] getUserWithEmptyLastName() {
        return new Object[][]{{UserFactory.generateUserWithEmptyLastName()}};
    }

    /* Password confirmation empty. */

    @DataProvider(name = "userWithEmptyPassword")
    public Object[][] getUserWithEmptyPassword() {
        return new Object[][]{{UserFactory.generateUserWithEmptyPassword()}};
    }

    @DataProvider(name = "userWithEmptyPostCode")
    public Object[][] getUserWithEmptyPostCode() {
        return new Object[][]{{UserFactory.generateUserWithEmptyPostCode()}};
    }

    @DataProvider(name = "userWithInvalidTelephone")
    public Object[][] getUserWithInvalidTelephone() {
        return new Object[][]{{UserFactory.generateUserWithInvalidTelephone()}};
    }

    @DataProvider(name = "userWithEmptyTelephone")
    public Object[][] getUserWithEmptyTelephone() {
        return new Object[][]{{UserFactory.generateUserWithEmptyTelephone()}};
    }

    @BeforeMethod(description = "open registration page",
            groups = {"all", "negative", "positive"})
    public void openRegistrationPage() {
        registrationPage.open();
    }

    @Test(description = "***CheckAppearanceCityInvalidWarning***\n" +
            "EPMFARMATS-13184: check appearance City invalid warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13184",
            dataProvider = "userWithInvalidCity",
            groups = {"all", "negative"})
    public void checkAppearanceCityInvalidWarning(User user) {
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
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), "City shouldn't contains special symbols and numerals!");
    }

    @Test(description = "***CheckAppearanceCityLengthWarning***\n" +
            "EPMFARMATS-13161: check appearance City length warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13161",
            dataProvider = "userWithEmptyCity",
            groups = {"all", "positive"})
    public void checkAppearanceCityLengthWarning(User user) {
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
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), "City must be between 2 and 128 characters!");
    }

    @Test(description = "***CheckAppearanceEmailAlreadyRegisteredWarning***\n" +
            "EPMFARMATS-13166: check appearance E-mail already registered warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13166",
            dataProvider = "validUser",
            groups = {"all", "positive"})
    public void checkAppearanceEmailAlreadyRegisteredWarning(User user) {
        // Change validUser to registered user.
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
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), "Warning: E-Mail Address is already registered!");
    }

    @Test(description = "***CheckAppearanceEmailInvalidWarning***\n" +
            "EPMFARMATS-13158: check appearance E-mail invalid warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13158",
            dataProvider = "userWithInvalidEmail",
            groups = {"all", "negative"})
    public void checkAppearanceEmailInvalidWarning(User user) {
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
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), "E-Mail Address does not appear to be valid!");
    }

    @Test(description = "***CheckAppearanceFirstAddressLengthWarning***\n" +
            "EPMFARMATS-13160: check appearance Address 1 length warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13160",
            dataProvider = "userWithEmptyFirstAddress",
            groups = {"all", "positive"})
    public void checkAppearanceFirstAddressLengthWarning(User user) {
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
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), "Address 1 must be between 3 and 128 characters!");
    }

    @Test(description = "***CheckAppearanceFirstNameInvalidWarning***\n" +
            "EPMFARMATS-13181: check appearance First Name invalid warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13181",
            dataProvider = "userWithInvalidFirstName",
            groups = {"all", "negative"})
    public void checkAppearanceFirstNameInvalidWarning(User user) {
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
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(),
                "First Name shouldn't contains space character, special symbols, numerals");
    }

    @Test(description = "***CheckAppearanceFirstNameLengthWarning***\n" +
            "EPMFARMATS-13156: Check appearance First Name length warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13156",
            dataProvider = "userWithEmptyFirstName",
            groups = {"all", "positive"})
    public void checkAppearanceFirstNameLengthWarning(User user) {
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
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), "First Name must be between 1 and 32 characters!");
    }

    @Test(description = "***CheckAppearanceLastNameInvalidWarning***\n" +
            "EPMFARMATS-13182: check appearance Last Name invalid warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13182",
            dataProvider = "userWithInvalidLastName",
            groups = {"all", "negative"})
    public void checkAppearanceLastNameInvalidWarning(User user) {
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
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(),
                "Last Name shouldn't contains space character, special symbols, numerals.");
    }

    @Test(description = "***CheckAppearanceLastNameLengthWarning***\n" +
            "EPMFARMATS-13157: check appearance Last Name length warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13157",
            dataProvider = "userWithEmptyFirstName",
            groups = {"all", "positive"})
    public void checkAppearanceLastNameLengthWarning(User user) {
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
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), "Last Name must be between 1 and 32 characters!");
    }

    @Test(description = "***CheckAppearancePasswordConfirmationLengthWarning***\n" +
            "EPMFARMATS-13165: check appearance Password Confirmation warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13165",
            dataProvider = "validUser",
            groups = {"all", "positive"})
    public void checkAppearancePasswordConfirmationLengthWarning(User user) {
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
        registrationPage.typePasswordConfirm(""); // clear password
        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), "Password confirmation does not match password!");
    }

    @Test(description = "***CheckAppearancePasswordLengthWarning***\n" +
            "EPMFARMATS-13164: check appearance Password length warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13164",
            dataProvider = "userWithEmptyPassword",
            groups = {"all", "positive"})
    public void checkAppearancePasswordLengthWarning(User user) {
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
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), "Password must be between 4 and 20 characters!");
    }

    @Test(description = "***CheckAppearancePostcodeLengthWarning***\n" +
            "EPMFARMATS-13163: check appearance Postcode length warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13163",
            dataProvider = "userWithEmptyPostCode",
            groups = {"all", "positive"})
    public void checkAppearancePostcodeLengthWarning(User user) {
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
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), "Postcode must be between 2 and 10 characters!");
    }

    @Test(description = "***CheckAppearancePrivacyPolicyWarning***\n" +
            "EPMFARMATS-13154: check appearance Privacy Policy warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13154",
            dataProvider = "validUser",
            groups = {"all", "positive"})
    public void checkAppearancePrivacyPolicyWarning(User user) {
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
//        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getDangerMessage(), "Warning: You must agree to the Privacy Policy!");
    }

    @Test(description = "***CheckAppearancePrivatePolicyWindow***\n" +
            "EPMFARMATS-13167: check appearance Private Policy window\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13167",
            dataProvider = "validUser",
            groups = {"all", "positive"})
    public void checkAppearancePrivatePolicyWindow(User user) {
        registrationPage.clickPrivacyPolicyLink();
        Assert.assertEquals(registrationPage.getPrivacyPolicyTitle(), "Privacy Policy");
    }

    @Test(description = "***CheckAppearanceRegionSelectedWarning***\n" +
            "EPMFARMATS-13162: check appearance Region / State isn't selected warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13162",
            dataProvider = "validUser",
            groups = {"all", "positive"})
    public void checkAppearanceRegionSelectedWarning(User user) {
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
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), "Please select a region / state!");
    }

    @Test(description = "***CheckAppearanceTelephoneInvalidWarning***\n" +
            "EPMFARMATS-13183: check appearance Telephone invalid warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13183",
            dataProvider = "userWithInvalidTelephone",
            groups = {"all", "negative"})
    public void checkAppearanceTelephoneInvalidWarning(User user) {
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
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(),
                "Last Name shouldn't contains space character, special symbols, numerals.");
    }

    @Test(description = "***CheckAppearanceTelephoneLengthWarning***\n" +
            "EPMFARMATS-13159: check appearance Telephone length warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13159",
            dataProvider = "userWithEmptyTelephone",
            groups = {"all", "positive"})
    public void checkAppearanceTelephoneLengthWarning(User user) {
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
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), "Telephone must be between 3 and 32 characters!");
    }

    @Test(description = "***CheckSuccessfulUserRegistration***\n" +
            "EPMFARMATS-13155: check successful user registration\n\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13155",
            dataProvider = "validUser",
            groups = {"all", "positive"})
    public void checkSuccessfulUserRegistration(User user) {
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
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(successfulAccountRegistrationPage.getAccountCreationMessage(), "Your Account Has Been Created!");
    }
}
