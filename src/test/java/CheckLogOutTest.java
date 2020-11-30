import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import service.AccountService;
import service.UserBuilder;

public class CheckLogOutTest extends BaseTest {
    private final HeaderScreen HEADER_SCREEN = new HeaderScreen();

    @BeforeClass(description = "Click on login button, LogIn and LogOut")
    public void navigateToLoginScreenAndLogInAndLogOut() {
        AccountService accountService = new AccountService();
        User user = UserBuilder.getUserWithValidPassword();
        HEADER_SCREEN.clickLoginButton();
        accountService.logIn(user);
        HEADER_SCREEN.clickAccountButton();
        accountService.logOut();
    }

    @Test(description = "check the ability to make a logOut")
    public void logOutTest() {
        Assert.assertTrue(HEADER_SCREEN.isLoginButtonDisplayed(), "The login button is not active. You are not logOut.");
    }
}
