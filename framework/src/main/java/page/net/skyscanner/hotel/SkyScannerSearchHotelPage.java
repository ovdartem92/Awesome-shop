package page.net.skyscanner.hotel;

import org.openqa.selenium.By;
import page.AbstractPage;
import page.net.skyscanner.SkyScannerCarSearchPage;

import static service.ActionManager.*;

public class SkyScannerSearchHotelPage extends AbstractPage {

    private static final By DESTINATION_OR_HOSTEL_NAME_INPUT = By.xpath("//input[@name='destination-autosuggest']");
    private static final By HOSTEL_CHECK_IN_INPUT = By.xpath("//input[@id='checkin']");
    private static final By HOSTEL_CHECK_OUT_INPUT = By.xpath("//input[@id='checkout']");
    private static final By GUESTS_AND_ROOM_INPUT = By.xpath("//input[@id='guests-rooms']");
    private static final By SEARCH_HOTEL_BUTTON = By.xpath("//button[contains(text(), 'Search hotels')]");
    private static final By QUANTITY_ROOMS_INPUT = By.xpath("//input[@id='rooms']");
    private static final By INCREASE_ROOM_BUTTON = By.xpath("//button[@aria-controls='rooms'][@title='Increase']");
    private static final By DECREASE_ROOM_BUTTON = By.xpath("//button[@aria-controls='rooms'][@title='Decrease']");
    private static final By QUANTITY_ADULT_PEOPLE_INPUT = By.xpath("//input[@id='adults']");
    private static final By INCREASE_ADULT_BUTTON = By.xpath("//button[@aria-controls='adults'][@title='Increase']");
    private static final By DECREASE_ADULT_BUTTON = By.xpath("//button[@aria-controls='adults'][@title='Decrease']");
    private static final By QUANTITY_CHILDREN_INPUT = By.xpath("//input[@id='children']");
    private static final By INCREASE_CHILD_BUTTON = By.xpath("//button[@aria-controls='children'][@title='Increase']");
    private static final By DECREASE_CHILD_BUTTON = By.xpath("//button[@aria-controls='children'][@title='Decrease']");
    private static final By DONE_BUTTON = By.xpath("//footer/button");
    private static final By SEARCH_HOTELS_BUTTON = By.xpath("//form[@id='search-controls']//button");
    private static final By CAR_HIRE_TAB = By.xpath("//a[@id='carhi']");

    public SkyScannerSearchHotelPage addDestination(String destination) {
        clickOnElementBy(DESTINATION_OR_HOSTEL_NAME_INPUT);
        typeTextToElementBy(DESTINATION_OR_HOSTEL_NAME_INPUT, destination);
        return this;
    }

    public SkyScannerSearchHotelPage increaseRoom() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT);
        clickOnElementBy(INCREASE_ROOM_BUTTON);
        clickOnElementBy(DONE_BUTTON);
        return this;
    }

    public SkyScannerCarSearchPage clickToCarHireTab() {
        clickOnElementBy(CAR_HIRE_TAB);
        logger.info(("Clicked on CAR_HIRE_TAB"));
        return new SkyScannerCarSearchPage();
    }

    public SkyScannerSearchHotelPage increaseRoom(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseRoom();
        return this;
    }

    public SkyScannerSearchHotelPage increaseAdult() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT);
        clickOnElementBy(INCREASE_ADULT_BUTTON);
        clickOnElementBy(DONE_BUTTON);
        return this;
    }

    public SkyScannerSearchHotelPage increaseAdult(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseAdult();
        return this;
    }

    public SkyScannerSearchHotelPage increaseChild() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT);
        clickOnElementBy(INCREASE_CHILD_BUTTON);
        clickOnElementBy(DONE_BUTTON);
        return this;
    }

    public SkyScannerSearchHotelPage increaseChild(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseChild();
        return this;
    }

    public String getQuantityRooms() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT);
        String quantity = getAttributeValueOnElementBy(QUANTITY_ROOMS_INPUT,"value");
        clickOnElementBy(DONE_BUTTON);
        return quantity;
    }

    public String getQuantityAdultPeople() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT);
        String quantity = getAttributeValueOnElementBy(QUANTITY_ADULT_PEOPLE_INPUT,"value");
        clickOnElementBy(DONE_BUTTON);
        return quantity;
    }

    public String getQuantityChildren() {
        clickOnElementBy(GUESTS_AND_ROOM_INPUT);
        String quantity = getAttributeValueOnElementBy(QUANTITY_CHILDREN_INPUT,"value");
        clickOnElementBy(DONE_BUTTON);
        return quantity;
    }

    public SkyScannerHotelResultPage clickToSearchHotelsButton() {
        clickOnElementBy(SEARCH_HOTELS_BUTTON);
        return new SkyScannerHotelResultPage();
    }

    public String getTextFromHotelButton() {
        return getTextOnElementBy(SEARCH_HOTEL_BUTTON);
    }
}
