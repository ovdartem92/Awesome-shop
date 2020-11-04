import model.User;
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
                .openProfilePage()
                .headerScreen()
                .clickRegionalSettingsButton()
                .profilePage()
                .switchToEnglish()
                .logOut();
    }
}
