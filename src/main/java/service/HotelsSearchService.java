package service;

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

    public void clickFilterButtonUntilDisabled(String locator) {
        hotelsSearchScreen.clickGuestAndRoomsInput();
        while (Strings.isNullOrEmpty(getElement(locator).getAttribute(DISABLED_ATTRIBUTE)))
            clickOnElement(locator);
        hotelsSearchScreen.clickDoneFilterButton();
    }

    public int getQuantityOfFilterInput(String locator) {
        hotelsSearchScreen.clickGuestAndRoomsInput();
        String quantity = getAttributeValueOnElement(locator, VALUE_ATTRIBUTE);
        hotelsSearchScreen.clickDoneFilterButton();
        return Integer.parseInt(quantity);
    }
}
