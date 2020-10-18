import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

import static util.Utils.waitForElementLocatedBy;

public class LogInWithValidDataTest extends CommonConditions {

    @Test
    public void logInWithValidData() {
        new SkyScannerHomePage(driver).logIn(user = UserBuilder.getUserWithValidPassword());
        softAssert.assertEquals(true, waitForElementLocatedBy(driver, By.xpath("//span[text()='Account']")));
    }
}
