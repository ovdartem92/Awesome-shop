import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

import static service.WaitManager.isElementVisibleBy;

public class LogInWithInvalidDataTest extends BaseTest {

    @Test
    public void logInWithInvalidData() {
        new SkyScannerHomePage()
                .logIn(user = UserBuilder.getUserWithInvalidPassword());
        Assert.assertEquals(true, isElementVisibleBy("//span[text()='Log in']"));
    }
}
