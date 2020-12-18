package awesome.shop.tests.login;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;
import ru.awesome.shop.ta.product.pages.MainPage;
import ru.awesome.shop.ta.product.pages.login.AccountPage;

public class LogOutTest extends BaseConfigurationTest {
    private String logOutLabelText;

    @BeforeMethod(description = "login with valid credentials and then logout",
            groups = {"all", "positive"})
    public void logout() {
        User user = UserFactory.getUserWithValidCredentials();
        new MainPage().clickOnMyAccountLink().clickOnLoginLink().typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickLoginButton();
        logOutLabelText = new AccountPage().clickOnMyAccountLink().clickOnLogoutLink().getLogOutLabelText();
    }

    @Test(description = "***Logout***\n" +
            "EPMFARMATS-13119: check that user can logout after successful login\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13119")
    public void checkThatUserCanLogout() {
        Assert.assertEquals(logOutLabelText, "Account Logout", "User can not logout");
    }
}

