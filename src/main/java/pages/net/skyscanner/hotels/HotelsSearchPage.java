package pages.net.skyscanner.hotels;

import pages.AbstractScreen;

public class HotelsSearchPage extends AbstractScreen {
    private static final String HOTELS_SEARCH_BUTTON_LOCATOR = "//button[@data-test-id='search-button']";

    public String getTextFromHotelsSearchButton() {
        return getTextOnElement(HOTELS_SEARCH_BUTTON_LOCATOR);
    }
}
