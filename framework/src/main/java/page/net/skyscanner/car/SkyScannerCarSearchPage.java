package page.net.skyscanner.car;

import page.AbstractPage;

import static service.ActionManager.*;
import static service.WaitManager.*;

public class SkyScannerCarSearchPage extends AbstractPage {

    private static final String CAR_HEADER_PATH = "//div[@class='SearchControls_search-controls-title__27T3N']";
    private static final String PICKUP_LOCATION_PATH = "//input[@id='carhire-search-controls-location-pick-up']";
    private static final String DROP_OFF_LOCATION_PATH = "//input[@id='carhire-search-controls-location-drop-off']";
    private static final String RETURN_CAR_TO_A_DIFFERENT_LOCATION_CHECKBOX_PATH = "//input[@id='carhire-search-controls-different-drop-off-docked']";
    private static final String DATE_PICKUP_PATH = "//input[@id='carhire-search-controls-date-pick-up']";
    private static final String DATE_PICKUP_MONTH_FIELD_PATH = "//select[@id='carhire-search-controls-date-pick-up-calendar__bpk_calendar_nav_select']";
    private static final String DATE_PICKUP_MONTH_LIST_PATH = "//select[@id='carhire-search-controls-date-pick-up-calendar__bpk_calendar_nav_select']";
    private static final String DATE_PICKUP_MONTH_PATH = "//select[@id='carhire-search-controls-date-pick-up-calendar__bpk_calendar_nav_select']/option[text()='October 2020']";
    private static final String DATA_DROP_OFF_PATH = "//input[@id='carhire-search-controls-date-pick-up']";
    private static final String SEARCH_BUTTON_PATH = "//input[@id='carhire-search-controls-search-button']";

    public SkyScannerCarSearchPage setUpPickUpLocation(String pickUpLocation) {
        waitForElementLocatedBy(PICKUP_LOCATION_PATH);
        clickOnElementBy(PICKUP_LOCATION_PATH);
        typeTextToElementBy(PICKUP_LOCATION_PATH, pickUpLocation);
        return this;
    }

    public SkyScannerCarSearchPage choiceReturnCarToADifferentLocation() {
        waitForAllElementsLocatedBy(RETURN_CAR_TO_A_DIFFERENT_LOCATION_CHECKBOX_PATH);
        clickOnElementBy(RETURN_CAR_TO_A_DIFFERENT_LOCATION_CHECKBOX_PATH);
        return this;
    }

    public SkyScannerCarSearchPage setUpDropOffLocation(String dropOffLocationLocation) {
        waitForElementLocatedBy(DROP_OFF_LOCATION_PATH);
        clickOnElementBy(DROP_OFF_LOCATION_PATH);
        typeTextToElementBy(DROP_OFF_LOCATION_PATH, dropOffLocationLocation);
        return this;
    }

    public SkyScannerCarSearchResultPage clickSearchButton() {
        waitForAllElementsLocatedBy(SEARCH_BUTTON_PATH);
        clickOnElementBy(SEARCH_BUTTON_PATH);
        return new SkyScannerCarSearchResultPage();
    }

    public String getTextFromCarHeader() {
        return getElementBy(CAR_HEADER_PATH).getText();
    }

    @Override
    public AbstractPage openPage() {
        return null;
    }
}
