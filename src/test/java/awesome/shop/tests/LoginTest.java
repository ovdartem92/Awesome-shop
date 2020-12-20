package awesome.shop.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;
import ru.awesome.shop.ta.product.pages.AccountPage;
import ru.awesome.shop.ta.product.pages.LoginPage;
import ru.awesome.shop.ta.product.pages.LogoutPage;
import ru.awesome.shop.ta.service.LoginService;

import java.lang.reflect.Method;

import static ru.awesome.shop.ta.utils.StringUtils.getRandomString;

public class LoginTest extends BaseConfigurationTest {
    private final LoginPage loginPage = new LoginPage();
    private final LoginService loginService = new LoginService();

    @DataProvider(name = "user")
    public Object[][] getUser(Method method) {
        if (method.getName().equalsIgnoreCase("loginWithInvalidCredentials")) {
            return new Object[][]{{UserFactory.generateUserWithValidEmailInvalidPassword()},
                    {UserFactory.generateUserWithInvalidEmailValidPassword()}
            };
        } else {
            return new Object[][]{
                    {UserFactory.generateValidUser()},
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
        loginService.login(user.getCredentials().getEmail(), user.getCredentials().getPassword());
        String myAccountName = new AccountPage().getMyAccountName();
        Assert.assertEquals(myAccountName, "My Account",
                "User with valid email and password can not login");
    }

    @Test(description = "***Logout***\n" +
            "EPMFARMATS-13119: check that user can logout after successful login\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13119",
            dataProvider = "user",
            groups = {"all", "positive"})
    public void checkThatUserCanLogout(User user) {
        loginService.login(user.getCredentials().getEmail(), user.getCredentials().getPassword());
        loginService.logout();
        String breadcrumbLogoutText = new LogoutPage().getBreadcrumbLogoutText();
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
        loginService.login(user.getCredentials().getEmail(), user.getCredentials().getPassword());
        String warningMessageText = loginPage.getWarningMessage();
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
        loginService.login(user.getCredentials().getEmail(), user.getCredentials().getPassword());
        loginService.changePassword(newPassword);
        loginService.logout();
        loginService.login(user.getCredentials().getEmail(), newPassword);
        String accountName = accountPage.getMyAccountName();
        Assert.assertEquals(accountName, "My Account",
                "User can not login after successfully changing password");
        loginService.changePassword(user.getCredentials().getPassword());
    }
}
