package service;

import static pages.AbstractScreen.clickOnElement;
import static pages.AbstractScreen.getAttributeValueOnElement;

public class HotelService {
    private static final String GUESTS_AND_ROOM_INPUT_LOCATOR = "//input[@id='guests-rooms']";
    private static final String DONE_BUTTON_LOCATOR = "//footer/button";

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
