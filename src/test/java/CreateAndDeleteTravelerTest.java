import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import pages.net.skyscanner.profile_screen.ProfileScreen;
import service.AccountService;
import service.UserBuilder;

public class CreateAndDeleteTravelerTest extends BaseTest {

    @BeforeClass(description = "Click on login button, LogIn, create traveler and delete")
    public void preparingForTheTest() {
        AccountService accountService = new AccountService();
        HeaderScreen headerScreen = new HeaderScreen();
        User user = UserBuilder.getUserWithValidPassword();
        headerScreen.clickLoginButton();
        accountService.logIn(user);
        headerScreen.clickAccountButton();
        accountService.createTraveler(user);
        accountService.deleteTraveler();
    }

    @Test(description = "Check ability to create and delete a new traveler")
    public void checkDeleteTravelerTest() {
        Assert.assertTrue(new ProfileScreen().isDeleteMessageDisplayed(), "Delete message is not displayed, you are not delete the traveler.");
    }
}
