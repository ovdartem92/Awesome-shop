package pages.net.skyscanner.hotels.source;

import org.apache.commons.lang3.StringUtils;
import pages.AbstractScreen;
import pages.net.skyscanner.hotels.hotelsService.HotelsSearchService;

public class GuestsAndRoomsFilterScreen extends AbstractScreen {
    public enum Title {DECREASE, INCREASE}
    public enum Id {ROOMS, ADULTS, CHILDREN}
    private static final String DONE_BUTTON_LOCATOR = "//footer/button";
    private static final String BUTTON_LOCATOR = "//button[@aria-controls='%s'][@title='%s']";
    private static final String QUANTITY_INPUT_LOCATOR = "//input[@id='%s']";

    public void clickOnDoneButton() {
        clickOnElement(DONE_BUTTON_LOCATOR);
    }

    public void maxClickButton(Id id) {
        String locator = getStringLocatorForFilterButton(Title.INCREASE, id);
        new HotelsSearchService().clickButtonUntilThenDisabled(locator);
    }

    public void minClickButton(Id id) {
        String locator = getStringLocatorForFilterButton(Title.DECREASE, id);
        new HotelsSearchService().clickButtonUntilThenDisabled(locator);
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
