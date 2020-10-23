import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.SkyScannerProfilePage;
import service.UserBuilder;

public class CheckYourEmailAfterLogInTest extends BaseTest {

    @Test
    public void checkYourEmail() {
        new SkyScannerHomePage()
                .logIn(user = UserBuilder.getUserWithValidPassword())
                .openProfilePage()
                .switchToEnglish()
                .clickOnAccountField();
        Assert.assertTrue(new SkyScannerProfilePage().findAndGetUserEmail(user));
    }
}
