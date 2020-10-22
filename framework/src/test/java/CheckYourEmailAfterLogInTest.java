import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.SkyScannerProfilePage;
import service.UserBuilder;

import static service.ActionManager.getElementBy;

public class CheckYourEmailAfterLogInTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void checkYourEmail() {
        new SkyScannerHomePage()
                .logIn(user = UserBuilder.getUserWithValidPassword())
                .openProfilePage();
        SkyScannerProfilePage skyScannerProfilePage = new SkyScannerProfilePage()
                .switchToEnglish()
                .clickOnAccountField();
        softAssert.assertEquals(user.getEmail(), skyScannerProfilePage.returnUserEmail(user));
    }
}
