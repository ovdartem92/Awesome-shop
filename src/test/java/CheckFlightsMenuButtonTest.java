import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.net.skyscanner.elements.HeaderScreen;
import pages.net.skyscanner.flights.FlightsSearchScreen;
import utils.Constants;

public class CheckFlightsMenuButtonTest extends BaseTest {
    FlightsSearchScreen flightsSearchScreen;

    @BeforeClass(description = "Click on flights button")
    public void navigateToFlightsSearchPage() {
        flightsSearchScreen = HeaderScreen.header.clickFlightButton();
    }

    @Test(description = "check that flights menu button leads to the flights search page")
    public void checkFlightsMenuButton() {
        Assert.assertEquals(flightsSearchScreen.getTextFromFlightsSearchButton(), Constants.TEXT_ON_FLIGHTS_SEARCH_PAGE,
                "flights menu button doesn't lead to the flights search page");
    }
}
