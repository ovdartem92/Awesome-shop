package pages.net.skyscanner.hotels;

import org.apache.commons.lang3.StringUtils;
import pages.AbstractScreen;
import pages.net.skyscanner.hotels.hotelsService.HotelsSearchService;

public class HotelsSearchScreen extends AbstractScreen {
    public enum Title {DECREASE, INCREASE}
    public enum Id {ROOMS, ADULTS, CHILDREN}
    private static final String DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR = "//input[@name='destination-autosuggest']";
    private static final String FIRST_ELEMENT_OF_DROPDOWN_LOCATOR = "//input[@aria-activedescendant='react-autowhatever-1--item-0']";
    private static final String HOTELS_SEARCH_BUTTON_LOCATOR = "//button[@data-test-id='search-button']";
    private static final String GUESTS_AND_ROOMS_INPUT_LOCATOR = "//input[@id='guests-rooms']";
    private static final String DONE_BUTTON_LOCATOR = "//footer/button";
    private static final String BUTTON_LOCATOR = "//button[@aria-controls='%s'][@title='%s']";
    private static final String QUANTITY_INPUT_LOCATOR = "//input[@id='%s']";

    public String getTextFromHotelsSearchButton() {
        return getTextOnElement(HOTELS_SEARCH_BUTTON_LOCATOR);
    }

    public HotelsSearchScreen addDestinations(String destination) {
        typeTextToDestinationInput(destination);
        clickOnFirstDropdownInput();
        return this;
    }

    public HotelsSearchScreen typeTextToDestinationInput(String destination) {
        typeTextToElement(DESTINATION_OR_HOSTEL_NAME_INPUT_LOCATOR, destination);
        return this;
    }

    public HotelsSearchScreen clickOnFirstDropdownInput() {
        clickOnElement(FIRST_ELEMENT_OF_DROPDOWN_LOCATOR);
        return this;
    }

    public HotelsResultScreen clickToSearchHotelsButton() {
        clickOnElement(HOTELS_SEARCH_BUTTON_LOCATOR);
        return new HotelsResultScreen();
    }

    public HotelsSearchScreen clickOnGuestAndRoomsInput() {
        clickOnElement(GUESTS_AND_ROOMS_INPUT_LOCATOR);
        return this;
    }

    public HotelsSearchScreen clickOnDoneButton() {
        clickOnElement(DONE_BUTTON_LOCATOR);
        return this;
    }

    public HotelsSearchScreen maxClickButton(Id id) {
        String locator = getStringLocatorForFilterButton(Title.INCREASE, id);
        new HotelsSearchService().clickButtonUntilThenDisabled(locator);
        return this;
    }

    public HotelsSearchScreen minClickButton(Id id) {
        String locator = getStringLocatorForFilterButton(Title.DECREASE, id);
        new HotelsSearchService().clickButtonUntilThenDisabled(locator);
        return this;
    }

    public int getQuantityInput(Id id) {
        return new HotelsSearchService().getQuantityItemInput(getStringLocatorForFilterInput(id));
    }

    private String getStringLocatorForFilterButton(Title title, Id id) {
        return String.format(BUTTON_LOCATOR, id.toString().toLowerCase(), StringUtils.capitalize(title.toString().toLowerCase()));
    }

    private String getStringLocatorForFilterInput(Id id) {
        return String.format(QUANTITY_INPUT_LOCATOR, id.toString().toLowerCase());
    }
}
