package page.net.skyscanner.car;

import org.openqa.selenium.WebElement;
import page.AbstractPage;

import java.util.List;

import static service.ActionManager.*;
import static service.WaitManager.*;

public class SkyScannerCarSearchResultPage extends AbstractPage {
    private static final String CAR_SEARCH_SUMMARY_ROUTE_PATH = "//div[@id='carhire-search-summary-route']";
    private static final String CAR_HIRE_DEAL_BUTTON_PATH = "//button[@id='carhire-deal-button']";
    private static final String CAR_GROUP_PANEL = "//section[@id='car-group-panel']";

    public String getInfoAboutPickUpLocationFromSummary() {
        String[] array = getTextOnElementBy(CAR_SEARCH_SUMMARY_ROUTE_PATH).split(" - ");
        return array[0];
    }

    public String getInfoAboutDropOffLocationFromSummary() {
        String[] array = getTextOnElementBy(CAR_SEARCH_SUMMARY_ROUTE_PATH).split(" - ");
        return array[1];
    }

    public SkyScannerCarSearchResultPage clickOnResultOfSearching(int numberOfResultList) {
        List<WebElement> carsList;
        carsList = getElementsBy(CAR_GROUP_PANEL);
        carsList.get(numberOfResultList).click();
        return this;
    }

    public VipCarsChooseYourCarPage clickOnSelectButton() {
        waitForElementLocatedBy(CAR_HIRE_DEAL_BUTTON_PATH);
        clickOnElementBy(CAR_HIRE_DEAL_BUTTON_PATH);
        return new VipCarsChooseYourCarPage();
    }
}
