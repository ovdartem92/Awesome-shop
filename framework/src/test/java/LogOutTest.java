import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

import static service.WaitManager.isElementVisibleBy;

public class LogOutTest extends BaseTest {

    @Test
    public void logOut() {
        new SkyScannerHomePage()
                .logIn(user = UserBuilder.getUserWithValidPassword())
                .openProfilePage()
                .switchToEnglish()
                .logOut();
        Assert.assertTrue(isElementVisibleBy("//span[text()='Log in']"), "Element not found, you are not logged out");
    }
}
