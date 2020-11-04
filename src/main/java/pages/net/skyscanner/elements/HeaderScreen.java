package pages.net.skyscanner.elements;

import pages.AbstractPage;
import pages.net.skyscanner.cars.CarsSearchPage;
import pages.net.skyscanner.flights.FlightsSearchPage;
import pages.net.skyscanner.hotels.HotelsSearchPage;

public class HeaderScreen extends AbstractPage {
    public static final String HEADER_TAB_PATH = "//nav[@id='PrimaryNav']//span[contains(text()";
    private static final String CAR_HIRE_TAB_BUTTON_LOCATOR = String.format("%s,'Car')]", HEADER_TAB_PATH);
    private static final String FLIGHTS_TAB_BUTTON_LOCATOR = String.format("%s,'Flights')]", HEADER_TAB_PATH);
    private static final String HOTEL_TAB_BUTTON_LOCATOR = String.format("%s,'Hotels')]", HEADER_TAB_PATH);
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
