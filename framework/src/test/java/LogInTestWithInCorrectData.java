import model.User;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

import static util.Util.waitForElementLocatedBy;

public class LogInTestWithInCorrectData extends CommonConditions {

    User user;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void logInWithInCorrectData() {
        new SkyScannerHomePage(driver)
                .openPage()
                .logIn(user = UserBuilder.getUserWithInvalidPassword());
        softAssert.assertEquals(true, waitForElementLocatedBy(driver, By.xpath("//span[text()='Wrong email or password']")));
    }
}
