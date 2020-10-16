import model.User;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

public class LogInTest extends CommonConditions {

    SoftAssert softAssert = new SoftAssert();
    User user = UserBuilder.getUserWithInvalidPassword();

    @Test
    public void LogIn() {
        new SkyScannerHomePage(driver)
                .openPage()
                .clickOnLogIn()
                .clickOnContinueWithEmail()
                .enterEmail(user.getEmail())
                .enterPassword(user.getPassword())
                .closeModal();
    }
}
