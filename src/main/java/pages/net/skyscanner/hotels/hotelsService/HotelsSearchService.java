package pages.net.skyscanner.hotels.hotelsService;

import org.testng.util.Strings;
import pages.net.skyscanner.hotels.HotelsSearchScreen;

import static pages.AbstractScreen.*;

public class HotelsSearchService {
    private static final String DISABLED_PROPERTY = "disabled";
    HotelsSearchScreen hotelsSearchScreen = new HotelsSearchScreen();

    public void clickAddItemButton(String locator) {
        hotelsSearchScreen.clickOnGuestAndRoomsInput();
        clickOnElement(locator);
        hotelsSearchScreen.guestsAndRoomsFilterButtons.clickOnDoneButton();
    }

    public void clickButtonUntilThenDisabled(String locator) {
        hotelsSearchScreen.clickOnGuestAndRoomsInput();
        while (Strings.isNullOrEmpty(getElement(locator).getAttribute(DISABLED_PROPERTY))) {
            clickOnElement(locator);
        }
        hotelsSearchScreen.guestsAndRoomsFilterButtons.clickOnDoneButton();
    }

    public int getQuantityItemInput(String locator) {
        hotelsSearchScreen.clickOnGuestAndRoomsInput();
        String quantity = getAttributeValueOnElement(locator, "value");
        hotelsSearchScreen.guestsAndRoomsFilterButtons.clickOnDoneButton();
        return Integer.parseInt(quantity);
    }
}
