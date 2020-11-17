package pages.net.skyscanner.cars;

import pages.AbstractScreen;
import utils.StringUtils;

import java.util.List;

public class CarsSearchResultsScreen extends AbstractScreen {
    private static final String CLASS_TEXT = "class";
    private static final String TYPE_TEXT = "type";
    private static final String CAR_SEARCH_SUMMARY_ROUTE_LOCATOR = "//div[@id='carhire-search-summary-route']";
    private static final String CAR_GROUP_PANEL_INFO_LOCATOR_SUMMARY = "//div[contains(@class, 'CarGroupPanel_car-info')]";
    private static final String CAR_CHECKBOX_LOCATOR = "//div[@id='car-%s']//input[@type='checkbox' and @aria-label='%s']";

    public String getInfoAboutPickUpLocationFromSummary() {
        return StringUtils.getMatcherByIndex(getTextOnElement(CAR_SEARCH_SUMMARY_ROUTE_LOCATOR), "[^\\-]+", 0);
    }

    public String getInfoAboutDropOffLocationFromSummary() {
        return StringUtils.getMatcherByIndex(getTextOnElement(CAR_SEARCH_SUMMARY_ROUTE_LOCATOR), "[^\\-]+", 1);
    }

    public List<String> getListCarClassTypeFromGroupPanel() {
        return getTextFromElements(CAR_GROUP_PANEL_INFO_LOCATOR_SUMMARY);
    }

    public CarsSearchResultsScreen setCarClass(String carClass) {
        clickOnElement(String.format(CAR_CHECKBOX_LOCATOR, CLASS_TEXT, carClass));
        return this;
    }

    public CarsSearchResultsScreen setCarType(String carType) {
        clickOnElement(String.format(CAR_CHECKBOX_LOCATOR, TYPE_TEXT, carType));
        return this;
    }
}
