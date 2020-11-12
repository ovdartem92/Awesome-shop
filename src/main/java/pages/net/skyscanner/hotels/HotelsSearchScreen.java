package pages.net.skyscanner.hotels;

import pages.AbstractScreen;
import pages.net.skyscanner.hotels.source.FilterButtonsScreen;
import service.HotelSearchService;

public class HotelsSearchScreen extends AbstractScreen {
    private static final String HOTELS_SEARCH_BUTTON_LOCATOR = "//button[@data-test-id='search-button']";
    public FilterButtonsScreen filterButtons;

    public HotelsSearchScreen() {
        filterButtons = new FilterButtonsScreen();
    }

    public String getTextFromHotelsSearchButton() {
        return getTextOnElement(HOTELS_SEARCH_BUTTON_LOCATOR);
    }

    public HotelsSearchScreen addDestinations(String destination) {
        HotelSearchService.addDestination(destination);
        return this;
    }

    public HotelsResultScreen clickToSearchHotelsButton() {
        clickOnElement(HOTELS_SEARCH_BUTTON_LOCATOR);
        return new HotelsResultScreen();
    }
}
