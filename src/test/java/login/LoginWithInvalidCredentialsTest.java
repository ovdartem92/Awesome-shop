package login;

import BaseTest.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.MainPage;
import ru.awesome.shop.ta.product.pages.login.LoginPage;

public class LoginWithInvalidCredentialsTest extends BaseConfigurationTest {

    @DataProvider(name = "userWithInvalidData")
    public Object[][] getUser() {
        return new Object[][]{{UserBuilder.getUserWithInvalidEmailAndValidPassword()},
                {UserBuilder.getUserWithValidEmailAndInvalidPassword()}};
    }

    @BeforeMethod(description = "login with invalid email and valid password")
    public void navigateToLoginPage() {
        new MainPage().clickOnMyAccountLink().clickOnLoginLink();
    }

    @Test(description = "check that user can not login with invalid email",
            dataProvider = "userWithInvalidData")
    public void loginWithInvalidCredentials(User user) {
        String warningMessageText = new LoginPage().typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickLoginButtonExpectingFailure()
                .getTextWarningMessage();
        Assert.assertEquals(warningMessageText, "Warning: No match for E-Mail Address and/or Password.",
                "User can login with invalid email and valid password");
    }
}
