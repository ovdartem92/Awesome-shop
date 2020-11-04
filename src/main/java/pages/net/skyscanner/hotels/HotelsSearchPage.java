package pages.net.skyscanner.hotels;

import pages.AbstractPage;

public class HotelsSearchPage extends AbstractPage {
    private static final String HOTELS_SEARCH_BUTTON_LOCATOR = "//button[@data-test-id='search-button']";

    public String getTextFromHotelsSearchButton() {
        return getTextOnElement(HOTELS_SEARCH_BUTTON_LOCATOR);
    }
}
