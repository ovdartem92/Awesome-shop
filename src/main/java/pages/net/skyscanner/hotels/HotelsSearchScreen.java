package pages.net.skyscanner.hotels;

import pages.AbstractScreen;
import pages.net.skyscanner.hotels.source.FilterButtonsScreen;

public class HotelsSearchScreen extends AbstractScreen {
    private static final String DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR = "//input[@name='destination-autosuggest']";
    private static final String SEARCH_HOTELS_BUTTON_LOCATOR = "//button[@data-test-id='search-button']";
    public FilterButtonsScreen filterButtons;

    public HotelsSearchScreen() {
        filterButtons = new FilterButtonsScreen();
    }

    public HotelsSearchScreen addDestination(String destination) {
        typeInFieldWithDelay(DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR, destination);
        return this;
    }

    public HotelsResultScreen clickToSearchHotelsButton() {
        clickOnElement(SEARCH_HOTELS_BUTTON_LOCATOR);
        return new HotelsResultScreen();
    }

    public String getTextFromHotelButton() {
        return getTextOnElement(SEARCH_HOTELS_BUTTON_LOCATOR);
    }
}
