import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

public class CheckLogOutTest extends BaseTest {

    @Test
    public void logOut() {
        new SkyScannerHomePage()
                .getHeader()
                .logIn(user = UserBuilder.getUserWithValidPassword())
                .openProfilePage()
                .switchToEnglish()
                .logOut();
        Assert.assertTrue(new SkyScannerHomePage().getHeader().isLogInButtonActive(), "Element not found, you are not logged out");
    }
}
