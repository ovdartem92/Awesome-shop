import constants.Constants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.flights.SkyScannerFlightsResultsPage;

import java.util.ArrayList;

public class CheckCurrencyTest extends BaseTest {

    @Test
    public void checkCurrencyChangeTest() {
        
         new SkyScannerHomePage().startFlightsSearch()
                .getHeader().changeCurrency(Constants.EURO_SIGN);
        ArrayList<WebElement> prices = (ArrayList<WebElement>) new SkyScannerFlightsResultsPage().getCurrencies();
        for (WebElement price : prices) {
            Assert.assertTrue(price.getText().contains(Constants.EURO_SIGN),
                    "Not all prices are in selected currency");
        }
    }
}
