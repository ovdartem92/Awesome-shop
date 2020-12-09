package net.skyscanner.ta.product.pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.AbstractScreen;
import service.WaitManager;

public class CarsSearchPage extends AbstractScreen {
    private static final String PICK_UP = "pick-up";
    private static final String DROP_OFF = "drop-off";
    private static final String WHITE = "white";
    private static final String CHECKMARK = "checkmark";
    private static final String CAR_HEADLINE_LOCATOR = "//div[contains(@class,'controls-title')]";
    private static final String LOCATION_LOCATOR = "//input[@id='carhire-search-controls-location-%s']";
    private static final String RETURN_CAR_TO_A_DIFFERENT_LOCATION_CHECKBOX_LOCATOR =
            "//input[@id='carhire-search-controls-different-drop-off-docked']";
    private static final String SEARCH_BUTTON_LOCATOR = "//button[@id='carhire-search-controls-search-button']";
    private static final String DRIVER_AGE_SELECT_LOCATOR = "//select[@id='carhire-search-controls-age-selector']";
    private static final String AGE_CHECKBOX_LOCATOR =
            "//input[contains(@class, 'BpkCheckbox_bpk-checkbox__input-%s')][@name='age-between']";

    public String getTextFromCarHeadline() {
        return getTextOnElement(CAR_HEADLINE_LOCATOR);
    }

    public CarsSearchPage setUpPickUpLocation(String pickUpLocation) {
        clickOnElement(String.format(LOCATION_LOCATOR, PICK_UP));
        typeTextToElement(String.format(LOCATION_LOCATOR, PICK_UP), pickUpLocation);
        clickOnElement(DROPDOWN_LOCATOR);
        return this;
    }

    public CarsSearchPage choiceReturnCarToADifferentLocation() {
        clickOnElement(RETURN_CAR_TO_A_DIFFERENT_LOCATION_CHECKBOX_LOCATOR);
        return this;
    }

    public CarsSearchPage setUpDropOffLocation(String dropOffLocationLocation) {
        clickOnElement(String.format(LOCATION_LOCATOR, DROP_OFF));
        typeTextToElement(String.format(LOCATION_LOCATOR, DROP_OFF), dropOffLocationLocation);
        clickOnElement(DROPDOWN_LOCATOR);
        return this;
    }

    public CarsSearchResultsPage clickSearchButton() {
        Browser.getDriver().findElement(By.xpath(SEARCH_BUTTON_LOCATOR)).click();
        return new CarsSearchResultsPage();
    }

    public CarsSearchPage unSetAgeCheckbox() {
        if (!WaitManager.isElementVisible(String.format(AGE_CHECKBOX_LOCATOR, CHECKMARK),
                Browser.SHORT_TIMEOUT_SECONDS)) {
            clickOnElement(String.format(AGE_CHECKBOX_LOCATOR, WHITE));
        }
        clickOnElement(String.format(AGE_CHECKBOX_LOCATOR, CHECKMARK));
        return this;
    }

    public CarsSearchPage setDriverAge(String age) {
        clickOnElement(DRIVER_AGE_SELECT_LOCATOR);
        Select ages = new Select(getElement(DRIVER_AGE_SELECT_LOCATOR));
        ages.selectByVisibleText(age);
        return this;
    }
}
