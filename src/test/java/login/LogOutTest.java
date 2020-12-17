package login;

import BaseTest.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.services.UserBuilder;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.pages.MainPage;
import ru.awesome.shop.ta.product.pages.login.AccountPage;

public class LogOutTest extends BaseConfigurationTest {
    private String logOutLabelText;

    @BeforeMethod(description = "login with valid credentials and then logout")
    public void logout() {
        User user = UserBuilder.getUserWithValidCredentials();
        new MainPage().clickOnMyAccountLink().clickOnLoginLink().typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickLoginButton();
        logOutLabelText = new AccountPage().clickOnMyAccountLink().clickOnLogoutLink().getLogOutLabelText();
    }

    @Test(description = "check that user cat logout after successful login")
    public void checkThatUserCanLogout() {
        Assert.assertEquals(logOutLabelText, "Account Logout", "User can not logout");
    }
}
