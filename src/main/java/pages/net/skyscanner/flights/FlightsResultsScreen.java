package pages.net.skyscanner.flights;

import pages.AbstractScreen;

import java.util.List;

public class FlightsResultsScreen extends AbstractScreen {
    private static final String FLIGHTS_PRISES_SPAN_LOCATOR = "//span[contains(text(),'from')]/parent::p";

    public List<String> getTextFromPrices() {
        return getTextFromElements(FLIGHTS_PRISES_SPAN_LOCATOR);
    }
}
