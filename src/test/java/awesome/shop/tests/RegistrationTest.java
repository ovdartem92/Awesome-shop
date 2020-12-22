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
import ru.awesome.shop.ta.utils.TestDataReader;

public class RegistrationTest extends BasePage {
    private AccountRegistrationPage registrationPage = new AccountRegistrationPage();

    private User getRegisteredUser() {
        User user = UserFactory.generateValidUser();
        String email = TestDataReader.getTestData("testData.email", TestDataReader.getStageData("email"));
        String password = TestDataReader.getTestData("testData.password", TestDataReader.getStageData("password"));
        Credentials registeredCredentials = new Credentials(email, password);
        User registeredUser = new User.Builder(registeredCredentials).firstName(user.getFirstName())
                .lastName(user.getLastName()).companyName(user.getCompanyName())
                .contactInfo(user.getContactInfo()).build();
        return registeredUser;
    }

    /* Email has already registered. */
    @DataProvider(name = "userWithRegisteredEmail")
    public Object[][] getUserWithRegisteredEmail() {
        return new Object[][]{{getRegisteredUser()}};
    }

    @DataProvider(name = "validUser")
    public Object[][] getValidUser() {
        return new Object[][]{{UserFactory.generateValidUser()}};
    }

    @DataProvider(name = "invalidUserWithEmptyProperty")
    public Object[][] getInvalidUser() {
        return new Object[][]{
                {UserFactory.generateUserWithEmptyFirstName(), "First Name must be between 1 and 32 characters!"},
                {UserFactory.generateUserWithEmptyLastName(), "Last Name must be between 1 and 32 characters!"},
                {UserFactory.generateUserWithEmptyEmail(), "E-Mail Address does not appear to be valid!"},
                {UserFactory.generateUserWithEmptyTelephone(), "Telephone must be between 3 and 32 characters!"},
                {UserFactory.generateUserWithEmptyFirstAddress(), "Address 1 must be between 3 and 128 characters!"},
                {UserFactory.generateUserWithEmptyCity(), "City must be between 2 and 128 characters!"},
                {UserFactory.generateUserWithEmptyPostCode(), "Postcode must be between 2 and 10 characters!"},
                {UserFactory.generateUserWithEmptyPassword(), "Password must be between 4 and 20 characters!"},
        };
    }

    @DataProvider(name = "userWithInvalidEmail")
    public Object[][] getUserWithInvalidEmail() {
        return new Object[][]{{UserFactory.generateUserWithInvalidEmail()}};
    }

    @DataProvider(name = "userWithInvalidFirstName")
    public Object[][] getUserWithInvalidFirstName() {
        return new Object[][]{{UserFactory.generateUserWithInvalidFirstName()}};
    }

    @DataProvider(name = "userWithInvalidLastName")
    public Object[][] getUserWithInvalidLastName() {
        return new Object[][]{{UserFactory.generateUserWithInvalidLastName()}};
    }

    /* Password confirmation empty. */

    @DataProvider(name = "userWithInvalidTelephone")
    public Object[][] getUserWithInvalidTelephone() {
        return new Object[][]{{UserFactory.generateUserWithInvalidTelephone()}};
    }

    @BeforeMethod(description = "open registration page",
            groups = {"all", "negative", "positive"})
    public void openRegistrationPage() {
        registrationPage.open();
    }

