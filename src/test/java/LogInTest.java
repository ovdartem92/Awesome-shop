import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import service.AccountService;
import service.UserBuilder;

public class LogInTest extends BaseTest {
    private final HeaderScreen HEADER_SCREEN = new HeaderScreen();
    private final AccountService ACCOUNT_SERVICE = new AccountService();
    private User user;

    @BeforeClass(description = "Click on login button")
    public void navigateToLoginScreen() {
        HEADER_SCREEN.clickLoginButton();
    }

    @Test(description = "check login with valid data")
    public void logInWithValidDataTest() {
        ACCOUNT_SERVICE.logIn(user = UserBuilder.getUserWithValidPassword());
        Assert.assertTrue(HEADER_SCREEN.isAccountButtonDisplayed(), "Oops, something went wrong. You're not logIn");
    }

    @Test(description = "check login with invalid data")
    public void logInWithInValidDataTest() {
        ACCOUNT_SERVICE.logIn(user = UserBuilder.getUserWithInvalidPassword());
        Assert.assertTrue(HEADER_SCREEN.isLoginButtonDisplayed(), "Oops, something went wrong.");
    }
}
