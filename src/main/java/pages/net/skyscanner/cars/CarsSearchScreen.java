package pages.net.skyscanner.cars;

import driver.Browser;
import org.openqa.selenium.By;
import pages.AbstractScreen;

public class CarsSearchScreen extends AbstractScreen {
    private static final String CAR_HEADLINE_LOCATOR = "//button[contains(@class,'Search')]";
    private static final String PICKUP_LOCATION_LOCATOR = "//input[@id='carhire-search-controls-location-pick-up']";
    private static final String DROP_OFF_LOCATION_LOCATOR = "//input[@id='carhire-search-controls-location-drop-off']";
    private static final String RETURN_CAR_TO_A_DIFFERENT_LOCATION_CHECKBOX_LOCATOR = "//input[@id='carhire-search-controls-different-drop-off-docked']";

    public String getTextFromCarHeadline() {
        return getTextOnElement(CAR_HEADLINE_LOCATOR);
    }

    public CarsSearchScreen setUpPickUpLocation(String pickUpLocation) {
        clickOnElement(PICKUP_LOCATION_LOCATOR);
        typeInFieldWithDelay(PICKUP_LOCATION_LOCATOR, pickUpLocation);
        return this;
    }

    public CarsSearchScreen choiceReturnCarToADifferentLocation() {
        clickOnElement(RETURN_CAR_TO_A_DIFFERENT_LOCATION_CHECKBOX_LOCATOR);
        return this;
    }

    public CarsSearchScreen setUpDropOffLocation(String dropOffLocationLocation) {
        clickOnElement(DROP_OFF_LOCATION_LOCATOR);
        typeInFieldWithDelay(DROP_OFF_LOCATION_LOCATOR, dropOffLocationLocation);
        return this;
    }

    public CarsSearchResultsScreen clickSearchButton() {
        Browser.getDriver().findElement(By.xpath(CAR_HEADLINE_LOCATOR)).click();
        return new CarsSearchResultsScreen();
    }
}