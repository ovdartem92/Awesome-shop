import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

public class CheckLogInWithInvalidDataTest extends BaseTest {

    @Test
    public void logInWithInvalidData() {
        SoftAssert softAssert = new SoftAssert();
        new SkyScannerHomePage()
                .logIn(user = UserBuilder.getUserWithInvalidPassword());
        softAssert.assertEquals(true, new SkyScannerHomePage().isLogInButtonActive());
    }
}
