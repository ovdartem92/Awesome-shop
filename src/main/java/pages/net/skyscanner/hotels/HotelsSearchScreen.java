package pages.net.skyscanner.hotels;

import pages.AbstractScreen;
import pages.net.skyscanner.hotels.source.FilterButtonsScreen;

public class HotelsSearchScreen extends AbstractScreen {
    private static final String DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR = "//input[@name='destination-autosuggest']";
    private static final String SEARCH_HOTELS_BUTTON_LOCATOR = "//button[@data-test-id='search-button']";
    private FilterButtonsScreen guestButtons;

    public HotelsSearchScreen() {
        guestButtons = new FilterButtonsScreen();
    }

    public HotelsSearchScreen addDestination(String destination) {
        typeInFieldWithDelay(DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR, destination);
        return this;
    }

    public HotelsResultScreen clickToSearchHotelsButton() {
        clickOnElement(SEARCH_HOTELS_BUTTON_LOCATOR);
        return new HotelsResultScreen();
    }

    public HotelsSearchScreen increaseRoom() {
        guestButtons.addRoomClick();
        return this;
    }

    public HotelsSearchScreen increaseRoom(int quantity) {
        guestButtons.addRoomClick(quantity);
        return this;
    }

    public HotelsSearchScreen increaseAdult() {
        guestButtons.addAdultClick();
        return this;
    }

    public HotelsSearchScreen increaseAdult(int quantity) {
        guestButtons.addAdultClick(quantity);
        return this;
    }

    public HotelsSearchScreen increaseChild() {
        guestButtons.addChildClick();
        return this;
    }

    public HotelsSearchScreen increaseChild(int quantity) {
        guestButtons.addChildClick(quantity);
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
        return getTextOnElement(SEARCH_HOTELS_BUTTON_LOCATOR);
    }
}
