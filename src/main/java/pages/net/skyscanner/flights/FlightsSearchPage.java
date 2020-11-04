package pages.net.skyscanner.flights;

import pages.AbstractPage;

public class FlightsSearchPage extends AbstractPage {
    private static final String FLIGHTS_SEARCH_BUTTON_LOCATOR = "//button[text()='Search flights']";

    public String getTextFromFlightsSearchButton() {
        return getTextOnElement(FLIGHTS_SEARCH_BUTTON_LOCATOR);
    }
}
