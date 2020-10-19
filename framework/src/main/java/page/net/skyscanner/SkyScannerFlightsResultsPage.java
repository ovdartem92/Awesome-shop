package page.net.skyscanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import page.AbstractPage;
import service.TestDataReader;
import java.util.List;



public class SkyScannerFlightsResultsPage extends AbstractPage {

    private static final By CURRENCY_SETUP_BUTTON = By.xpath("//li[@id='culture-info']//button");
    private static final By CURRENCY_SELECT = By.xpath("//select[@id='culture-selector-currency']");
    private static final By SAVE_CURRENCY_SETUP_BUTTON = By.xpath("//button[@id='culture-selector-save']");
    private static final By FLIGHTS_SEARCH_RESULTS = By.xpath("//p[@class='route-price']//span[text()='from ']");
    private static final By FLIGHTS_PRISES_SPAN = By.xpath(String.format("//span[text()='from ']/parent::p[contains(text(),'%s')]",
            TestDataReader.getTestData("testData.currency").replaceAll(".*[a-zA-Z]\\s\\-\\s", "")));

//    public SkyScannerFlightsResultsPage selectCurrency() {
//        waitForAllElementsLocatedBy(driver, FLIGHTS_SEARCH_RESULTS);
//        driver.findElement(CURRENCY_SETUP_BUTTON).click();
//        waitForElementLocatedBy(driver, CURRENCY_SELECT);
//        driver.findElement(CURRENCY_SELECT).click();
//        Select select = new Select(driver.findElement(CURRENCY_SELECT));
//        select.selectByVisibleText(TestDataReader.getTestData("testData.currency"));
//        waitForElementLocatedBy(driver, SAVE_CURRENCY_SETUP_BUTTON);
//        driver.findElement(SAVE_CURRENCY_SETUP_BUTTON).click();
//        return this;
//    }
//
//    public List<WebElement> getCurrencies() {
//        waitForAllElementsLocatedBy(driver, FLIGHTS_PRISES_SPAN);
//        return driver.findElements(FLIGHTS_PRISES_SPAN);
//    }
}
