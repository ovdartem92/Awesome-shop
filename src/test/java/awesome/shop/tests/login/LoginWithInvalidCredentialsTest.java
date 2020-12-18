package awesome.shop.tests.login;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;
import ru.awesome.shop.ta.product.pages.MainPage;
import ru.awesome.shop.ta.product.pages.login.LoginPage;

public class LoginWithInvalidCredentialsTest extends BaseConfigurationTest {

    @DataProvider(name = "userWithInvalidCredentials")
    public Object[][] getUser() {
        return new Object[][]{{UserFactory.getUserWithInvalidEmailAndValidPassword()},
                {UserFactory.getUserWithValidEmailAndInvalidPassword()}};
    }

    @BeforeMethod(description = "login",
            groups = {"all", "negative"})
    public void navigateToLoginPage() {
        new MainPage().clickOnMyAccountLink().clickOnLoginLink();
    }

    @Test(description = "***LoginWithInvalidCredentials***\n" +
            "EPMFARMATS-13121: check that user can not login with invalid email and valid password\n" +
            "EPMFARMATS-13120: check that user can not login with valid email and invalid password\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13121\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13120",
            dataProvider = "userWithInvalidCredentials",
            groups = {"all", "negative"})
    public void loginWithInvalidCredentials(User user) {
        String warningMessageText = new LoginPage().typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickLoginButtonExpectingFailure()
                .getTextWarningMessage();
        Assert.assertEquals(warningMessageText, "Warning: No match for E-Mail Address and/or Password.",
                "User can login with invalid email and valid password");
    }
}
