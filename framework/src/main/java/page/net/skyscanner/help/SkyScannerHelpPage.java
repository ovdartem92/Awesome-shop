package page.net.skyscanner.help;

import page.AbstractPage;
import static service.ActionManager.*;
import static service.WaitManager.*;

public class SkyScannerHelpPage extends AbstractPage {
    private static final String SEARCH_AREA_FIELD_PATH = "//input[@id='query']";
    private static final String SEARCH_BUTTON_PATH = "//button[@value='Search']";

    public SkyScannerHelpPage sendTextToSearchArea(String text) {
        clickOnElementBy(SEARCH_AREA_FIELD_PATH);
        typeInFieldWithDelay(SEARCH_AREA_FIELD_PATH, text);
        return this;
    }

    public SkyScannerHelpSearchResultsPage clickOnSearchButton() {
        waitForElementLocatedBy(SEARCH_BUTTON_PATH);
        clickOnElementBy(SEARCH_BUTTON_PATH);
        return new SkyScannerHelpSearchResultsPage();
    }
}
