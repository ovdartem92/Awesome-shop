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

    @BeforeMethod(description = "user registration with invalid city value",
            groups = {"all", "negative", "positive"})
    public void openRegistrationPage() {
        registrationPage.open();
    }

    @Test(description = "***CheckAppearanceCityInvalidWarning***\n" +
            "EPMFARMATS-13184: check appearance City invalid warning\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13184",
            dataProvider = "validUser",
            groups = {"all", "positive"})
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
}
