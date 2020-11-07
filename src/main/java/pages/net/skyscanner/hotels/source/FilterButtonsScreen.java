package pages.net.skyscanner.hotels.source;

import static pages.AbstractScreen.clickOnElement;
import static pages.AbstractScreen.getAttributeValueOnElement;

public class FilterButtonsScreen {
    private static final String HOSTEL_CHECK_IN_INPUT_LOCATOR = "//input[@id='checkin']";
    private static final String HOSTEL_CHECK_OUT_INPUT_LOCATOR = "//input[@id='checkout']";
    private static final String GUESTS_AND_ROOM_INPUT_LOCATOR = "//input[@id='guests-rooms']";
    private static final String QUANTITY_ROOMS_INPUT_LOCATOR = "//input[@id='rooms']";
    private static final String INCREASE_ROOM_BUTTON_LOCATOR = "//button[@aria-controls='rooms'][@title='Increase']";
    private static final String DECREASE_ROOM_BUTTON_LOCATOR= "//button[@aria-controls='rooms'][@title='Decrease']";
    private static final String QUANTITY_ADULT_PEOPLE_INPUT_LOCATOR = "//input[@id='adults']";
    private static final String INCREASE_ADULT_BUTTON_LOCATOR = "//button[@aria-controls='adults'][@title='Increase']";
    private static final String DECREASE_ADULT_BUTTON_LOCATOR = "//button[@aria-controls='adults'][@title='Decrease']";
    private static final String QUANTITY_CHILDREN_INPUT_LOCATOR = "//input[@id='children']";
    private static final String INCREASE_CHILD_BUTTON_LOCATOR = "//button[@aria-controls='children'][@title='Increase']";
    private static final String DECREASE_CHILD_BUTTON_LOCATOR = "//button[@aria-controls='children'][@title='Decrease']";
    private static final String DONE_BUTTON_LOCATOR = "//footer/button";

    private void clickAddItem(String locatorPath) {
        clickOnElement(GUESTS_AND_ROOM_INPUT_LOCATOR);
        clickOnElement(locatorPath);
        clickOnElement(DONE_BUTTON_LOCATOR);
    }

    private int getQuantityItemInput(String locatorPath) {
        clickOnElement(GUESTS_AND_ROOM_INPUT_LOCATOR);
        String quantity = getAttributeValueOnElement(locatorPath, "value");
        clickOnElement(DONE_BUTTON_LOCATOR);
        return Integer.parseInt(quantity);
    }

    public void clickAddRoomButton() {
        clickAddItem(INCREASE_ROOM_BUTTON_LOCATOR);
    }

    public void clickAddRoomButton(int quantity) {
        for (int i = 0; i < quantity; i++)
            clickAddRoomButton();
    }

    public void clickAddAdultButton() {
        clickAddItem(INCREASE_ADULT_BUTTON_LOCATOR);
    }

    public void clickAddAdultButton(int quantity) {
        for (int i = 0; i < quantity; i++)
            clickAddAdultButton();
    }

    public void clickAddChildButton() {
        clickAddItem(INCREASE_CHILD_BUTTON_LOCATOR);
    }

    public void clickAddChildButton(int quantity) {
        for (int i = 0; i < quantity; i++)
            clickAddChildButton();
    }

    public int getQuantityRoomsInput() {
        return getQuantityItemInput(QUANTITY_ROOMS_INPUT_LOCATOR);
    }

    public int getQuantityAdultPeopleInput() {
        return getQuantityItemInput(QUANTITY_ADULT_PEOPLE_INPUT_LOCATOR);
    }

    public int getQuantityChildrenInput() {
        return getQuantityItemInput(QUANTITY_CHILDREN_INPUT_LOCATOR);
    }
}
