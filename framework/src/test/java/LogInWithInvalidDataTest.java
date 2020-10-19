import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

import static service.WaitManager.isElementVisibleBy;

public class LogInWithInvalidDataTest extends CommonConditions {

    @Test
    public void logInWithInvalidData() {
        new SkyScannerHomePage()
                .logIn(user = UserBuilder.getUserWithInvalidPassword());
        softAssert.assertEquals(true, isElementVisibleBy(By.xpath("//span[text()='Log in']")));
    }
}
