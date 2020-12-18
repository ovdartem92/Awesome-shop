package awesome.shop.tests.login;

import awesome.shop.tests.BaseConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.product.bo.user.UserFactory;
import ru.awesome.shop.ta.product.pages.MainPage;

public class LoginWithValidCredentialsTest extends BaseConfigurationTest {
    private String myAccountLabelText;

    @BeforeMethod(description = "login with valid email and valid password",
            groups = {"all", "positive"})
    public void login() {
        User user = UserFactory.getUserWithValidCredentials();
        myAccountLabelText = new MainPage().clickOnMyAccountLink().clickOnLoginLink().typeEmailAddress(user.getEmail())
                .typePassword(user.getPassword()).clickLoginButton().getTextFromMyAccountLabel();
    }

    @Test(description = "***LoginWithValidCredentials***\n" +
            "EPMFARMATS-13118: check than user can login with correct email and password\n" +
            "https://jira.epam.com/jira/browse/EPMFARMATS-13118",
            groups = {"all", "positive"})
    public void loginWithValidCredentialsTest() {
        Assert.assertEquals(myAccountLabelText, "My Account",
                "User with valid email and password can not login");
    }
}
