import model.User;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;
import service.UserBuilder;

import static util.Util.waitForElementLocatedBy;

public class CheckYourEmailAfterLogInTest extends CommonConditions {

    User user = UserBuilder.getUserWithValidPassword();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void checkYourEmail() {
        new SkyScannerHomePage(driver)
                .openPage()
                .logIn(user)
                .closeModal()
                .openProfilePage()
                .clickOnAccountField();

        softAssert.assertEquals(user.getPassword(), waitForElementLocatedBy(driver, By.xpath("//span[@class=\"BpkText_bpk-text__Pt0NU BpkText_bpk-text--xl__3cUZL SectionItem_SectionItem__text__1utHx\"]")));
    }
}
