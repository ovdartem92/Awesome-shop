package pages.net.skyscanner.hotels;

import pages.AbstractScreen;
import pages.net.skyscanner.hotels.source.GuestsAndRoomsFilterScreen;
import service.HotelSearchService;

public class HotelsSearchScreen extends AbstractScreen {
    private static final String DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR = "//input[@name='destination-autosuggest']";
    private static final String FIRST_ELEMENT_OF_DROPDOWN_LOCATOR = "//input[@aria-activedescendant='react-autowhatever-1--item-0']";
    private static final String GUESTS_AND_ROOMS_INPUT_LOCATOR = "//input[@id='guests-rooms']";
    private static final String HOTELS_SEARCH_BUTTON_LOCATOR = "//button[@data-test-id='search-button']";
    public GuestsAndRoomsFilterScreen guestsAndRoomsFilterButtons = new GuestsAndRoomsFilterScreen();

    public String getTextFromHotelsSearchButton() {
        return getTextOnElement(HOTELS_SEARCH_BUTTON_LOCATOR);
    }

    public HotelsSearchScreen addDestinations(String destination) {
        new HotelSearchService().addDestination(destination);
        return this;
    }

    public HotelsSearchScreen typeTextToDestinationInput(String destination) {
        typeTextToElement(DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR, destination);
        return this;
    }

    public HotelsSearchScreen clickOnFirstDropdownInput() {
        clickOnElement(FIRST_ELEMENT_OF_DROPDOWN_LOCATOR);
        return this;
    }

    public HotelsResultScreen clickToSearchHotelsButton() {
        clickOnElement(HOTELS_SEARCH_BUTTON_LOCATOR);
        return new HotelsResultScreen();
    }

    public HotelsSearchScreen clickOnGuestAndRoomsInput() {
        clickOnElement(GUESTS_AND_ROOMS_INPUT_LOCATOR);
        return this;
    }
}
