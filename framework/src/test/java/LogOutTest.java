import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

public class LogOutTest extends BaseTest {

    @Test
    public void logOut() {
        SkyScannerHomePage skyScannerHomePage = new SkyScannerHomePage()
                .logIn(user = UserBuilder.getUserWithValidPassword())
                .openProfilePage()
                .switchToEnglish()
                .logOut();
        Assert.assertTrue(skyScannerHomePage.isLogInButtonActive(), "Element not found, you are not logged out");
    }
}
