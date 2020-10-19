package page.net.skyscanner.hotel;

import org.openqa.selenium.By;
import page.AbstractPage;
import page.net.skyscanner.SkyScannerCarSearchPage;

import static service.ActionManager.*;

public class SkyScannerSearchHotelPage extends AbstractPage {

    private static final By DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR = By.xpath("//input[@name='destination-autosuggest']");
    private static final By HOSTEL_CHECK_IN_INPUT_LOCATOR = By.xpath("//input[@id='checkin']");
    private static final By HOSTEL_CHECK_OUT_INPUT_LOCATOR = By.xpath("//input[@id='checkout']");
    private static final By GUESTS_AND_ROOM_INPUT_LOCATOR = By.xpath("//input[@id='guests-rooms']");
    private static final By SEARCH_HOTEL_BUTTON_LOCATOR = By.xpath("//button[contains(text(), 'Search hotels')]");
    private static final By QUANTITY_ROOMS_INPUT_LOCATOR = By.xpath("//input[@id='rooms']");
    private static final By INCREASE_ROOM_BUTTON_LOCATOR = By.xpath("//button[@aria-controls='rooms'][@title='Increase']");
    private static final By DECREASE_ROOM_BUTTON_LOCATOR = By.xpath("//button[@aria-controls='rooms'][@title='Decrease']");
    private static final By QUANTITY_ADULT_PEOPLE_INPUT_LOCATOR = By.xpath("//input[@id='adults']");
    private static final By INCREASE_ADULT_BUTTON_LOCATOR = By.xpath("//button[@aria-controls='adults'][@title='Increase']");
    private static final By DECREASE_ADULT_BUTTON_LOCATOR = By.xpath("//button[@aria-controls='adults'][@title='Decrease']");
    private static final By QUANTITY_CHILDREN_INPUT_LOCATOR = By.xpath("//input[@id='children']");
    private static final By INCREASE_CHILD_BUTTON_LOCATOR = By.xpath("//button[@aria-controls='children'][@title='Increase']");
    private static final By DECREASE_CHILD_BUTTON_LOCATOR = By.xpath("//button[@aria-controls='children'][@title='Decrease']");
    private static final By DONE_BUTTON_LOCATOR = By.xpath("//footer/button");
    private static final By SEARCH_HOTELS_BUTTON_LOCATOR = By.xpath("//form[@id='search-controls']//button");
    private static final By CAR_HIRE_TAB_LOCATOR = By.xpath("//a[@id='carhi']");

    public SkyScannerSearchHotelPage addDestination(String destination) {
        clickOnElementBy(DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR);
        typeTextToElementBy(DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR, destination);
        return this;
    }

    public SkyScannerSearchHotelPage increaseRoom() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_LOCATOR);
        clickOnElementBy(INCREASE_ROOM_BUTTON_LOCATOR);
        clickOnElementBy(DONE_BUTTON_LOCATOR);
        return this;
    }

    public SkyScannerCarSearchPage clickToCarHireTab() {
        clickOnElementBy(CAR_HIRE_TAB_LOCATOR);
        logger.info(("Clicked on CAR_HIRE_TAB"));
        return new SkyScannerCarSearchPage();
    }

    public SkyScannerSearchHotelPage increaseRoom(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseRoom();
        return this;
    }

    public SkyScannerSearchHotelPage increaseAdult() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_LOCATOR);
        clickOnElementBy(INCREASE_ADULT_BUTTON_LOCATOR);
        clickOnElementBy(DONE_BUTTON_LOCATOR);
        return this;
    }

    public SkyScannerSearchHotelPage increaseAdult(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseAdult();
        return this;
    }

    public SkyScannerSearchHotelPage increaseChild() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_LOCATOR);
        clickOnElementBy(INCREASE_CHILD_BUTTON_LOCATOR);
        clickOnElementBy(DONE_BUTTON_LOCATOR);
        return this;
    }

    public SkyScannerSearchHotelPage increaseChild(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseChild();
        return this;
    }

    public String getQuantityRooms() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_LOCATOR);
        String quantity = getAttributeValueOnElementBy(QUANTITY_ROOMS_INPUT_LOCATOR,"value");
        clickOnElementBy(DONE_BUTTON_LOCATOR);
        return quantity;
    }

    public String getQuantityAdultPeople() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_LOCATOR);
        String quantity = getAttributeValueOnElementBy(QUANTITY_ADULT_PEOPLE_INPUT_LOCATOR,"value");
        clickOnElementBy(DONE_BUTTON_LOCATOR);
        return quantity;
    }

    public String getQuantityChildren() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT_LOCATOR);
        String quantity = getAttributeValueOnElementBy(QUANTITY_CHILDREN_INPUT_LOCATOR,"value");
        clickOnElementBy(DONE_BUTTON_LOCATOR);
        return quantity;
    }

    public SkyScannerHotelResultPage clickToSearchHotelsButton() {
        clickOnElementBy(SEARCH_HOTELS_BUTTON_LOCATOR);
        return new SkyScannerHotelResultPage();
    }

    public String getTextFromHotelButton() {
        return getTextOnElementBy(SEARCH_HOTEL_BUTTON_LOCATOR);
    }
}
