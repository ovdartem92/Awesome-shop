package pages.net.skyscanner.cars;

import pages.AbstractScreen;
import service.WaitManager;
import utils.StringUtils;

public class CarsSearchResultsScreen extends AbstractScreen {
    private static final String CAR_SEARCH_SUMMARY_ROUTE_LOCATOR = "//div[@id='carhire-search-summary-route']";
    private static final String ALERT_AGE_MESSAGE = "//span[contains(text(), 'Driver aged under 25')]";

    public String getInfoAboutPickUpLocationFromSummary() {
        return StringUtils.getMatcherByIndex(getTextOnElement(CAR_SEARCH_SUMMARY_ROUTE_LOCATOR), "[^\\-]+", 0);
    }

    public String getInfoAboutDropOffLocationFromSummary() {
        return StringUtils.getMatcherByIndex(getTextOnElement(CAR_SEARCH_SUMMARY_ROUTE_LOCATOR), "[^\\-]+", 1);
    }

    public boolean isAgeAlertVisible() {
        return WaitManager.isElementVisible(ALERT_AGE_MESSAGE);
    }
}
