import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.flights.FlightsSearchScreen;
import utils.Constants;

public class CheckFlightsMenuButtonTest extends BaseTest {
    private final String TEXT_ON_FLIGHTS_SEARCH_PAGE = "Search flights";

    @Test(description = "check that flights menu button leads to the flights search page")
    public void checkFlightsMenuButton() {
        FlightsSearchScreen.changeLanguage(Constants.ENGLISH_LANGUAGE);
        Assert.assertEquals(FlightsSearchScreen.header.clickFlightButton()
                        .getTextFromFlightsSearchButton(), TEXT_ON_FLIGHTS_SEARCH_PAGE,
                "flights menu button doesn't lead to the flights search page");
    }
}
