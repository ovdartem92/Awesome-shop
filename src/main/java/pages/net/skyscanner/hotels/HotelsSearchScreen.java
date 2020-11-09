package pages.net.skyscanner.hotels;

import pages.AbstractScreen;
import pages.net.skyscanner.hotels.source.FilterButtonsScreen;

public class HotelsSearchScreen extends AbstractScreen {
    private static final String DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR = "//input[@name='destination-autosuggest']";
    private static final String SEARCH_HOTELS_BUTTON_LOCATOR = "//button[@data-test-id='search-button']";
    private static final String FIRST_ELEMENT_OF_DROPDOWN_LOCATOR = "//input[@aria-activedescendant='react-autowhatever-1--item-0']";
    public FilterButtonsScreen filterButtons;

    public HotelsSearchScreen() {
        filterButtons = new FilterButtonsScreen();
    }

    public HotelsSearchScreen addDestination(String destination) {
        clickOnElement(DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR);
        typeTextToElement(DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR, destination);
        clickOnElement(FIRST_ELEMENT_OF_DROPDOWN_LOCATOR);
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
