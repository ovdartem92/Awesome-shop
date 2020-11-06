package pages.net.skyscanner.flights;

import pages.AbstractScreen;

public class FlightsSearchPage extends AbstractScreen {
    private static final String FLIGHTS_SEARCH_BUTTON_LOCATOR = "//button[@type='submit']";

    public String getTextFromFlightsSearchButton() {
        return getTextOnElement(FLIGHTS_SEARCH_BUTTON_LOCATOR);
    }
}
