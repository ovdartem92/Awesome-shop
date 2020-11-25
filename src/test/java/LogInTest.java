import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import service.AccountService;
import service.UserBuilder;

public class LogInTest extends BaseTest {
    private final AccountService ACCOUNT_SERVICE = new AccountService();
    private final HeaderScreen HEADER_SCREEN = new HeaderScreen();

    @BeforeMethod(description = "Click on login button")
    public void navigateToLoginScreen() {
        HEADER_SCREEN.clickLoginButton();
    }

    @Test(description = "check login with valid data")
    public void logInWithValidDataTest() {
        ACCOUNT_SERVICE.logIn(UserBuilder.getUserWithValidPassword());
        Assert.assertTrue(HEADER_SCREEN.isAccountButtonDisplayed(), "The account button is not active. Verification failed and you are not logged in. Incorrect data may have been entered");
    }

    @Test(description = "check login with invalid data")
    public void logInWithInValidDataTest() {
        ACCOUNT_SERVICE.logIn(UserBuilder.getUserWithInvalidPassword());
        Assert.assertTrue(HEADER_SCREEN.isLoginButtonDisplayed(), "The login button is not active. You may have entered the correct data and logged in");
    }
}
