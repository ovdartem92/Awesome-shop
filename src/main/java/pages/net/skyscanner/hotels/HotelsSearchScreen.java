package pages.net.skyscanner.hotels;

import pages.AbstractScreen;
import pages.net.skyscanner.hotels.source.GuestsAndRoomsButtons;

public class HotelsSearchScreen extends AbstractScreen {
    private static final String DESTINATION_OR_HOSTEL_NAME_INPUT_PATH = "//input[@name='destination-autosuggest']";
    private static final String SEARCH_HOTELS_BUTTON_PATH = "//button[@data-test-id='search-button']";
    private GuestsAndRoomsButtons guestButtons;

    public HotelsSearchScreen() {
        guestButtons = new GuestsAndRoomsButtons();
    }

    public HotelsSearchScreen addDestination(String destination) {
        typeInFieldWithDelay(DESTINATION_OR_HOSTEL_NAME_INPUT_PATH, destination);
        return this;
    }

    public HotelsResultScreen clickToSearchHotelsButton() {
        clickOnElement(SEARCH_HOTELS_BUTTON_PATH);
        return new HotelsResultScreen();
    }

    public HotelsSearchScreen increaseRoom() {
        guestButtons.increaseRoom();
        return this;
    }

    public HotelsSearchScreen increaseRoom(int quantity) {
        guestButtons.increaseRoom(quantity);
        return this;
    }

    public HotelsSearchScreen increaseAdult() {
        guestButtons.increaseAdult();
        return this;
    }

    public HotelsSearchScreen increaseAdult(int quantity) {
        guestButtons.increaseAdult(quantity);
        return this;
    }

    public HotelsSearchScreen increaseChild() {
        guestButtons.increaseChild();
        return this;
    }

    public HotelsSearchScreen increaseChild(int quantity) {
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
        return getTextOnElement(SEARCH_HOTELS_BUTTON_PATH);
    }
}
