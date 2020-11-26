import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AbstractScreen;
import pages.net.skyscanner.profileScreen.ProfileScreen;
import service.AccountService;
import service.UserBuilder;

public class CreateAndDeleteTravelerTest extends BaseTest {

    @BeforeClass(description = "Click on login button, LogIn, create traveler and delete")
    public void preparingForTheTest() {
        AccountService accountService = new AccountService();
        User user = UserBuilder.getUserWithValidPassword();
        AbstractScreen.header.clickLoginButton();
        accountService.logIn(user);
        accountService.createTraveler(user);
        accountService.deleteTraveler();
    }

    @Test(description = "check ability to create and delete a new traveler")
    public void checkDeleteTravelerTest() {
        Assert.assertTrue(new ProfileScreen().isDeleteMessageDisplayed(), "Delete message is not displayed, you are not delete the traveler...");
    }
}
