package pages.net.skyscanner.hotels.hotelsService;

import org.testng.util.Strings;
import pages.net.skyscanner.hotels.HotelsSearchScreen;

import static pages.AbstractScreen.*;

public class HotelsSearchService {
    private HotelsSearchScreen hotelsSearchScreen;
    private final String DISABLED_ATTRIBUTE = "disabled";
    private final String VALUE_ATTRIBUTE = "value";

    public HotelsSearchService(HotelsSearchScreen hotelsSearchScreen) {
        this.hotelsSearchScreen = hotelsSearchScreen;
    }

    public void clickAddItemButton(String locator) {
        hotelsSearchScreen.clickOnGuestAndRoomsInput();
        clickOnElement(locator);
        hotelsSearchScreen.clickOnDoneButton();
    }

    public void clickButtonUntilThenDisabled(String locator) {
        hotelsSearchScreen.clickOnGuestAndRoomsInput();
        while (Strings.isNullOrEmpty(getElement(locator).getAttribute(DISABLED_ATTRIBUTE))) {
            clickOnElement(locator);
        }
        hotelsSearchScreen.clickOnDoneButton();
    }

    public int getQuantityItemInput(String locator) {
        hotelsSearchScreen.clickOnGuestAndRoomsInput();
        String quantity = getAttributeValueOnElement(locator, VALUE_ATTRIBUTE);
        hotelsSearchScreen.clickOnDoneButton();
        return Integer.parseInt(quantity);
    }
}
