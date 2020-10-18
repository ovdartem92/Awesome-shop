import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

import static util.Waiter.waitForElementLocatedBy;

public class LogInWithInvalidDataTest extends CommonConditions {

    @Test
    public void logInWithInvalidData() {
        new SkyScannerHomePage(driver)
                .logIn(user = UserBuilder.getUserWithInvalidPassword());
        softAssert.assertEquals(true, waitForElementLocatedBy(driver, By.xpath("//span[text()='Log in']")));
    }
}
