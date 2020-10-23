import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

public class CheckLogInWithInvalidDataTest extends BaseTest {

    @Test
    public void logInWithInvalidData() {
        new SkyScannerHomePage()
                .logIn(user = UserBuilder.getUserWithInvalidPassword());
        Assert.assertTrue(new SkyScannerHomePage().isLogInButtonActive(), "Something wrong");
    }
}
