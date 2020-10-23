package page.net.skyscanner;

import page.AbstractPage;
import page.net.skyscanner.flights.SkyScannerFlightsResultsPage;

import static service.ActionManager.*;

public class SkyScannerHomePage extends AbstractPage {
    public static final String SEARCH_FLIGHTS_BUTTON_PATH = "//button[text()='Search flights']";
    private static final String HOMEPAGE_URL = "https://www.skyscanner.net/";

    public SkyScannerFlightsResultsPage startFlightsSearch() {
        clickOnElementBy(SEARCH_FLIGHTS_BUTTON_PATH);
        return new SkyScannerFlightsResultsPage();
    }

    public String getTextFromFlightsButton() {
        return getTextOnElementBy(SEARCH_FLIGHTS_BUTTON_PATH);
    }

    public static String getHomepageUrl() {
        return HOMEPAGE_URL;
    }
}
