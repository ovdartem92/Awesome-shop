import model.User;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.net.skyscanner.elements.HeaderScreen;
import service.UserBuilder;

public class LogInTest extends BaseTest {
    User user;
    HeaderScreen headerScreen = new HeaderScreen();
    SoftAssert softAssert = new SoftAssert();

    @Test()
    public void logInWithValidDataTest() {
        headerScreen
                .clickLoginButton()
                .logIn(user = UserBuilder.getUserWithValidPassword());

        softAssert.assertTrue(headerScreen.isAccountButtonDisplayed(), "Oooops, something went wrong");
    }

    @Test()
    public void logInWithInValidDataTest() {
        headerScreen
                .clickLoginButton()
                .logIn(user = UserBuilder.getUserWithInvalidPassword());

        softAssert.assertTrue(headerScreen.isLoginButtonDisplayed(), "Oooops, something went wrong");
    }
}
