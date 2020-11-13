package service;

import org.testng.util.Strings;
import pages.net.skyscanner.hotels.HotelsSearchScreen;

import static pages.AbstractScreen.*;

public class HotelSearchService {
    private static final String DISABLED_PROPERTY = "disabled";
    private HotelsSearchScreen hotelsSearchScreen = new HotelsSearchScreen();

    public void addDestination(String destination) {
        hotelsSearchScreen.typeTextToDestinationInput(destination);
        hotelsSearchScreen.clickOnFirstDropdownInput();
    }

    public void clickAddItemButton(String locator) {
        hotelsSearchScreen.clickOnGuestAndRoomsInput();
        clickOnElement(locator);
        hotelsSearchScreen.filterButtons.clickOnDoneButton();
    }

    public void clickButtonUntilThenDisabled(String locator) {
        hotelsSearchScreen.clickOnGuestAndRoomsInput();
        while (Strings.isNullOrEmpty(getElement(locator).getAttribute(DISABLED_PROPERTY))) {
            clickOnElement(locator);
        }
        hotelsSearchScreen.filterButtons.clickOnDoneButton();
    }

    public int getQuantityItemInput(String locator) {
        hotelsSearchScreen.clickOnGuestAndRoomsInput();
        String quantity = getAttributeValueOnElement(locator, "value");
        hotelsSearchScreen.filterButtons.clickOnDoneButton();
        return Integer.parseInt(quantity);
    }
}
