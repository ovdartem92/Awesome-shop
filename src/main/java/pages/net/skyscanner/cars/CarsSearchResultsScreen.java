package pages.net.skyscanner.cars;

import driver.Browser;
import pages.AbstractScreen;
import service.WaitManager;
import utils.StringUtils;

import java.util.List;

public class CarsSearchResultsScreen extends AbstractScreen {
    private static final String CLASS_TEXT = "class";
    private static final String TYPE_TEXT = "type";
    private static final String AGE_MESSAGE_TEXT = "Driver aged under 25";
    private static final String BANNER_ALERT_MESSAGE_LOCATOR =
            "//*[contains(@class,'BpkBannerAlert_bpk-banner-alert__message')][contains(text(),'%s')]";
    private static final String CAR_SEARCH_SUMMARY_ROUTE_LOCATOR = "//div[@id='carhire-search-summary-route']";
    private static final String CAR_GROUP_PANEL_INFO_SUMMARY_LOCATOR =
            "//div[contains(@class, 'CarGroupPanel_car-info')]";
    private static final String CAR_CHECKBOX_LOCATOR =
            "//div[@id='car-%s']//input[@type='checkbox' and @aria-label='%s']";

    public String getInfoAboutPickUpLocationFromSummary() {
        return StringUtils.getMatcherByIndex(getTextOnElement(CAR_SEARCH_SUMMARY_ROUTE_LOCATOR),
                "[^\\-]+", 0);
    }

    public String getInfoAboutDropOffLocationFromSummary() {
        return StringUtils.getMatcherByIndex(getTextOnElement(CAR_SEARCH_SUMMARY_ROUTE_LOCATOR),
                "[^\\-]+", 1);
    }

    public boolean isAgeAlertVisible() {
        return WaitManager.isElementVisible(String.format(BANNER_ALERT_MESSAGE_LOCATOR, AGE_MESSAGE_TEXT),
                Browser.DEFAULT_TIMEOUT_SECONDS);
    }

    public List<String> getListCarClassTypeFromGroupPanel() {
        return getTextFromElements(CAR_GROUP_PANEL_INFO_SUMMARY_LOCATOR);
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
