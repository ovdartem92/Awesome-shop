package service;

import org.apache.commons.lang3.StringUtils;
import org.testng.util.Strings;

import static pages.AbstractScreen.*;

public class HotelSearchService {
    public enum Title {DECREASE, INCREASE}

    public enum Id {ROOMS, ADULTS, CHILDREN}

    private static final String DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR = "//input[@name='destination-autosuggest']";
    private static final String FIRST_ELEMENT_OF_DROPDOWN_LOCATOR = "//input[@aria-activedescendant='react-autowhatever-1--item-0']";
    private static final String GUESTS_AND_ROOM_INPUT_LOCATOR = "//input[@id='guests-rooms']";
    private static final String BUTTON_LOCATOR = "//button[@aria-controls='%s'][@title='%s']";
    private static final String QUANTITY_INPUT_LOCATOR = "//input[@id='%s']";
    private static final String DONE_BUTTON_LOCATOR = "//footer/button";
    private static final String DISABLED_PROPERTY = "disabled";

    public static void addDestination(String destination) {
        clickOnElement(DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR);
        typeTextToElement(DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR, destination);
        clickOnElement(FIRST_ELEMENT_OF_DROPDOWN_LOCATOR);
    }

    public static void clickAddItemButton(String locator) {
        clickOnElement(GUESTS_AND_ROOM_INPUT_LOCATOR);
        clickOnElement(locator);
        clickOnElement(DONE_BUTTON_LOCATOR);
    }

    public static void clickButtonUntilThenDisabled(String locator) {
        clickOnElement(GUESTS_AND_ROOM_INPUT_LOCATOR);
        while (Strings.isNullOrEmpty(getElement(locator).getAttribute(DISABLED_PROPERTY))) {
            clickOnElement(locator);
        }
        clickOnElement(DONE_BUTTON_LOCATOR);
    }

    public static int getQuantityItemInput(String locator) {
        clickOnElement(GUESTS_AND_ROOM_INPUT_LOCATOR);
        String quantity = getAttributeValueOnElement(locator, "value");
        clickOnElement(DONE_BUTTON_LOCATOR);
        return Integer.parseInt(quantity);
    }

    public static String getStringLocatorForFilterButton(Title title, Id id) {
        return String.format(BUTTON_LOCATOR, id.toString().toLowerCase(), StringUtils.capitalize(title.toString().toLowerCase()));
    }

    public static String getStringLocatorForFilterInput(Id id) {
        return String.format(QUANTITY_INPUT_LOCATOR, id.toString().toLowerCase());
    }
}
