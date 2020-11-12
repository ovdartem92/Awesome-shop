package service;

import static pages.AbstractScreen.*;

public class HotelSearchService {
    private static final String DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR = "//input[@name='destination-autosuggest']";
    private static final String FIRST_ELEMENT_OF_DROPDOWN_LOCATOR = "//input[@aria-activedescendant='react-autowhatever-1--item-0']";
    private static final String GUESTS_AND_ROOM_INPUT_LOCATOR = "//input[@id='guests-rooms']";
    private static final String DONE_BUTTON_LOCATOR = "//footer/button";

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

    public static int getQuantityItemInput(String locator) {
        clickOnElement(GUESTS_AND_ROOM_INPUT_LOCATOR);
        String quantity = getAttributeValueOnElement(locator, "value");
        clickOnElement(DONE_BUTTON_LOCATOR);
        return Integer.parseInt(quantity);
    }
}
