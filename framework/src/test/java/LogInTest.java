import model.User;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

public class LogInTest extends CommonConditions {

    SoftAssert softAssert = new SoftAssert();
    User user = UserBuilder.getUserWithValidPassword();
    User userInValid = UserBuilder.getUserWithInvalidPassword();

    @Test
    public void LogInWithCorrectData() {
        new SkyScannerHomePage(driver)
                .openPage()
                .logIn(user);
    }
}
