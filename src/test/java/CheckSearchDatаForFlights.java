import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.net.skyscanner.flights.FlightsResultsScreen;
import pages.net.skyscanner.flights.FlightsSearchScreen;
import service.CalendarService;
import utils.Constants;

public class CheckSearchDatаForFlights {
    private String departDate;
    private String returnDate;
    private final String CITY_FROM = Constants.RIGA;
    private final String CITY_TO = Constants.KIEV;

    @BeforeClass(description = "input city from, input city to, set depart and return date, click search button")
    public void setUpSearchingData() {
        String DAY = Constants.DAY;
        FlightsSearchScreen flightsSearchScreen = new FlightsSearchScreen();
        flightsSearchScreen.inputCityFrom(CITY_FROM).inputCityTo(CITY_TO).clickDepartDayButton();
        CalendarService calendarService = new CalendarService();
        departDate = calendarService.getDateValue(DAY);
        flightsSearchScreen.clickReturnDayButton();
        returnDate = calendarService.getDateValue(DAY);
        flightsSearchScreen.clickFlightsSearchButton();
    }

    @Test(description = "check that city from, city to, depart date, return date in result page are the same with search page")
    public void checkThatAllSearchDataSetCorrectly() {
        FlightsResultsScreen flightsResultsScreen = new FlightsResultsScreen();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(flightsResultsScreen.getTextFromCitiesSpan(), String.format("%s - %s", CITY_FROM, CITY_TO), "cities was set incorrectly");
        softAssert.assertEquals(flightsResultsScreen.getAriaLabelDepartDate(), departDate, "depart date was set incorrectly");
        softAssert.assertEquals(flightsResultsScreen.getAriaLabelReturnDate(), returnDate, "return date was set incorrectly");
        softAssert.assertAll();
    }
}
