package awesome.shop.tests.ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rp.org.apache.http.auth.AuthenticationException;
import ru.awesome.shop.ta.framework.configuration.PropertyManager;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;
import ru.awesome.shop.ta.product.services.AccountService;
import ru.awesome.shop.ta.product.services.AuthenticationService;
import ru.awesome.shop.ta.product.services.NavigationService;

public class LoginTest extends BaseConfigurationTest {
    private static final String REGISTER_EMAIL = PropertyManager.getEmail();
    private static final String REGISTER_PASSWORD = PropertyManager.getPassword();
    private AuthenticationService authenticationService = new AuthenticationService();

    @DataProvider(name = "invalidUser")
    public Object[][] getInvalidUser() {
        return new Object[][]{{UserFactory.generateUserWithRegisteredCredentialsWithInvalidEmail()},
                {UserFactory.generateUserWithRegisteredCredentialsWithInvalidPassword()}
        };
    }

    @BeforeMethod(description = "open login page",
            groups = {"all", "negative", "positive"})
    public void openLoginPage() {
        NavigationService navigationService = new NavigationService();
        navigationService.navigateToLoginPage();
    }

    @Test(description = "***LoginWithValidCredentials***\n" +
            "EPMFARMATS-13118: check than user can login with correct email and password\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13118",
            groups = {"all", "positive"})
    public void loginWithValidCredentialsTest() throws AuthenticationException {
        authenticationService.login(REGISTER_EMAIL, REGISTER_PASSWORD);
        AccountService accountService = new AccountService();
        String actualAccountName = accountService.getAccountName();
        Assert.assertEquals(actualAccountName, "My Account",
                "Incorrect account name");
    }

    @Test(description = "***Logout***\n" +
            "EPMFARMATS-13119: check that user can logout after successful login\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13119",
            groups = {"all", "positive"})
    public void checkThatUserCanLogout() throws AuthenticationException {
        authenticationService.login(REGISTER_EMAIL, REGISTER_PASSWORD);
        authenticationService.logout();
        String actualBreadcrumbLogoutText = authenticationService.getBreadcrumbLogoutText();
        Assert.assertEquals(actualBreadcrumbLogoutText, "Logout",
                "Incorrect breadcrumbls logout text");
    }

    @Test(description = "***LoginWithInvalidCredentials***\n" +
            "EPMFARMATS-13121: check that user can not login with invalid email and valid password\n" +
            "EPMFARMATS-13120: check that user can not login with valid email and invalid password\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13121\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13120",
            dataProvider = "invalidUser",
            expectedExceptions = AuthenticationException.class,
            groups = {"all", "negative"})
    public void loginWithInvalidCredentials(User user) throws AuthenticationException {
        Credentials userCredentials = user.getCredentials();
        String userEmail = userCredentials.getEmail();
        String userPassword = userCredentials.getPassword();
        authenticationService.login(userEmail, userPassword);
    }
}
