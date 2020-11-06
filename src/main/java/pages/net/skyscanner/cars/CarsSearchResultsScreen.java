package pages.net.skyscanner.cars;

import pages.AbstractScreen;

public class CarsSearchResultsScreen extends AbstractScreen {
    private static final String CAR_SEARCH_SUMMARY_ROUTE_LOCATOR = "//div[@id='carhire-search-summary-route']";

    public String getInfoAboutPickUpLocationFromSummary() {
        String[] array = getTextOnElement(CAR_SEARCH_SUMMARY_ROUTE_LOCATOR).split(" - ");
        return array[0];
    }

    public String getInfoAboutDropOffLocationFromSummary() {
        String[] array = getTextOnElement(CAR_SEARCH_SUMMARY_ROUTE_LOCATOR).split(" - ");
        return array[1];
    }
}
