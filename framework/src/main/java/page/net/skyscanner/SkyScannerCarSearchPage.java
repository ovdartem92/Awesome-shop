package page.net.skyscanner;

import org.openqa.selenium.By;

import static service.ActionManager.getElementBy;

public class SkyScannerCarSearchPage  {

    private static final By CAR_HEADER = By.xpath("//div[@class='SearchControls_search-controls-title__27T3N']");

    public String getTextFromCarHeader() {
        return getElementBy(CAR_HEADER).getText();
    }
}
