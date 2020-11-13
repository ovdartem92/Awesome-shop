import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AbstractScreen;
import pages.net.skyscanner.elements.HeaderScreen;
import service.AccountService;
import service.UserBuilder;

public class LogInTest extends BaseTest {
    private final AccountService ACCOUNT_SERVICE = new AccountService();
    private User user;

    @BeforeMethod(description = "Click on login button")
    public void navigateToLoginScreen() {
        AbstractScreen.header.clickLoginButton();
    }

    @Test(description = "check login with valid data")
    public void logInWithValidDataTest() {
        ACCOUNT_SERVICE.logIn(user = UserBuilder.getUserWithValidPassword());
        Assert.assertTrue(AbstractScreen.header.isAccountButtonDisplayed(), "Oops, something went wrong. You're not logIn");
    }

    @Test(description = "check login with invalid data")
    public void logInWithInValidDataTest() {
        ACCOUNT_SERVICE.logIn(user = UserBuilder.getUserWithInvalidPassword());
        Assert.assertTrue(AbstractScreen.header.isLoginButtonDisplayed(), "Oops, something went wrong.");
    }
}
