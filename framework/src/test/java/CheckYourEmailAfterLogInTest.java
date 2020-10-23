import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.SkyScannerProfilePage;
import service.UserBuilder;

public class CheckYourEmailAfterLogInTest extends BaseTest {

    @Test
    public void checkYourEmail() {
        SoftAssert softAssert = new SoftAssert();
        new SkyScannerHomePage()
                .logIn(user = UserBuilder.getUserWithValidPassword())
                .openProfilePage()
                .switchToEnglish()
                .clickOnAccountField();
        softAssert.assertEquals(user.getEmail(), new SkyScannerProfilePage().findAndGetUserEmail(user));
    }
}
