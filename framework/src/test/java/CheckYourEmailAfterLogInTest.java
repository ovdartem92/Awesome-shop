import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

import static service.ActionManager.getElementBy;

public class CheckYourEmailAfterLogInTest extends BaseTest {

    @Test
    public void checkYourEmail() {
        new SkyScannerHomePage()
                .logIn(user = UserBuilder.getUserWithValidPassword())
                .openProfilePage()
                .switchToEnglish()
                .clickOnAccountField();
        softAssert.assertEquals(user.getEmail(), getElementBy(String.format("//span[contains(text(), '%s')]", user.getEmail())).toString());
    }
}
