package pages.net.skyscanner.hotels.source;

import pages.AbstractScreen;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static service.HotelService.clickAddItemButton;
import static service.HotelService.getQuantityItemInput;

public class FilterButtonsScreen extends AbstractScreen {
    public enum Title {DECREASE, INCREASE}
    public enum Id {ROOMS, ADULTS, CHILDREN}
    private static final String GUESTS_AND_ROOM_SECTION = "//div[starts-with(@class, 'BpkSectionListItem')]";
    private static final String BUTTON_LOCATOR = "//button[@aria-controls='%s'][@title='%s']";
    private static final String QUANTITY_INPUT_LOCATOR = "//input[@id='%s']";

    public void clickButton(Title title, Id id) {
        String locator = String.format(BUTTON_LOCATOR, id.toString().toLowerCase(), capitalize(title.toString().toLowerCase()));
        clickAddItemButton(locator);
    }

    public void clickButton(Title title, Id id, int quantity) {
        for (int i = 0; i < quantity; i++)
            clickButton(title, id);
    }

    public int getQuantityInput(Id id) {
        return getQuantityItemInput(String.format(QUANTITY_INPUT_LOCATOR, id.toString().toLowerCase()));
    }
}
