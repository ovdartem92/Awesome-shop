package pages.net.skyscanner.cars;

import driver.Browser;
import org.openqa.selenium.By;
import pages.AbstractScreen;

public class CarsSearchScreen extends AbstractScreen {
    private static final String CAR_HEADLINE_LOCATOR = "//button[contains(@class,'Search')]";
    private static final String PICKUP_LOCATION_LOCATOR = "//input[@id='carhire-search-controls-location-pick-up']";
    private static final String DROP_OFF_LOCATION_LOCATOR = "//input[@id='carhire-search-controls-location-drop-off']";
    private static final String RETURN_CAR_TO_A_DIFFERENT_LOCATION_CHECKBOX_LOCATOR = "//input[@id='carhire-search-controls-different-drop-off-docked']";
    private static final String FIRST_ELEMENT_OF_DROPDOWN_LOCATOR = "//input[@aria-activedescendant='react-autowhatever-1--item-0']";

    public String getTextFromCarHeadline() {
        return getTextOnElement(CAR_HEADLINE_LOCATOR);
    }

    public CarsSearchScreen setUpPickUpLocation(String pickUpLocation) {
        clickOnElement(PICKUP_LOCATION_LOCATOR);
        typeTextToElement(PICKUP_LOCATION_LOCATOR, pickUpLocation);
        clickOnElement(FIRST_ELEMENT_OF_DROPDOWN_LOCATOR);
        return this;
    }

    public CarsSearchScreen choiceReturnCarToADifferentLocation() {
        clickOnElement(RETURN_CAR_TO_A_DIFFERENT_LOCATION_CHECKBOX_LOCATOR);
        return this;
    }

    public CarsSearchScreen setUpDropOffLocation(String dropOffLocationLocation) {
        clickOnElement(DROP_OFF_LOCATION_LOCATOR);
        typeTextToElement(DROP_OFF_LOCATION_LOCATOR, dropOffLocationLocation);
        clickOnElement(FIRST_ELEMENT_OF_DROPDOWN_LOCATOR);
        return this;
    }

    public CarsSearchResultsScreen clickSearchButton() {
        Browser.getDriver().findElement(By.xpath(CAR_HEADLINE_LOCATOR)).click();
        return new CarsSearchResultsScreen();
    }
}