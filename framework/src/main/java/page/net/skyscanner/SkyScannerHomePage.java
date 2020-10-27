package page.net.skyscanner;

import page.AbstractPage;
import page.net.skyscanner.flights.SkyScannerFlightsResultsPage;
import page.net.skyscanner.help.SkyScannerHelpPage;
import service.TestDataReader;

import static service.ActionManager.*;
import static service.WaitManager.*;

public class SkyScannerHomePage extends AbstractPage {
    public static final String SEARCH_FLIGHTS_BUTTON_PATH = "//button[text()='Search flights']";
    private static final String HELP_LINK_PATH = "//a[(@id='ss-footer-links-faq')]";

    public SkyScannerFlightsResultsPage startFlightsSearch() {
        clickOnElementBy(SEARCH_FLIGHTS_BUTTON_PATH);
        return new SkyScannerFlightsResultsPage();
    }

    public String getTextFromFlightsButton() {
        return getTextOnElementBy(SEARCH_FLIGHTS_BUTTON_PATH);
    }

    public SkyScannerHelpPage clickToHelpLink(){
        waitForElementLocatedBy(HELP_LINK_PATH);
        scrollToElement(HELP_LINK_PATH);
        clickOnElementBy(HELP_LINK_PATH);
        return new SkyScannerHelpPage();
    }
}
