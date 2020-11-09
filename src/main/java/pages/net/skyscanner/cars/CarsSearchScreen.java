package pages.net.skyscanner.cars;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.AbstractScreen;

public class CarsSearchScreen extends AbstractScreen {
    private static final String CAR_HEADLINE_LOCATOR = "//button[contains(@class,'Search')]";
    private static final String PICKUP_LOCATION_LOCATOR = "//input[@id='carhire-search-controls-location-pick-up']";
    private static final String FIRST_ELEMENT_OF_DROPDOWN_LOCATOR = "//input[@aria-activedescendant='react-autowhatever-1--item-0']";
    private static final String DRIVER_AGE_CHECKBOX_LOCATOR = "//input[@id='carhire-search-controls-age-between']";
    private static final String DRIVER_AGE_SELECT_LOCATOR = "//select[@id='carhire-search-controls-age-selector']";

    public String getTextFromCarHeadline() {
        return getTextOnElement(CAR_HEADLINE_LOCATOR);
    }

    public CarsSearchScreen setUpPickUpLocation(String pickUpLocation) {
        clickOnElement(PICKUP_LOCATION_LOCATOR);
        typeTextToElement(PICKUP_LOCATION_LOCATOR, pickUpLocation);
        clickOnElement(FIRST_ELEMENT_OF_DROPDOWN_LOCATOR);
        return this;
    }

    public CarsSearchScreen setAgeCheckbox() {
        clickOnElement(DRIVER_AGE_CHECKBOX_LOCATOR);
        return this;
    }

    public CarsSearchScreen setDriverAge(String age) {
        clickOnElement(DRIVER_AGE_SELECT_LOCATOR);
        Select ages = new Select(getElement(DRIVER_AGE_SELECT_LOCATOR));
        ages.selectByVisibleText(age);
        return this;
    }

    public CarsSearchResultsScreen clickSearchButton() {
        Browser.getDriver().findElement(By.xpath(CAR_HEADLINE_LOCATOR)).click();
        return new CarsSearchResultsScreen();
    }
}
