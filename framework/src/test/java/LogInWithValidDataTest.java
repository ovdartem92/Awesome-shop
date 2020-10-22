import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

import static service.WaitManager.isElementVisibleBy;

public class LogInWithValidDataTest extends BaseTest {

    @Test
    public void logInWithValidData() {
        new SkyScannerHomePage()
                .logIn(user = UserBuilder.getUserWithValidPassword());
        softAssert.assertEquals(true, isElementVisibleBy("//span[text()='Account']"));
    }
}
