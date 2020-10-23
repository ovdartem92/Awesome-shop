package page.net.skyscanner.hotel.searchPage.structure;

import static service.ActionManager.clickOnElementBy;
import static service.ActionManager.getAttributeValueOnElementBy;

public class GuestsAndRoomsButtons {
    private static final String HOSTEL_CHECK_IN_INPUT_PATH = "//input[@id='checkin']";
    private static final String HOSTEL_CHECK_OUT_INPUT_PATH = "//input[@id='checkout']";
    private static final String GUESTS_AND_ROOM_INPUT_PATH = "//input[@id='guests-rooms']";
    private static final String QUANTITY_ROOMS_INPUT_PATH = "//input[@id='rooms']";
    private static final String INCREASE_ROOM_BUTTON_PATH = "//button[@aria-controls='rooms'][@title='Increase']";
    private static final String DECREASE_ROOM_BUTTON_PATH = "//button[@aria-controls='rooms'][@title='Decrease']";
    private static final String QUANTITY_ADULT_PEOPLE_INPUT_PATH = "//input[@id='adults']";
    private static final String INCREASE_ADULT_BUTTON_PATH = "//button[@aria-controls='adults'][@title='Increase']";
    private static final String DECREASE_ADULT_BUTTON_PATH = "//button[@aria-controls='adults'][@title='Decrease']";
    private static final String QUANTITY_CHILDREN_INPUT_PATH = "//input[@id='children']";
    private static final String INCREASE_CHILD_BUTTON_PATH = "//button[@aria-controls='children'][@title='Increase']";
    private static final String DECREASE_CHILD_BUTTON_PATH = "//button[@aria-controls='children'][@title='Decrease']";
    private static final String DONE_BUTTON_PATH = "//footer/button";

    public void increaseRoom() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_PATH);
        clickOnElementBy(INCREASE_ROOM_BUTTON_PATH);
        clickOnElementBy(DONE_BUTTON_PATH);
    }

    public void increaseRoom(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseRoom();
    }

    public void increaseAdult() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_PATH);
        clickOnElementBy(INCREASE_ADULT_BUTTON_PATH);
        clickOnElementBy(DONE_BUTTON_PATH);
    }

    public void increaseAdult(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseAdult();
    }

    public void increaseChild() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_PATH);
        clickOnElementBy(INCREASE_CHILD_BUTTON_PATH);
        clickOnElementBy(DONE_BUTTON_PATH);
    }

    public void increaseChild(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseChild();
    }

    public int getQuantityRooms() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_PATH);
        String quantity = getAttributeValueOnElementBy(QUANTITY_ROOMS_INPUT_PATH, "value");
        clickOnElementBy(DONE_BUTTON_PATH);
        return Integer.parseInt(quantity);
    }

    public int getQuantityAdultPeople() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_PATH);
        String quantity = getAttributeValueOnElementBy(QUANTITY_ADULT_PEOPLE_INPUT_PATH, "value");
        clickOnElementBy(DONE_BUTTON_PATH);
        return Integer.parseInt(quantity);
    }

    public int getQuantityChildren() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_PATH);
        String quantity = getAttributeValueOnElementBy(QUANTITY_CHILDREN_INPUT_PATH, "value");
        clickOnElementBy(DONE_BUTTON_PATH);
        return Integer.parseInt(quantity);
    }
}
