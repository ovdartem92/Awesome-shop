package net.skyscanner.ta.product.services;

import model.Flights;
import pages.net.skyscanner.flights.FlightsSearchScreen;

/**
 * This is a service class which set city from, city to, depart day, return day for flights.
 */
public class SearchFlightsService {

    /**
     * The method set city from, city to, depart day, return day for flights.
     *
     * @param flights is required for get value of cities and dates.
     */
    public void setFlightsSearchData(Flights flights) {
        FlightsSearchScreen flightsSearchScreen = new FlightsSearchScreen();
        CalendarService calendarService = new CalendarService();
        flightsSearchScreen.inputCityTo(flights.getCityTo()).inputCityFrom(flights.getCityFrom()).clickDepartDayButton();
        flights.setDepartDay(calendarService.getDateValue(flights.getDate()));
        flightsSearchScreen.clickReturnDayButton();
        flights.setReturnDay(calendarService.getDateValue(flights.getDate()));
        flightsSearchScreen.clickFlightsSearchButton();
    }
}
