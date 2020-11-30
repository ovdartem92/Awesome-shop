import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.net.skyscanner.flights.FlightsSearchScreen;
import service.CultureService;
import utils.Constants;

import java.util.List;

public class CheckChangeCurrencyTest extends BaseTest {
    private final String CURRENCY_VALUE = Constants.EURO_SIGN;
    private List<String> currencySigns;

    @BeforeClass(description = "change currency, input city from click flight search button, get text from prices")
    public void setUpForCheckCurrency() {
        new CultureService().changeCurrency(CURRENCY_VALUE);
        new FlightsSearchScreen().inputCityFrom(Constants.KIEV);
        currencySigns = new FlightsSearchScreen().clickFlightsSearchButton().getTextFromPrices();
    }

    @Test(description = "check that after changing currency prices are in correct currency value")
    public void checkChangeCurrency() {
        SoftAssert softAssert = new SoftAssert();
        for (String sign : currencySigns) {
            softAssert.assertTrue(sign.contains(CURRENCY_VALUE), "Prices are not displayed in the set currency value");
        }
        softAssert.assertAll();
    }
}
