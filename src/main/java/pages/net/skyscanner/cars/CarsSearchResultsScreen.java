package pages.net.skyscanner.cars;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractScreen;
import pages.net.skyscanner.elements.DownloadScreen;

import java.util.List;

public class CarsSearchResultsScreen extends AbstractScreen {
    private static final String CAR_SEARCH_SUMMARY_ROUTE_LOCATOR = "//div[@id='carhire-search-summary-route']";
    private static final String CAR_GROUP_PANEL_ELEMENT_LOCATOR = "//div[contains(@class,'CarGroupPanel_clickable')]";
    private static final String CAR_HIRE_DEAL_BUTTON_LOCATOR = "//button[@id='carhire-deal-button']";

    public String getInfoAboutPickUpLocationFromSummary() {
        String[] array = getTextOnElement(CAR_SEARCH_SUMMARY_ROUTE_LOCATOR).split(" - ");
        return array[0];
    }

    public String getInfoAboutDropOffLocationFromSummary() {
        String[] array = getTextOnElement(CAR_SEARCH_SUMMARY_ROUTE_LOCATOR).split(" - ");
        return array[1];
    }

    public CarsSearchResultsScreen clickOnResultOfSearching(int numberOfResultElement) {
        List<WebElement> carsList = getElements(CAR_GROUP_PANEL_ELEMENT_LOCATOR);
        carsList.get(numberOfResultElement).click();
        return this;
    }

    public VipCarsChooseYourCarScreen clickOnSelectButton() {
        clickOnElement(CAR_HIRE_DEAL_BUTTON_LOCATOR);
        return new VipCarsChooseYourCarScreen();
    }
}
