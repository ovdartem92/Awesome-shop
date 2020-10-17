import model.User;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

import static util.Util.waitForElementLocatedBy;

public class LogInWithValidData extends CommonConditions {

    User user = UserBuilder.getUserWithValidPassword();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void logInWithValidData() {
        new SkyScannerHomePage(driver)
                .openPage()
                .logIn(user);
        softAssert.assertEquals(true, waitForElementLocatedBy(driver, By.xpath("//button[@data-testid='btn-marketing-consent-cta']")));
    }


}
