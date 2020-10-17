import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

import static util.Util.waitForElementLocatedBy;

public class LogInWithInvalidDataTest extends CommonConditions {

    @Test
    public void logInWithInvalidData() {
        new SkyScannerHomePage(driver)
                .openPage()
                .logIn(user = UserBuilder.getUserWithInvalidPassword());
        softAssert.assertEquals(true, waitForElementLocatedBy(driver, By.xpath("//span[text()='Wrong email or password']")));
    }
}
