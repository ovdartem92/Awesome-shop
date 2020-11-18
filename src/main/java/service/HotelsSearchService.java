package service;

import org.testng.util.Strings;
import pages.AbstractScreen;
import pages.net.skyscanner.hotels.HotelsSearchScreen;

public class HotelsSearchService {
    private final HotelsSearchScreen hotelsSearchScreen;

    public HotelsSearchService(HotelsSearchScreen hotelsSearchScreen) {
        this.hotelsSearchScreen = hotelsSearchScreen;
    }

    public void clickFilterButtonUntilDisabled(String locator) {
        hotelsSearchScreen.clickGuestAndRoomsInput();
        while (Strings.isNullOrEmpty(AbstractScreen.getElement(locator).getAttribute("disabled")))
            AbstractScreen.clickOnElement(locator);
        hotelsSearchScreen.clickDoneFilterButton();
    }

    public int getQuantityOfFilterInput(String locator) {
        hotelsSearchScreen.clickGuestAndRoomsInput();
        String quantity = AbstractScreen.getAttributeValueOnElement(locator, "value");
        hotelsSearchScreen.clickDoneFilterButton();
        return Integer.parseInt(quantity);
    }
}
