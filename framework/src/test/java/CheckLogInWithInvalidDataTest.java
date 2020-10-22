import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

public class CheckLogInWithInvalidDataTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void logInWithInvalidData() {
        SkyScannerHomePage skyScannerHomePage = new SkyScannerHomePage()
                .logIn(user = UserBuilder.getUserWithInvalidPassword());
        softAssert.assertEquals(true, skyScannerHomePage.isLogInButtonActive());
    }
}
