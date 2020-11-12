import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import service.UserBuilder;

public class CheckLogOutTest extends BaseTest {
    User user = UserBuilder.getUserWithValidPassword();
    HeaderScreen headerScreen = new HeaderScreen();

    @Test(description = "check the ability to make a logOut after logIn")
    public void logOutTest() {
        headerScreen
                .clickLoginButton()
                .logIn(user)
                .clickAccountButton()
                .logOut();
        Assert.assertTrue(headerScreen.isLoginButtonDisplayed(), "Oops, something went wrong. You are not logOut");
    }
}
