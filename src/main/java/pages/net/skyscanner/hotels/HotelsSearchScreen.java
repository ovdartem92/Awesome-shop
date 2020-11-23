package pages.net.skyscanner.hotels;

import pages.AbstractScreen;
import service.HotelsSearchService;

/**
 * The class containing elements of the hotel search screen.
 * @see <a href="https://www.skyscanner.com/hotels">Hotels search screen</a>
 */
public class HotelsSearchScreen extends AbstractScreen {
    private static final String HOTELS_SEARCH_BUTTON_LOCATOR = "//button[@data-test-id='search-button']";
    private static final String GUESTS_AND_ROOMS_INPUT_LOCATOR = "//input[@id='guests-rooms']";
    private static final String DONE_BUTTON_LOCATOR = "//footer/button";
    private static final String BUTTON_LOCATOR = "//button[@aria-controls='%s'][@title='%s']";
    private static final String QUANTITY_INPUT_LOCATOR = "//input[@id='%s']";
    private final HotelsSearchService hotelsSearchService = new HotelsSearchService(this);

    public String getTextFromHotelsSearchButton() {
        return getTextOnElement(HOTELS_SEARCH_BUTTON_LOCATOR);
    }

    public HotelsSearchScreen clickGuestAndRoomsInput() {
        clickOnElement(GUESTS_AND_ROOMS_INPUT_LOCATOR);
        return this;
    }

    public HotelsSearchScreen clickDoneFilterButton() {
        clickOnElement(DONE_BUTTON_LOCATOR);
        return this;
    }

    public HotelsSearchScreen clickMaxIncreaseFilterButton(FilterButtonsId id) {
        String locator = String.format(BUTTON_LOCATOR, id.toString().toLowerCase(), "Increase");
        hotelsSearchService.clickFilterButtonUntilDisabled(locator);
        return this;
    }

    public int getQuantityOfFilterInput(FilterButtonsId id) {
        return hotelsSearchService.getQuantityOfFilterInput(getLocatorForFilterInput(id));
    }

    private String getLocatorForFilterInput(FilterButtonsId id) {
        return String.format(QUANTITY_INPUT_LOCATOR, id.toString().toLowerCase());
    }

    public enum FilterButtonsId {ROOMS, ADULTS, CHILDREN}
}
