package service;

import model.Flights;
import pages.net.skyscanner.flights.FlightsResultsScreen;
import pages.net.skyscanner.flights.FlightsSearchScreen;

public class SearchFlightsService {
    private FlightsSearchScreen flightsSearchScreen = new FlightsSearchScreen();
    private CalendarService calendarService = new CalendarService();

    public FlightsResultsScreen setFlightsSearchData(Flights flights) {
        flightsSearchScreen.inputCityTo(flights.getCityTo()).inputCityFrom(flights.getCityFrom()).clickDepartDayButton();
        flights.setDepartDay(calendarService.getDateValue(flights.getDate()));
        flightsSearchScreen.clickReturnDayButton();
        flights.setReturnDay(calendarService.getDateValue(flights.getDate()));
        return flightsSearchScreen.clickFlightsSearchButton();
    }
}
