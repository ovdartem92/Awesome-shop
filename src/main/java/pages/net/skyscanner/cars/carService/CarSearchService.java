package pages.net.skyscanner.cars.carService;

import driver.Browser;
import org.openqa.selenium.By;
import pages.AbstractScreen;
import pages.net.skyscanner.cars.CarsSearchResultsScreen;

public class CarSearchService extends AbstractScreen {
    private static final String PICKUP_LOCATION_LOCATOR = "//input[@id='carhire-search-controls-location-pick-up']";
    private static final String DROP_OFF_LOCATION_LOCATOR = "//input[@id='carhire-search-controls-location-drop-off']";
    private static final String RETURN_CAR_TO_A_DIFFERENT_LOCATION_CHECKBOX_LOCATOR = "//input[@id='carhire-search-controls-different-drop-off-docked']";
    private static final String SEARCH_BUTTON_LOCATOR = "//button[@id='carhire-search-controls-search-button']";

    public void setUpPickUpLocation(String pickUpLocation) {
        clickOnElement(PICKUP_LOCATION_LOCATOR);
        typeTextToElement(PICKUP_LOCATION_LOCATOR, pickUpLocation);
        clickOnElement(FIRST_ELEMENT_OF_DROPDOWN_LOCATOR);
    }

    public void choiceReturnCarToADifferentLocation() {
        clickOnElement(RETURN_CAR_TO_A_DIFFERENT_LOCATION_CHECKBOX_LOCATOR);
    }

    public void setUpDropOffLocation(String dropOffLocationLocation) {
        clickOnElement(DROP_OFF_LOCATION_LOCATOR);
        typeTextToElement(DROP_OFF_LOCATION_LOCATOR, dropOffLocationLocation);
        clickOnElement(FIRST_ELEMENT_OF_DROPDOWN_LOCATOR);
    }

    public CarsSearchResultsScreen clickSearchButton() {
        Browser.getDriver().findElement(By.xpath(SEARCH_BUTTON_LOCATOR)).click();
        return new CarsSearchResultsScreen();
    }
}
