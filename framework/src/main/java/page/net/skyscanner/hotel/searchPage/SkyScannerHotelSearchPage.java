package page.net.skyscanner.hotel.searchPage;

import page.AbstractPage;
import page.net.skyscanner.hotel.resultPage.SkyScannerHotelResultPage;
import page.net.skyscanner.hotel.searchPage.structure.GuestsAndRoomsButtons;

import static service.ActionManager.*;

public class SkyScannerHotelSearchPage extends AbstractPage {
    private static final String DESTINATION_OR_HOSTEL_NAME_INPUT_PATH = "//input[@name='destination-autosuggest']";
    private static final String SEARCH_HOTELS_BUTTON_PATH = "//button[@data-test-id='search-button']";
    private GuestsAndRoomsButtons guestButtons;

    public SkyScannerHotelSearchPage() {
        guestButtons = new GuestsAndRoomsButtons();
    }

    public SkyScannerHotelSearchPage addDestination(String destination) {
        typeInFieldWithDelay(DESTINATION_OR_HOSTEL_NAME_INPUT_PATH, destination);
        return this;
    }

    public SkyScannerHotelResultPage clickToSearchHotelsButton() {
        clickOnElementBy(SEARCH_HOTELS_BUTTON_PATH);
        return new SkyScannerHotelResultPage();
    }

    public SkyScannerHotelSearchPage increaseRoom() {
        guestButtons.increaseRoom();
        return this;
    }

    public SkyScannerHotelSearchPage increaseRoom(int quantity) {
        guestButtons.increaseRoom(quantity);
        return this;
    }

    public SkyScannerHotelSearchPage increaseAdult() {
        guestButtons.increaseAdult();
        return this;
    }

    public SkyScannerHotelSearchPage increaseAdult(int quantity) {
        guestButtons.increaseAdult(quantity);
        return this;
    }

    public SkyScannerHotelSearchPage increaseChild() {
        guestButtons.increaseChild();
        return this;
    }

    public SkyScannerHotelSearchPage increaseChild(int quantity) {
        guestButtons.increaseChild(quantity);
        return this;
    }

    public int getQuantityRooms() {
        return guestButtons.getQuantityRooms();
    }

    public int getQuantityAdultPeople() { return guestButtons.getQuantityAdultPeople(); }

    public int getQuantityChildren() {
        return guestButtons.getQuantityChildren();
    }

    public String getTextFromHotelButton() {
        return getTextOnElementBy(SEARCH_HOTELS_BUTTON_PATH);
    }
}
