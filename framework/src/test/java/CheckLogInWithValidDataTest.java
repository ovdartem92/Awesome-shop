import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

public class CheckLogInWithValidDataTest extends BaseTest {

    @Test
    public void logInWithValidData() {
        new SkyScannerHomePage()
                .switchToEnglish()
                .logIn(user = UserBuilder.getUserWithValidPassword());
        Assert.assertTrue(new SkyScannerHomePage().isAccountButtonActive(), "Something wrong");
    }
}
