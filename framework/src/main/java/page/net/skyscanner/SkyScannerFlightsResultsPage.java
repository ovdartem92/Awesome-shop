package page.net.skyscanner;

import constants.Currency;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.AbstractPage;
import java.util.List;
import static service.ActionManager.*;
import static service.WaitManager.*;

public class SkyScannerFlightsResultsPage extends AbstractPage {

    private static final String CURRENCY_SETUP_BUTTON = "//li[@id='culture-info']//button";
    private static final String CURRENCY_SELECT = "//select[@id='culture-selector-currency']";
    private static final String SAVE_CURRENCY_SETUP_BUTTON = "//button[@id='culture-selector-save']";
    private static final String FLIGHTS_SEARCH_RESULTS = "//p[@class='route-price']//span[text()='from ']";
    private static final String FLIGHTS_PRISES_SPAN = String.format("//span[text()='from ']/parent::p[contains(text(),'%s')]", Currency.DOLLAR_SIGN);
    private static final String CURRENCY_OPTION = String.format("//option[text()='%s']", Currency.USD);

    public SkyScannerFlightsResultsPage selectCurrency() {
        waitForAllElementsLocatedBy(FLIGHTS_SEARCH_RESULTS);
        clickOnElementBy(CURRENCY_SETUP_BUTTON);
        clickOnElementBy(CURRENCY_SELECT);
        clickOnElementBy(CURRENCY_OPTION);
        clickOnElementBy(SAVE_CURRENCY_SETUP_BUTTON);
        return this;
    }

    public List<WebElement> getCurrencies() {
        waitForAllElementsLocatedBy(FLIGHTS_PRISES_SPAN);
        return driver.findElements(By.xpath(FLIGHTS_PRISES_SPAN));
    }

    @Override
    public AbstractPage openPage() {
        return null;
    }
}
