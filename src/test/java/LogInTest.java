import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import service.UserBuilder;

public class LogInTest extends BaseTest {
    User user;
    HeaderScreen headerScreen = new HeaderScreen();

    @Test(description = "check login with valid data")
    public void logInWithValidDataTest() {
        headerScreen
                .clickLoginButton()
                .logIn(user = UserBuilder.getUserWithValidPassword());

        Assert.assertTrue(headerScreen.isAccountButtonDisplayed(), "Oops, something went wrong. You're not logIn");
    }

    @Test(description = "check login with invalid data")
    public void logInWithInValidDataTest() {
        headerScreen
                .clickLoginButton()
                .logIn(user = UserBuilder.getUserWithInvalidPassword());

        Assert.assertTrue(headerScreen.isLoginButtonDisplayed(), "Oops, something went wrong.");
    }
}
