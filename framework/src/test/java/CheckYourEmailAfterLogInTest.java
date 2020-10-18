import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

import static util.Utils.waitForElementLocatedBy;

public class CheckYourEmailAfterLogInTest extends CommonConditions {

    @Test
    public void checkYourEmail() {
        user = UserBuilder.getUserWithValidPassword();
        new SkyScannerHomePage(driver).logIn(user)
                .openProfilePage()
                .clickOnAccountField();

        softAssert.assertEquals(user.getPassword(), waitForElementLocatedBy(driver, By.xpath("//span[@class='BpkText_bpk-text__Pt0NU BpkText_bpk-text--xl__3cUZL SectionItem_SectionItem__text__1utHx']")));
    }
}
