import model.User;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

import static util.Util.waitForElementLocatedBy;

public class LogInWithInvalidDataTest extends CommonConditions {

    User user = UserBuilder.getUserWithInvalidPassword();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void logInWithInvalidData() {
        new SkyScannerHomePage(driver)
                .openPage()
                .logIn(user);
        softAssert.assertEquals(true, waitForElementLocatedBy(driver, By.xpath("//span[text()='Wrong email or password']")));
    }
}
