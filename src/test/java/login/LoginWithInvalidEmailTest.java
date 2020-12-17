package login;

import BaseTest.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.MainPage;

public class LoginWithInvalidEmailTest extends BaseConfigurationTest {
    private String warningMessageText;

    @BeforeMethod(description = "login with invalid email and valid password")
    public void login() {
        User user = UserBuilder.getUserWithInValidEmailAndValidPassword();
        warningMessageText = new MainPage().clickOnMyAccountLink().clickOnLoginLink()
                .typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickLoginButtonExpectingFailure()
                .getTextWarningMessage();
    }

    @Test(description = "check that user can not login with invalid email")
    public void loginWithInvalidEmail() {
        Assert.assertEquals(warningMessageText, "Warning: No match for E-Mail Address and/or Password.",
                "User can login with invalid email and valid password");
    }
}
