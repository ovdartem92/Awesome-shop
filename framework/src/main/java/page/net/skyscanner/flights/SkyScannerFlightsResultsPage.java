package page.net.skyscanner.flights;

import constants.Constants;
import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.AbstractPage;

import java.util.List;

import static service.ActionManager.*;
import static service.WaitManager.*;

public class SkyScannerFlightsResultsPage extends AbstractPage {
    private static final String CURRENCY_SETUP_BUTTON = "//li[@id='culture-info']//button";
    private static final String CURRENCY_SELECT = "//select[@id='culture-selector-currency']";
    private static final String FLIGHTS_SEARCH_RESULTS = "//p[@class='route-price']//span[contains(text(),'from')]";
    private static final String FLIGHTS_PRISES_SPAN = String.format("//span[text()='from ']/parent::p[contains(text(),'%s')]", Constants.EURO_SIGN);
    private static final String CURRENCY_OPTION = String.format("//option[contains(text(), '%s')]", Constants.EURO_SIGN);

    public SkyScannerFlightsResultsPage selectCurrency() {
        waitForAllElementsLocatedBy(FLIGHTS_SEARCH_RESULTS);
        clickOnElementBy(CURRENCY_SETUP_BUTTON);
        clickOnElementBy(CURRENCY_SELECT);
        clickOnElementBy(CURRENCY_OPTION);
        clickOnElementBy(CULTURE_SAVE_BUTTON_PATH);
        return this;
    }

    public List<WebElement> getCurrencies() {
        waitForAllElementsLocatedBy(FLIGHTS_PRISES_SPAN);
        return Browser.getDriver().findElements(By.xpath(FLIGHTS_PRISES_SPAN));
    }
}