    @Test(description = "***PositiveRegistrationTests***\n" +
            "EPMFARMATS-13156: Check appearance First Name length warning\n" +
            "EPMFARMATS-13157: check appearance Last Name length warning\n" +
            "EPMFARMATS-13158: check appearance E-mail invalid warning\n" +
            "EPMFARMATS-13159: check appearance Telephone length warning\n" +
            "EPMFARMATS-13160: check appearance Address 1 length warning\n" +
            "EPMFARMATS-13161: check appearance City length warning\n" +
            "EPMFARMATS-13163: check appearance Postcode length warning\n" +
            "EPMFARMATS-13164: check appearance Password length warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13156\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13157\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13158\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13159\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13160\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13161\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13163\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13164\n",
            dataProvider = "invalidUserWithEmptyProperty",
            groups = {"all", "positive"})
    public void checkAppearanceWithPropertyLengthWarning(User user, String message) {
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
        registrationPage.selectRandomRegion();
        registrationPage.typePassword(password);
        registrationPage.typePasswordConfirm(password);
        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), message);
    }

    @Test(description = "***CheckAppearanceEmailAlreadyRegisteredWarning***\n" +
            "EPMFARMATS-13166: check appearance E-mail already registered warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13166",
            dataProvider = "userWithRegisteredEmail",
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
        Assert.assertEquals(registrationPage.getDangerMessage(), "Warning: E-Mail Address is already registered!");
    }

    @Test(description = "***CheckAppearancePasswordConfirmationLengthWarning***\n" +
            "EPMFARMATS-13165: check appearance Password Confirmation warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13165",
            dataProvider = "validUser",
            groups = {"all", "positive"})
    public void checkAppearancePasswordConfirmationLengthWarning(User user) {
        String emptyPasswordConfirm = "";
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
        registrationPage.typePasswordConfirm(emptyPasswordConfirm); // clear password
        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
        Assert.assertEquals(registrationPage.getWarningMessage(), "Password confirmation does not match password!");
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

    //    @Test(description = "***CheckAppearanceCityInvalidWarning***\n" +
//            "EPMFARMATS-13184: check appearance City invalid warning\n" +
//            "https://jira.epam.com/jira/browse/EPMFARMATS-13184",
//            dataProvider = "userWithInvalidCity",
//            groups = {"all", "negative"})
//    public void checkAppearanceCityInvalidWarning(User user) {
//        Credentials credentials = user.getCredentials();
//        ContactInfo contactInfo = user.getContactInfo();
//        Address address = user.getContactInfo().getAddress();
//        String firstName = user.getFirstName();
//        String lastName = user.getLastName();
//        String company = user.getCompanyName();
//        String email = credentials.getEmail();
//        String password = credentials.getPassword();
//        String telephoneNumber = contactInfo.getTelephoneNumber();
//        String faxNumber = contactInfo.getFaxNumber();
//        String firstAddress = address.getFirstAddress();
//        String secondAddress = address.getSecondAddress();
//        String country = address.getCountry();
//        String region = address.getRegion();
//        String city = address.getCity();
//        String postCode = address.getPostCode();
//
//        registrationPage.typeFirstName(firstName);
//        registrationPage.typeLastName(lastName);
//        registrationPage.typeEmail(email);
//        registrationPage.typeTelephone(telephoneNumber);
//        registrationPage.typeFax(faxNumber);
//        registrationPage.typeCompany(company);
//        registrationPage.typeFirstAddress(firstAddress);
//        registrationPage.typeSecondAddress(secondAddress);
//        registrationPage.typeCity(city);
//        registrationPage.typePostcode(postCode);
//        registrationPage.selectRegion(region);
//        registrationPage.typePassword(password);
//        registrationPage.typePasswordConfirm(password);
//        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
//        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
//        Assert.assertEquals(registrationPage.getWarningMessage(), "City shouldn't contains special symbols and numerals!");
//    }

    //    @Test(description = "***CheckAppearanceFirstNameInvalidWarning***\n" +
//            "EPMFARMATS-13181: check appearance First Name invalid warning\n" +
//            "https://jira.epam.com/jira/browse/EPMFARMATS-13181",
//            dataProvider = "userWithInvalidFirstName",
//            groups = {"all", "negative"})
//    public void checkAppearanceFirstNameInvalidWarning(User user) {
//        Credentials credentials = user.getCredentials();
//        ContactInfo contactInfo = user.getContactInfo();
//        Address address = user.getContactInfo().getAddress();
//        String firstName = user.getFirstName();
//        String lastName = user.getLastName();
//        String company = user.getCompanyName();
//        String email = credentials.getEmail();
//        String password = credentials.getPassword();
//        String telephoneNumber = contactInfo.getTelephoneNumber();
//        String faxNumber = contactInfo.getFaxNumber();
//        String firstAddress = address.getFirstAddress();
//        String secondAddress = address.getSecondAddress();
//        String country = address.getCountry();
//        String region = address.getRegion();
//        String city = address.getCity();
//        String postCode = address.getPostCode();
//
//        registrationPage.typeFirstName(firstName);
//        registrationPage.typeLastName(lastName);
//        registrationPage.typeEmail(email);
//        registrationPage.typeTelephone(telephoneNumber);
//        registrationPage.typeFax(faxNumber);
//        registrationPage.typeCompany(company);
//        registrationPage.typeFirstAddress(firstAddress);
//        registrationPage.typeSecondAddress(secondAddress);
//        registrationPage.typeCity(city);
//        registrationPage.typePostcode(postCode);
//        registrationPage.selectRegion(region);
//        registrationPage.typePassword(password);
//        registrationPage.typePasswordConfirm(password);
//        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
//        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
//        Assert.assertEquals(registrationPage.getWarningMessage(),
//                "First Name shouldn't contains space character, special symbols, numerals");
//    }

    //    @Test(description = "***CheckAppearanceLastNameInvalidWarning***\n" +
//            "EPMFARMATS-13182: check appearance Last Name invalid warning\n" +
//            "https://jira.epam.com/jira/browse/EPMFARMATS-13182",
//            dataProvider = "userWithInvalidLastName",
//            groups = {"all", "negative"})
//    public void checkAppearanceLastNameInvalidWarning(User user) {
//        Credentials credentials = user.getCredentials();
//        ContactInfo contactInfo = user.getContactInfo();
//        Address address = user.getContactInfo().getAddress();
//        String firstName = user.getFirstName();
//        String lastName = user.getLastName();
//        String company = user.getCompanyName();
//        String email = credentials.getEmail();
//        String password = credentials.getPassword();
//        String telephoneNumber = contactInfo.getTelephoneNumber();
//        String faxNumber = contactInfo.getFaxNumber();
//        String firstAddress = address.getFirstAddress();
//        String secondAddress = address.getSecondAddress();
//        String country = address.getCountry();
//        String region = address.getRegion();
//        String city = address.getCity();
//        String postCode = address.getPostCode();
//
//        registrationPage.typeFirstName(firstName);
//        registrationPage.typeLastName(lastName);
//        registrationPage.typeEmail(email);
//        registrationPage.typeTelephone(telephoneNumber);
//        registrationPage.typeFax(faxNumber);
//        registrationPage.typeCompany(company);
//        registrationPage.typeFirstAddress(firstAddress);
//        registrationPage.typeSecondAddress(secondAddress);
//        registrationPage.typeCity(city);
//        registrationPage.typePostcode(postCode);
//        registrationPage.selectRegion(region);
//        registrationPage.typePassword(password);
//        registrationPage.typePasswordConfirm(password);
//        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
//        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
//        Assert.assertEquals(registrationPage.getWarningMessage(),
//                "Last Name shouldn't contains space character, special symbols, numerals.");
//    }

//    @Test(description = "***CheckAppearanceRegionSelectedWarning***\n" +
//            "EPMFARMATS-13162: check appearance Region / State isn't selected warning\n" +
//            "https://jira.epam.com/jira/browse/EPMFARMATS-13162",
//            dataProvider = "validUser",
//            groups = {"all", "positive"})
//    public void checkAppearanceRegionSelectedWarning(User user) {
//        Credentials credentials = user.getCredentials();
//        ContactInfo contactInfo = user.getContactInfo();
//        Address address = user.getContactInfo().getAddress();
//        String firstName = user.getFirstName();
//        String lastName = user.getLastName();
//        String company = user.getCompanyName();
//        String email = credentials.getEmail();
//        String password = credentials.getPassword();
//        String telephoneNumber = contactInfo.getTelephoneNumber();
//        String faxNumber = contactInfo.getFaxNumber();
//        String firstAddress = address.getFirstAddress();
//        String secondAddress = address.getSecondAddress();
//        String country = address.getCountry();
//        String region = address.getRegion();
//        String city = address.getCity();
//        String postCode = address.getPostCode();
//
//        registrationPage.typeFirstName(firstName);
//        registrationPage.typeLastName(lastName);
//        registrationPage.typeEmail(email);
//        registrationPage.typeTelephone(telephoneNumber);
//        registrationPage.typeFax(faxNumber);
//        registrationPage.typeCompany(company);
//        registrationPage.typeFirstAddress(firstAddress);
//        registrationPage.typeSecondAddress(secondAddress);
//        registrationPage.typeCity(city);
//        registrationPage.typePostcode(postCode);
//        registrationPage.selectRegion(region);
//        registrationPage.typePassword(password);
//        registrationPage.typePasswordConfirm(password);
//        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
//        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
//        Assert.assertEquals(registrationPage.getWarningMessage(), "Please select a region / state!");
//    }

//    @Test(description = "***CheckAppearanceTelephoneInvalidWarning***\n" +
//            "EPMFARMATS-13183: check appearance Telephone invalid warning\n" +
//            "https://jira.epam.com/jira/browse/EPMFARMATS-13183",
//            dataProvider = "userWithInvalidTelephone",
//            groups = {"all", "negative"})
//    public void checkAppearanceTelephoneInvalidWarning(User user) {
//        Credentials credentials = user.getCredentials();
//        ContactInfo contactInfo = user.getContactInfo();
//        Address address = user.getContactInfo().getAddress();
//        String firstName = user.getFirstName();
//        String lastName = user.getLastName();
//        String company = user.getCompanyName();
//        String email = credentials.getEmail();
//        String password = credentials.getPassword();
//        String telephoneNumber = contactInfo.getTelephoneNumber();
//        String faxNumber = contactInfo.getFaxNumber();
//        String firstAddress = address.getFirstAddress();
//        String secondAddress = address.getSecondAddress();
//        String country = address.getCountry();
//        String region = address.getRegion();
//        String city = address.getCity();
//        String postCode = address.getPostCode();
//
//        registrationPage.typeFirstName(firstName);
//        registrationPage.typeLastName(lastName);
//        registrationPage.typeEmail(email);
//        registrationPage.typeTelephone(telephoneNumber);
//        registrationPage.typeFax(faxNumber);
//        registrationPage.typeCompany(company);
//        registrationPage.typeFirstAddress(firstAddress);
//        registrationPage.typeSecondAddress(secondAddress);
//        registrationPage.typeCity(city);
//        registrationPage.typePostcode(postCode);
//        registrationPage.selectRegion(region);
//        registrationPage.typePassword(password);
//        registrationPage.typePasswordConfirm(password);
//        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
//        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
//        Assert.assertEquals(registrationPage.getWarningMessage(),
//                "Last Name shouldn't contains space character, special symbols, numerals.");
//    }

//    @Test(description = "***CheckSuccessfulUserRegistration***\n" +
//            "EPMFARMATS-13155: check successful user registration\n\n" +
//            "https://jira.epam.com/jira/browse/EPMFARMATS-13155",
//            dataProvider = "validUser",
//            groups = {"all", "positive"})
//    public void checkSuccessfulUserRegistration(User user) {
//        Credentials credentials = user.getCredentials();
//        ContactInfo contactInfo = user.getContactInfo();
//        Address address = user.getContactInfo().getAddress();
//        String firstName = user.getFirstName();
//        String lastName = user.getLastName();
//        String company = user.getCompanyName();
//        String email = credentials.getEmail();
//        String password = credentials.getPassword();
//        String telephoneNumber = contactInfo.getTelephoneNumber();
//        String faxNumber = contactInfo.getFaxNumber();
//        String firstAddress = address.getFirstAddress();
//        String secondAddress = address.getSecondAddress();
//        String country = address.getCountry();
//        String region = address.getRegion();
//        String city = address.getCity();
//        String postCode = address.getPostCode();
//
//        registrationPage.typeFirstName(firstName);
//        registrationPage.typeLastName(lastName);
//        registrationPage.typeEmail(email);
//        registrationPage.typeTelephone(telephoneNumber);
//        registrationPage.typeFax(faxNumber);
//        registrationPage.typeCompany(company);
//        registrationPage.typeFirstAddress(firstAddress);
//        registrationPage.typeSecondAddress(secondAddress);
//        registrationPage.typeCity(city);
//        registrationPage.typePostcode(postCode);
//        registrationPage.selectRegion(region);
//        registrationPage.typePassword(password);
//        registrationPage.typePasswordConfirm(password);
//        registrationPage.clickAgreeWithPrivacyPolicyCheckbox();
//        SuccessfulAccountRegistrationPage successfulAccountRegistrationPage = registrationPage.clickContinueButton();
//        Assert.assertEquals(successfulAccountRegistrationPage.getAccountCreationMessage(), "Your Account Has Been Created!");
//    }
}
