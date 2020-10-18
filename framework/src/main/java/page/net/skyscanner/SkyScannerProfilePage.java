package page.net.skyscanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.AbstractPage;

import static util.Utils.waitForElementLocatedBy;

public class SkyScannerProfilePage extends AbstractPage {

    private static final By ACCOUNT_FIELD = By.xpath("//span[@class='BpkText_bpk-text__Pt0NU BpkText_bpk-text--xs__2OIqg Menu_MenuItem__subtitle__2dCg3']");

    public SkyScannerProfilePage(WebDriver driver) {
        super(driver);
    }

    public SkyScannerProfilePage clickOnAccountField() {
        waitForElementLocatedBy(driver, ACCOUNT_FIELD).click();
        return this;
    }
}
