package page.net.skyscanner;

import page.AbstractPage;
import static service.ActionManager.getElementBy;

public class SkyScannerCarSearchPage extends AbstractPage {

    private static final String CAR_HEADER_PATH = "//div[@class='SearchControls_search-controls-title__27T3N']";

    public String getTextFromCarHeader() {
        return getElementBy(CAR_HEADER_PATH).getText();
    }
}
