package pages.net.skyscanner.hotels.source;

import pages.AbstractScreen;
import org.apache.commons.lang3.StringUtils;
import service.HotelSearchService;

public class FilterButtonsScreen extends AbstractScreen {
    public enum Title {DECREASE, INCREASE}

    public enum Id {ROOMS, ADULTS, CHILDREN}

    private static final String GUESTS_AND_ROOM_SECTION = "//div[starts-with(@class, 'BpkSectionListItem')]";
    private static final String BUTTON_LOCATOR = "//button[@aria-controls='%s'][@title='%s']";
    private static final String QUANTITY_INPUT_LOCATOR = "//input[@id='%s']";

    public void clickButton(Title title, Id id) {
        String locator = String.format(BUTTON_LOCATOR, id.toString().toLowerCase(), StringUtils.capitalize(title.toString().toLowerCase()));
        HotelSearchService.clickAddItemButton(locator);
    }

    public void clickButton(Title title, Id id, int quantity) {
        for (int i = 0; i < quantity; i++)
            clickButton(title, id);
    }

    public int getQuantityInput(Id id) {
        return HotelSearchService.getQuantityItemInput(String.format(QUANTITY_INPUT_LOCATOR, id.toString().toLowerCase()));
    }
}
