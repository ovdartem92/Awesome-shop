import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import pages.net.skyscanner.elements.LogInScreen;
import service.AccountService;
import service.UserBuilder;

public class LogInWithInvalidDataTest extends BaseTest {

    @BeforeClass(description = "Click on login button and logIn with invalid data")
    public void navigateToLoginScreenAndLogIn() {
        new HeaderScreen().clickLoginButton();
        new AccountService().logIn(UserBuilder.getUserWithInvalidPassword());
    }

    @Test(description = "Check login with invalid data")
    public void logInWithInValidDataTest() {
        Assert.assertTrue(new LogInScreen().isWrongEmailMessageDisplayed(), "The login button is not active. You may have entered the correct data and logged in");
    }
}
