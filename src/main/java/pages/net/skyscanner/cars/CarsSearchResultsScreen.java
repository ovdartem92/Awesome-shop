package pages.net.skyscanner.cars;

import pages.AbstractScreen;
import utils.StringUtils;

public class CarsSearchResultsScreen extends AbstractScreen {
    private static final String CAR_SEARCH_SUMMARY_ROUTE_LOCATOR = "//div[@id='carhire-search-summary-route']";

    public String getInfoAboutPickUpLocationFromSummary() {
        return StringUtils.getMatcherByIndex(getTextOnElement(CAR_SEARCH_SUMMARY_ROUTE_LOCATOR), "[^\\-]+", 0);
    }

    public String getInfoAboutDropOffLocationFromSummary() {
        return StringUtils.getMatcherByIndex(getTextOnElement(CAR_SEARCH_SUMMARY_ROUTE_LOCATOR), "[^\\-]+", 1);
    }
}
