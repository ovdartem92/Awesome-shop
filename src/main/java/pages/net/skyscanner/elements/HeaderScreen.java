package pages.net.skyscanner.elements;

import pages.AbstractScreen;
import pages.net.skyscanner.cars.CarsSearchScreen;

public class HeaderScreen extends AbstractScreen {
    private static final String FLIGHTS_TAB_TEXT = "Flights";
    private static final String HOTELS_TAB_TEXT = "Hotels";
    private static final String CAR_TAB_TEXT = "Car";
    private static final String HEADER_TAB_LOCATOR = ("//nav[@id='PrimaryNav']//span[contains(text(),'%s')]");
    private static final String CAR_HIRE_TAB_BUTTON_LOCATOR = String.format(HEADER_TAB_LOCATOR, CAR_TAB_TEXT);
    private static final String FLIGHTS_TAB_BUTTON_LOCATOR = String.format(HEADER_TAB_LOCATOR, FLIGHTS_TAB_TEXT);
    private static final String HOTEL_TAB_BUTTON_LOCATOR = String.format(HEADER_TAB_LOCATOR, HOTELS_TAB_TEXT);
    private static final String CULTURE_SETTING_BUTTON_LOCATOR = "//li[@id='culture-info']//button";

//    public FlightsSearchScreen clickFlightButton() {
//        clickOnElement(FLIGHTS_TAB_BUTTON_LOCATOR);
//        return new FlightsSearchScreen();
//    }
//
//    public HotelsSearchScreen clickHotelButton() {
//        clickOnElement(HOTEL_TAB_BUTTON_LOCATOR);
//        return new HotelsSearchScreen();
//    }

    public CarsSearchScreen clickCarButton() {
        clickOnElement(CAR_HIRE_TAB_BUTTON_LOCATOR);
        return new CarsSearchScreen();
    }

    public RegionalSettingsScreen clickRegionalSettingsButton() {
        clickOnElement(CULTURE_SETTING_BUTTON_LOCATOR);
        return new RegionalSettingsScreen();
    }
}
