import model.Flights;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.net.skyscanner.flights.FlightsResultsScreen;
import service.SearchFlightsService;
import utils.Constants;

public class CheckSearchDatаForFlights extends BaseTest {
    private Flights flights = new Flights(Constants.KIEV, Constants.RIGA, Constants.DAY);
    private String departDate;
    private String returnDate;
    private FlightsResultsScreen flightsResultsScreen;

    @BeforeClass(description = "input city from, input city to, set depart and return date, click search button")
    public void setUpSearchingData() {
        flightsResultsScreen = new SearchFlightsService().setFlightsSearchData(flights);
        departDate = flights.getDepartDay();
        returnDate=flights.getReturnDay();
    }

    @Test(description = "check that city from, city to, depart date, return date in result page are the same with search page")
    public void checkThatAllSearchDataSetCorrectly() {
       SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(flightsResultsScreen.getTextFromCitiesSpan(), String.format("%s - %s", flights.getCityFrom(), flights.getCityTo()), "cities was set incorrectly");
        softAssert.assertEquals(flightsResultsScreen.getAriaLabelDepartDate(), departDate, "depart date was set incorrectly");
        softAssert.assertEquals(flightsResultsScreen.getAriaLabelReturnDate(), returnDate, "return date was set incorrectly");
        softAssert.assertAll();
    }
}
