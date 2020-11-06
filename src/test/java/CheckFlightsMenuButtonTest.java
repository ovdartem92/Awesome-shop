import org.testng.Assert;
import org.testng.annotations.Test;
import pages.net.skyscanner.flights.FlightsSearchPage;
import utils.Constants;

public class CheckFlightsMenuButtonTest extends BaseTest {

    @Test(description = "check that flights menu button leads to the flights search page")
    public void checkFlightsMenuButton() {
        FlightsSearchPage.changeLanguage(Constants.ENGLISH_LANGUAGE);
        Assert.assertEquals(FlightsSearchPage.header.clickFlightButton()
                        .getTextFromFlightsSearchButton(), "Search flights",
                "flights menu button doesn't lead to the flights search page");
    }
}
