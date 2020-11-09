import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import pages.net.skyscanner.profileScreen.ProfileScreen;
import service.UserBuilder;

public class CreateAndDeleteTravelerTest extends BaseTest {
    HeaderScreen headerScreen = new HeaderScreen();
    User user = UserBuilder.getUserWithValidPassword();
    ProfileScreen profileScreen = new ProfileScreen();

    @Test()
    public void createAndDeleteTravelerTest() {
        headerScreen
                .clickLoginButton()
                .logIn(user)
                .clickAccountButton()
                .clickAddTravelerButton()
                .addTraveler(user)
                .deleteTraveler();
        Assert.assertTrue(profileScreen.isDeleteMessageDisplayed(), "Something went wrong, you are not delete the traveler...");
    }
}
