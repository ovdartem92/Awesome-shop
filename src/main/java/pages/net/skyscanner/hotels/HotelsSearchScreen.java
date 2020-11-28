package pages.net.skyscanner.hotels;

import org.apache.commons.lang3.StringUtils;
import pages.AbstractScreen;
import service.HotelsSearchService;

public class HotelsSearchScreen extends AbstractScreen {
    private static final String DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR = "//input[@name='destination-autosuggest']";
    private static final String FIRST_ELEMENT_OF_DROPDOWN_LOCATOR = "//input[@aria-activedescendant='react-autowhatever-1--item-0']";
    private static final String HOTELS_SEARCH_BUTTON_LOCATOR = "//button[@data-test-id='search-button']";
    private static final String GUESTS_AND_ROOMS_INPUT_LOCATOR = "//input[@id='guests-rooms']";
    private static final String DONE_BUTTON_LOCATOR = "//footer/button";
    private static final String BUTTON_LOCATOR = "//button[@aria-controls='%s'][@title='%s']";
    private static final String QUANTITY_INPUT_LOCATOR = "//input[@id='%s']";
    private final HotelsSearchService hotelsSearchService = new HotelsSearchService(this);

    public String getTextFromHotelsSearchButton() {
        return getTextOnElement(HOTELS_SEARCH_BUTTON_LOCATOR);
    }

    public HotelsSearchScreen typeTextToDestinationInput(String destination) {
        typeTextToElement(DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR, destination);
        clickOnElement(FIRST_ELEMENT_OF_DROPDOWN_LOCATOR);
        return this;
    }

    public HotelsResultScreen clickSearchHotelsButton() {
        clickOnElement(HOTELS_SEARCH_BUTTON_LOCATOR);
        return new HotelsResultScreen();
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
        String locator = getLocatorForFilterButton(FilterButtonsTitle.INCREASE, id);
        hotelsSearchService.clickFilterButtonUntilDisabled(locator);
        return this;
    }

    public int getQuantityOfFilterInput(FilterButtonsId id) {
        return hotelsSearchService.getQuantityOfFilterInput(getLocatorForFilterInput(id));
    }

    private String getLocatorForFilterButton(FilterButtonsTitle title, FilterButtonsId id) {
        return String.format(BUTTON_LOCATOR, id.toString().toLowerCase(), StringUtils.capitalize(title.toString().toLowerCase()));
    }

    private String getLocatorForFilterInput(FilterButtonsId id) {
        return String.format(QUANTITY_INPUT_LOCATOR, id.toString().toLowerCase());
    }

    public enum FilterButtonsTitle {DECREASE, INCREASE}

    public enum FilterButtonsId {ROOMS, ADULTS, CHILDREN}
}
