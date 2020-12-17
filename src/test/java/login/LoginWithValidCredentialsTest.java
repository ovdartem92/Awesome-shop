package login;

import BaseTest.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.MainPage;

public class LoginWithValidCredentialsTest extends BaseConfigurationTest {
    private String myAccountLabelText;

    @BeforeMethod(description = "login with valid email and valid password")
    public void login() {
        User user = UserBuilder.getUserWithValidCredentials();
        myAccountLabelText = new MainPage().clickOnMyAccountLink().clickOnLoginLink().typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickLoginButton().getTextFromMyAccountLabel();
    }

    @Test(description = "check than user can login with correct email and password")
    public void loginWithValidCredentialsTest() {
        Assert.assertEquals(myAccountLabelText, "My Account",
                "User with valid login and password can not login");
    }
}
