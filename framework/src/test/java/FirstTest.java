import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;

public class FirstTest extends CommonConditions {

    @Test
    public void ourFirstTest() {
        new SkyScannerHomePage(driver)
                .openPage();
        softAssert.assertEquals(driver.getCurrentUrl(), SkyScannerHomePage.getHomepageUrl());
    }

}
