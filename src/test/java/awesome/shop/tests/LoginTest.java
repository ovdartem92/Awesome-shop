package awesome.shop.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;
import ru.awesome.shop.ta.product.pages.AccountPage;
import ru.awesome.shop.ta.product.pages.LoginPage;

import java.lang.reflect.Method;

import static ru.awesome.shop.ta.utils.StringUtils.getRandomString;

public class LoginTest extends BaseConfigurationTest {
    private final LoginPage loginPage = new LoginPage();

    @DataProvider(name = "user")
    public Object[][] getUser(Method method) {
        if (method.getName().equalsIgnoreCase("loginWithInvalidCredentials")) {
            return new Object[][]{{UserFactory.getUserWithInvalidEmailAndValidPassword()},
                    {UserFactory.getUserWithValidEmailAndInvalidPassword()}
            };
        } else {
            return new Object[][]{
                    {UserFactory.getUserWithValidCredentials()},
            };
        }
    }

    @BeforeMethod(description = "open login page",
            groups = {"all", "negative", "positive"})
    public void openLoginPage() {
        loginPage.open();
    }

    @Test(description = "***LoginWithValidCredentials***\n" +
            "EPMFARMATS-13118: check than user can login with correct email and password\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13118",
            dataProvider = "user",
            groups = {"all", "positive"})
    public void loginWithValidCredentialsTest(User user) {
        String myAccountName = loginPage.typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword())
                .clickLoginButton().getMyAccountName();
        Assert.assertEquals(myAccountName, "My Account",
                "User with valid email and password can not login");
    }

    @Test(description = "***Logout***\n" +
            "EPMFARMATS-13119: check that user can logout after successful login\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13119",
            dataProvider = "user",
            groups = {"all", "positive"})
    public void checkThatUserCanLogout(User user) {
        String breadcrumbLogoutText = loginPage.typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword())
                .clickLoginButton()
                .clickMyAccountLink()
                .clickLogoutLink()
                .getBreadcrumbLogoutText();
        Assert.assertEquals(breadcrumbLogoutText, "Logout", "User can not logout");
    }

    @Test(description = "***LoginWithInvalidCredentials***\n" +
            "EPMFARMATS-13121: check that user can not login with invalid email and valid password\n" +
            "EPMFARMATS-13120: check that user can not login with valid email and invalid password\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13121\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13120",
            dataProvider = "user",
            groups = {"all", "negative"})
    public void loginWithInvalidCredentials(User user) {
        String warningMessageText = loginPage.typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickLoginButtonExpectingFailure()
                .getWarningMessage();
        Assert.assertEquals(warningMessageText, "Warning: No match for E-Mail Address and/or Password.",
                "User can login with invalid email and valid password");
    }

    @Test(description = "***LoginAfterChangingPassword***\n" +
            "Check that user can login after changing password",
            dataProvider = "user",
            groups = {"all", "positive"})
    public void loginWithChangedPassword(User user) {
        AccountPage accountPage = new AccountPage();
        String newPassword = getRandomString();
        String accountName = loginPage
                .typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword())
                .clickLoginButton()
                .clickChangePasswordLink()
                .typePassword(newPassword)
                .typeConfirmationPassword(newPassword)
                .clickContinueButton()
                .clickMyAccountLink()
                .clickLogoutLink()
                .clickMyAccountLink()
                .clickLoginLink()
                .typeEmailAddress(user.getEmail())
                .typePassword(newPassword)
                .clickLoginButton()
                .getMyAccountName();
        Assert.assertEquals(accountName, "My Account",
                "User can not login after successfully changing password");
        accountPage.clickChangePasswordLink().typePassword(user.getPassword())
                .typeConfirmationPassword(user.getPassword()).clickContinueButton();
    }
}
