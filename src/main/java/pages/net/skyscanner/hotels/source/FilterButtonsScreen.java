package pages.net.skyscanner.hotels.source;

import org.apache.commons.lang3.StringUtils;
import pages.AbstractScreen;
import service.HotelSearchService;

public class FilterButtonsScreen extends AbstractScreen {
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
        new HotelSearchService().clickButtonUntilThenDisabled(locator);
    }

    public void minClickButton(Id id) {
        String locator = getStringLocatorForFilterButton(Title.DECREASE, id);
        new HotelSearchService().clickButtonUntilThenDisabled(locator);
    }

    public void clickButton(Title title, Id id) {
        String locator = getStringLocatorForFilterButton(title, id);
        new HotelSearchService().clickAddItemButton(locator);
    }

    public void clickButton(Title title, Id id, int quantity) {
        for (int i = 0; i < quantity; i++)
            clickButton(title, id);
    }

    public int getQuantityInput(Id id) {
        return new HotelSearchService().getQuantityItemInput(getStringLocatorForFilterInput(id));
    }

    private String getStringLocatorForFilterButton(Title title, Id id) {
        return String.format(BUTTON_LOCATOR, id.toString().toLowerCase(), StringUtils.capitalize(title.toString().toLowerCase()));
    }

    private String getStringLocatorForFilterInput(Id id) {
        return String.format(QUANTITY_INPUT_LOCATOR, id.toString().toLowerCase());
    }
}
