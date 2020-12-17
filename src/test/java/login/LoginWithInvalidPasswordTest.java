package login;

import BaseTest.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.MainPage;

public class LoginWithInvalidPasswordTest extends BaseConfigurationTest {
    private String warningMessageText;

    @BeforeMethod(description = "login with valid email and invalid password")
    public void login() {
        User user = UserBuilder.getUserWithValidEmailAndInvalidPassword();
        warningMessageText = new MainPage().clickOnMyAccountLink().clickOnLoginLink().typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickLoginButtonExpectingFailure().getTextWarningMessage();
    }

    @Test(description = "check that user can not login with invalid password")
    public void loginWithInvalidEmail() {
        Assert.assertEquals(warningMessageText, "Warning: No match for E-Mail Address and/or Password.",
                "User can login with valid email and invalid password");
    }
}
