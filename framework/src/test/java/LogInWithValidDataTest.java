import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

public class LogInWithValidDataTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void logInWithValidData() {
        SkyScannerHomePage skyScannerHomePage = new SkyScannerHomePage()
                .logIn(user = UserBuilder.getUserWithValidPassword());
        softAssert.assertEquals(true, skyScannerHomePage.isAccountButtonActive());
    }
}
