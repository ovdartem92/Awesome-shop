package page.net.skyscanner;

import org.openqa.selenium.By;

import static service.ActionManager.clickOnElementBy;

public class SkyScannerProfilePage {

    private static final By ACCOUNT_FIELD = By.xpath("//span[@class='BpkText_bpk-text__Pt0NU BpkText_bpk-text--xs__2OIqg Menu_MenuItem__subtitle__2dCg3']");

    public SkyScannerProfilePage clickOnAccountField() {
        clickOnElementBy(ACCOUNT_FIELD);
        return this;
    }
}
