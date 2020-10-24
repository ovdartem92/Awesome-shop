package page.net.skyscanner.flights;

import constants.Constants;
import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.AbstractPage;

import java.util.List;

import static service.WaitManager.*;

public class SkyScannerFlightsResultsPage extends AbstractPage {
    private static final String FLIGHTS_PRISES_SPAN = String.format("//span[text()='from ']/parent::p[contains(text(),'%s')]", Constants.EURO_SIGN);

    public List<WebElement> getCurrencies() {
        waitForAllElementsLocatedBy(FLIGHTS_PRISES_SPAN);
        return Browser.getDriver().findElements(By.xpath(FLIGHTS_PRISES_SPAN));
    }
}
