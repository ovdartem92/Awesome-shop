package page.net.skyscanner.hotel;

import org.openqa.selenium.Keys;
import page.AbstractPage;
import page.net.skyscanner.car.SkyScannerCarSearchPage;

import static service.ActionManager.*;

public class SkyScannerSearchHotelPage extends AbstractPage {
    private static final String DESTINATION_OR_HOSTEL_NAME_INPUT_PATH = "//input[@name='destination-autosuggest']";
    private static final String HOSTEL_CHECK_IN_INPUT_PATH = "//input[@id='checkin']";
    private static final String HOSTEL_CHECK_OUT_INPUT_PATH = "//input[@id='checkout']";
    private static final String GUESTS_AND_ROOM_INPUT_PATH = "//input[@id='guests-rooms']";
    private static final String SEARCH_HOTEL_BUTTON_PATH = "//button[contains(text(), 'Search hotels')]";
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
    private static final String SEARCH_HOTELS_BUTTON_PATH = "//button[@data-test-id='search-button']";
    private static final String CAR_HIRE_TAB_PATH = "//a[@id='carhi']";

    public SkyScannerSearchHotelPage addDestination(String destination) {
        clickOnElementBy(DESTINATION_OR_HOSTEL_NAME_INPUT_PATH);
        typeTextToElementBy(DESTINATION_OR_HOSTEL_NAME_INPUT_PATH, destination);
        return this;
    }

    public SkyScannerSearchHotelPage increaseRoom() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_PATH);
        clickOnElementBy(INCREASE_ROOM_BUTTON_PATH);
        clickOnElementBy(DONE_BUTTON_PATH);
        return this;
    }

    public SkyScannerCarSearchPage clickToCarHireTab() {
        clickOnElementBy(CAR_HIRE_TAB_PATH);
        return new SkyScannerCarSearchPage();
    }

    public SkyScannerSearchHotelPage increaseRoom(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseRoom();
        return this;
    }

    public SkyScannerSearchHotelPage increaseAdult() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_PATH);
        clickOnElementBy(INCREASE_ADULT_BUTTON_PATH);
        clickOnElementBy(DONE_BUTTON_PATH);
        return this;
    }

    public SkyScannerSearchHotelPage increaseAdult(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseAdult();
        return this;
    }

    public SkyScannerSearchHotelPage increaseChild() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_PATH);
        clickOnElementBy(INCREASE_CHILD_BUTTON_PATH);
        clickOnElementBy(DONE_BUTTON_PATH);
        return this;
    }

    public SkyScannerSearchHotelPage increaseChild(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseChild();
        return this;
    }

    public String getQuantityRooms() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_PATH);
        String quantity = getAttributeValueOnElementBy(QUANTITY_ROOMS_INPUT_PATH, "value");
        clickOnElementBy(DONE_BUTTON_PATH);
        return quantity;
    }

    public String getQuantityAdultPeople() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_PATH);
        String quantity = getAttributeValueOnElementBy(QUANTITY_ADULT_PEOPLE_INPUT_PATH, "value");
        clickOnElementBy(DONE_BUTTON_PATH);
        return quantity;
    }

    public String getQuantityChildren() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_PATH);
        String quantity = getAttributeValueOnElementBy(QUANTITY_CHILDREN_INPUT_PATH, "value");
        clickOnElementBy(DONE_BUTTON_PATH);
        return quantity;
    }

    public SkyScannerHotelResultPage clickToSearchHotelsButton() {
        typeKeysToElementBy(DESTINATION_OR_HOSTEL_NAME_INPUT_PATH, Keys.ENTER);
        clickOnElementBy(DESTINATION_OR_HOSTEL_NAME_INPUT_PATH);
        clickOnElementBy(SEARCH_HOTELS_BUTTON_PATH);
        return new SkyScannerHotelResultPage();
    }

    public String getTextFromHotelButton() {
        return getTextOnElementBy(SEARCH_HOTEL_BUTTON_PATH);
    }

    @Override
    public AbstractPage openPage() {
        return null;
    }
}
