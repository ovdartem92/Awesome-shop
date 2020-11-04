package pages.net.skyscanner.elements;

import pages.AbstractPage;
import pages.net.skyscanner.hotels.HotelsSearchPage;
import utils.Constants;

public class HeaderScreen extends AbstractPage {
    private static final String CAR_HIRE_TAB_BUTTON_LOCATOR = String.format("%s,'Car')]", Constants.HEADER_TAB_PATH);
    private static final String FLIGHTS_TAB_BUTTON_LOCATOR = String.format("%s,'Flights')]", Constants.HEADER_TAB_PATH);
    private static final String HOTEL_TAB_BUTTON_LOCATOR = String.format("%s,'Hotels')]", Constants.HEADER_TAB_PATH);
    private static final String CULTURE_SETTING_BUTTON_LOCATOR = "//li[@id='culture-info']//button";

    public FlightsSearchPage clickFlightButton() {
        clickOnElement(FLIGHTS_TAB_BUTTON_LOCATOR);
        return new FlightsSearchPage();
    }

    public HotelsSearchPage clickHotelButton() {
        clickOnElement(HOTEL_TAB_BUTTON_LOCATOR);
        return new HotelsSearchPage();
    }

    public CarsSearchPage clickCarButton() {
        clickOnElement(CAR_HIRE_TAB_BUTTON_LOCATOR);
        return new CarsSearchPage();
    }

    public RegionalSettingsScreen clickRegionalSettingsButton() {
        clickOnElement(CULTURE_SETTING_BUTTON_LOCATOR);
        return new RegionalSettingsScreen();
    }
}
