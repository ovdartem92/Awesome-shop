package net.skyscanner.ta.product.pages;

import pages.AbstractScreen;
import pages.net.skyscanner.elements.CalendarScreen;

public class FlightsSearchScreen extends AbstractScreen {
    private static final String FLIGHTS_SEARCH_BUTTON_LOCATOR = "//button[@type='submit']";
    private static final String CITY_FROM_INPUT_LOCATOR = "//input[@id='fsc-origin-search']";
    private static final String CITY_TO_INPUT_LOCATOR = "//input[@id='fsc-destination-search']";
    private static final String DEPART_DAY_BUTTON_LOCATOR = "//button[@id='depart-fsc-datepicker-button']";
    private static final String RETURN_DAY_BUTTON_LOCATOR = "//button[@id='return-fsc-datepicker-button']";

    public String getTextFromFlightsSearchButton() {
        return getTextOnElement(FLIGHTS_SEARCH_BUTTON_LOCATOR);
    }

    public FlightsResultsPage clickFlightsSearchButton() {
        clickOnElement(FLIGHTS_SEARCH_BUTTON_LOCATOR);
        return new FlightsResultsPage();
    }

    public FlightsSearchScreen inputCityFrom(String city) {
        typeTextToElement(CITY_FROM_INPUT_LOCATOR, city);
        return this;
    }

    public FlightsSearchScreen inputCityTo(String city) {
        clickOnElement(CITY_TO_INPUT_LOCATOR);
        typeTextToElement(CITY_TO_INPUT_LOCATOR, city);
        return this;
    }

    public CalendarScreen clickDepartDayButton() {
        clickOnElement(DEPART_DAY_BUTTON_LOCATOR);
        return new CalendarScreen();
    }

    public CalendarScreen clickReturnDayButton() {
        clickOnElement(RETURN_DAY_BUTTON_LOCATOR);
        return new CalendarScreen();
    }
}
