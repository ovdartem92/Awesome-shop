package pages.net.skyscanner.hotels.source;

import pages.AbstractScreen;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class FilterButtonsScreen extends AbstractScreen {
    public enum Title {DECREASE, INCREASE}

    public enum Id {ROOMS, ADULTS, CHILDREN}

    private static final String DECREASE_TITLE = "Decrease";
    private static final String INCREASE_TITLE = "Increase";
    private static final String ROOMS_ID = "rooms";
    private static final String ADULTS_ID = "adults";
    private static final String CHILDREN_ID = "children";
    private static final String GUESTS_AND_ROOM_SECTION = "//div[starts-with(@class, 'BpkSectionListItem')]";
    private static final String BUTTON_LOCATOR = "//button[@aria-controls='%s'][@title='%s']";

    private static final String HOSTEL_CHECK_IN_INPUT_LOCATOR = "//input[@id='checkin']";
    private static final String HOSTEL_CHECK_OUT_INPUT_LOCATOR = "//input[@id='checkout']";
    private static final String GUESTS_AND_ROOM_INPUT_LOCATOR = "//input[@id='guests-rooms']";
    private static final String QUANTITY_ROOMS_INPUT_LOCATOR = "//input[@id='rooms']";
    private static final String INCREASE_ROOM_BUTTON_LOCATOR = "//button[@aria-controls='rooms'][@title='Increase']";
    private static final String DECREASE_ROOM_BUTTON_LOCATOR = "//button[@aria-controls='rooms'][@title='Decrease']";
    private static final String QUANTITY_ADULT_PEOPLE_INPUT_LOCATOR = "//input[@id='adults']";
    private static final String INCREASE_ADULT_BUTTON_LOCATOR = "//button[@aria-controls='adults'][@title='Increase']";
    private static final String DECREASE_ADULT_BUTTON_LOCATOR = "//button[@aria-controls='adults'][@title='Decrease']";
    private static final String QUANTITY_CHILDREN_INPUT_LOCATOR = "//input[@id='children']";
    private static final String INCREASE_CHILD_BUTTON_LOCATOR = "//button[@aria-controls='children'][@title='Increase']";
    private static final String DECREASE_CHILD_BUTTON_LOCATOR = "//button[@aria-controls='children'][@title='Decrease']";
    private static final String DONE_BUTTON_LOCATOR = "//footer/button";

    private void clickAddItemButton(String locator) {
        clickOnElement(GUESTS_AND_ROOM_INPUT_LOCATOR);
        clickOnElement(locator);
        clickOnElement(DONE_BUTTON_LOCATOR);
    }

    private int getQuantityItemInput(String locator) {
        clickOnElement(GUESTS_AND_ROOM_INPUT_LOCATOR);
        String quantity = getAttributeValueOnElement(locator, "value");
        clickOnElement(DONE_BUTTON_LOCATOR);
        return Integer.parseInt(quantity);
    }

    public void clickButton(Title title, Id id) {
        String locator = String.format(BUTTON_LOCATOR, id.toString().toLowerCase(), capitalize(title.toString().toLowerCase()));
        clickAddItemButton(locator);
    }

    public void clickButton(Title title, Id id, int quantity) {
        for (int i = 0; i < quantity; i++)
            clickButton(title, id);
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
