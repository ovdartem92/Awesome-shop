import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.net.skyscanner.SkyScannerHomePage;

public class FirstTest extends CommonConditions {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void ourFirstTest() {
        new SkyScannerHomePage(driver)
                .openPage();
        softAssert.assertEquals(driver.getCurrentUrl(), SkyScannerHomePage.getHomepageUrl());
    }

}
