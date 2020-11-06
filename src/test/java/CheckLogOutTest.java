import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import service.UserBuilder;

public class CheckLogOutTest extends BaseTest {
    User user = UserBuilder.getUserWithValidPassword();
    HeaderScreen headerScreen = new HeaderScreen();

    @Test()
    public void logOutTest() {
        headerScreen
                .clickToLoginButton()
                .logIn(user)
                .clickToAccountButton()
                .logOut();
        Assert.assertTrue(headerScreen.isLoginButtonDisplayed(), "Oooops, something went wrong");
    }
}
