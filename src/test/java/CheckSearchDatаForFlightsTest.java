import model.Flights;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.net.skyscanner.flights.FlightsResultsScreen;
import service.SearchFlightsService;
import utils.Constants;

public class CheckSearchDatаForFlightsTest extends BaseTest {
    private Flights flights = new Flights(Constants.KIEV, Constants.RIGA, Constants.DAY);

    @BeforeClass(description = "input city from, input city to, set depart and return date, click search button")
    public void setUpSearchingData() {
        new SearchFlightsService().setFlightsSearchData(flights);
    }

    @Test(description = "check that city from, city to, depart date, return date in result page are the same with search page")
    public void checkThatAllSearchDataSetCorrectly() {
        FlightsResultsScreen flightsResultsScreen = new FlightsResultsScreen();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(flightsResultsScreen.getTextFromCitiesSpan().contains(flights.getCityFrom()), "city from was set incorrectly");
        softAssert.assertTrue(flightsResultsScreen.getTextFromCitiesSpan().contains(flights.getCityTo()), "city to was set incorrectly");
        softAssert.assertEquals(flightsResultsScreen.getAriaLabelDepartDate(), flights.getDepartDay(), "depart date was set incorrectly");
        softAssert.assertEquals(flightsResultsScreen.getAriaLabelReturnDate(), flights.getReturnDay(), "return date was set incorrectly");
        softAssert.assertAll();
    }
}
