import model.User;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

public class LogInTest extends CommonConditions {

    User user;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void LogInWithCorrectData() {
        new SkyScannerHomePage(driver)
                .openPage()
                .logIn(user = UserBuilder.getUserWithValidPassword());
        softAssert.assertEquals(true, driver.findElement(By.xpath("//button[@data-testid='btn-marketing-consent-cta']")));
    }

    @Test
    public void LogInWithInCorrectData() {
        new SkyScannerHomePage(driver)
                .openPage()
                .logIn(user = UserBuilder.getUserWithInvalidPassword());
        softAssert.assertEquals(true, driver.findElement(By.xpath("//span[text()='Wrong email or password']")));
    }
}
