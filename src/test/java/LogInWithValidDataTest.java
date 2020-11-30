import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import service.AccountService;
import service.UserBuilder;

public class LogInWithValidDataTest extends BaseTest {

    @BeforeClass(description = "click on login button and logIn with valid data")
    public void navigateToLoginScreenAndLogin() {
        new HeaderScreen().clickLoginButton();
        new AccountService().logIn(UserBuilder.getUserWithValidPassword());
    }

    @Test(description = "check login with valid data")
    public void logInWithValidDataTest() {
        Assert.assertTrue(new HeaderScreen().isAccountButtonDisplayed(), "The account button is not active. Verification failed and you are not logged in. Incorrect data may have been entered");
    }
}
