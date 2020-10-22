import constants.Currency;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.net.skyscanner.SkyScannerHomePage;

import java.util.ArrayList;

public class ChangeCurrencyTest extends BaseTest {
    @Test
    public void checkCurrencyChangeTest() {
        ArrayList<WebElement> prices = (ArrayList<WebElement>) new SkyScannerHomePage().startFlightsSearch().selectCurrency().getCurrencies();
        for (WebElement price : prices) {
            Assert.assertTrue(price.getText().contains(Currency.DOLLAR_SIGN),
                    "Not all prices are in selected currency");
        }
    }
}
