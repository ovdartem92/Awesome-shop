package page;

import driver.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page.net.skyscanner.SkyScannerHomePage;
import page.net.skyscanner.car.SkyScannerCarSearchPage;
import page.net.skyscanner.hotel.SkyScannerSearchHotelPage;

import static service.ActionManager.clickOnElementBy;

public abstract class AbstractPage {
    protected static final String LANGUAGE_PATH = "//li[@id='culture-info']//div/span";
    protected static final String LANGUAGES_SELECT_PATH = "//select[@name='locale']";
    protected static final String ENGLISH_LANGUAGE_OPTION_PATH = "//select[@name='locale']//option[@value='en-US']";
    protected static final String CULTURE_SAVE_BUTTON_PATH = "//button[@id='culture-selector-save']";
    protected static final String HOTEL_TAB_PATH = "//nav[@id='PrimaryNav']//span[contains(text(), 'Hotels')]";
    protected static final String CAR_HIRE_TAB_PATH = "//a[@id='carhi']";
    protected static final String SEARCH_FLIGHTS_BUTTON_PATH = "//button[text()='Search flights']";
    protected static final String FLIGHTS_TAB_PATH = "//nav[@id='PrimaryNav']//span[contains(text(), 'Flights')]";
    public static Logger logger = LogManager.getRootLogger();

    public SkyScannerSearchHotelPage clickToHostelsTab() {
        clickOnElementBy(HOTEL_TAB_PATH);
        return new SkyScannerSearchHotelPage();
    }

    public SkyScannerHomePage clickToFlightsTab() {
        clickOnElementBy(FLIGHTS_TAB_PATH);
        return new SkyScannerHomePage();
    }

    public SkyScannerCarSearchPage clickToCarHireTab() {
        clickOnElementBy(CAR_HIRE_TAB_PATH);
        return new SkyScannerCarSearchPage();
    }
}
