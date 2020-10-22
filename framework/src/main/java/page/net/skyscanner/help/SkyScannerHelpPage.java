package page.net.skyscanner.help;

import page.AbstractPage;

import static service.ActionManager.*;
import static service.WaitManager.*;

public class SkyScannerHelpPage extends AbstractPage {

    private static final String SEARCH_AREA_FIELD_PATH = "//input[@id='query']";
    private static final String SEARCH_BUTTON_PATH = "//button[@value='Search']";

    public SkyScannerHelpPage sendTextToSearchArea(String text) {
        waitForElementLocatedBy(SEARCH_AREA_FIELD_PATH);
        clickOnElementBy(SEARCH_AREA_FIELD_PATH);
        typeTextToElementBy(SEARCH_AREA_FIELD_PATH, text);
        return this;
    }

    public SkyScannerHelpSearchResultsPage clickOnSearchButton() {
        waitForAllElementsLocatedBy(SEARCH_BUTTON_PATH);
        clickOnElementBy(SEARCH_BUTTON_PATH);
        return new SkyScannerHelpSearchResultsPage();
    }

    @Override
    public AbstractPage openPage() {
        return null;
    }
}
