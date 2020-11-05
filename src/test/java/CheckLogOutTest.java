import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import service.UserBuilder;

public class CheckLogOutTest extends BaseTest {

    User user = UserBuilder.getUserWithValidPassword();
    @Test()
    public void logOutTest() {
        new HeaderScreen()
                .clickToLoginButton()
                .logIn(user)
                .clickToAccountButton()
                .switchToEnglish()
                .logOut();
        Assert.assertTrue(new HeaderScreen().isLoginButtonDisplayed(), "Element not found, you are not logged out");
    }
}
