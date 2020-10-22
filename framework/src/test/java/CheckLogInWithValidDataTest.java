import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

public class CheckLogInWithValidDataTest extends BaseTest {

    @Test
    public void logInWithValidData() {
        SoftAssert softAssert = new SoftAssert();
        new SkyScannerHomePage()
                .logIn(user = UserBuilder.getUserWithValidPassword());
        softAssert.assertEquals(true, new SkyScannerHomePage().isAccountButtonActive());
    }
}
