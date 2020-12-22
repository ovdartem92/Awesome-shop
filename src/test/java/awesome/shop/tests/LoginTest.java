package awesome.shop.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.configuration.PropertyManager;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;
import ru.awesome.shop.ta.product.pages.AccountPage;
import ru.awesome.shop.ta.product.pages.LoginPage;
import ru.awesome.shop.ta.product.pages.LogoutPage;
import ru.awesome.shop.ta.product.pages.popups.AccountPopUp;

public class LoginTest extends BaseConfigurationTest {
    private static final LoginPage loginPage = new LoginPage();
    private static final String REGISTER_EMAIL = PropertyManager.getEmail();
    private static final String REGISTER_PASSWORD = PropertyManager.getPassword();

    @DataProvider(name = "invalidUser")
    public Object[][] getInvalidUser() {
        return new Object[][]{{UserFactory.generateUserWithRegisteredCredentialsWithInvalidEmail()},
                {UserFactory.generateUserWithRegisteredCredentialsWithInvalidPassword()}
        };
    }

    @BeforeMethod(description = "open login page",
            groups = {"all", "negative", "positive"})
    public void openLoginPage() {
        loginPage.open();
    }

    @Test(description = "***LoginWithValidCredentials***\n" +
            "EPMFARMATS-13118: check than user can login with correct email and password\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13118",
            groups = {"all", "positive"})
    public void loginWithValidCredentialsTest() {
        loginPage.typeEmailAddress(REGISTER_EMAIL);
        loginPage.typePassword(REGISTER_PASSWORD);
        AccountPage accountPage = loginPage.clickLoginButton();
        String actualAccountName = accountPage.getMyAccountName();
        Assert.assertEquals(actualAccountName, "My Account",
                "Incorrect account name");
    }

    @Test(description = "***Logout***\n" +
            "EPMFARMATS-13119: check that user can logout after successful login\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13119",
            groups = {"all", "positive"})
    public void checkThatUserCanLogout() {
        loginPage.typeEmailAddress(REGISTER_EMAIL);
        loginPage.typePassword(REGISTER_PASSWORD);
        AccountPage accountPage = loginPage.clickLoginButton();
        AccountPopUp accountPopUp = accountPage.clickMyAccountLink();
        LogoutPage logoutPage = accountPopUp.clickLogoutLink();
        String actualBreadcrumbLogoutText = logoutPage.getBreadcrumbLogoutText();
        Assert.assertEquals(actualBreadcrumbLogoutText, "Logout",
                "Incorrect breadcrumbls logout text");
    }

    @Test(description = "***LoginWithInvalidCredentials***\n" +
            "EPMFARMATS-13121: check that user can not login with invalid email and valid password\n" +
            "EPMFARMATS-13120: check that user can not login with valid email and invalid password\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13121\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13120",
            dataProvider = "invalidUser",
            groups = {"all", "negative"})
    public void loginWithInvalidCredentials(User user) {
        Credentials userCredentials = user.getCredentials();
        String userEmail = userCredentials.getEmail();
        String userPassword = userCredentials.getPassword();
        loginPage.typeEmailAddress(userEmail);
        loginPage.typePassword(userPassword);
        loginPage.clickLoginButton();
        String warningMessageText = loginPage.getWarningMessage();
        Assert.assertEquals(warningMessageText, "Warning: No match for E-Mail Address and/or Password.",
                "Incorrect warning message text");
    }
}
