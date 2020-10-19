package page.net.skyscanner;

import org.openqa.selenium.By;
import page.AbstractPage;

import static service.ActionManager.getElementBy;

public class SkyScannerCarSearchPage extends AbstractPage {

    private static final By CAR_HEADER = By.xpath("//div[@class='SearchControls_search-controls-title__27T3N']");

    public String getTextFromCarHeader() {
        return getElementBy(CAR_HEADER).getText();
    }
}
