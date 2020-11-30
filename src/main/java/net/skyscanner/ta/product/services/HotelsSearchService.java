package net.skyscanner.ta.product.services;

import org.testng.util.Strings;
import pages.AbstractScreen;
import pages.net.skyscanner.hotels.HotelsSearchScreen;

/**
 * The service class for hotel search screen.
 *
 * @see <a href="https://www.skyscanner.com/hotels">Hotels search screen</a>.
 */
public class HotelsSearchService {
    private final HotelsSearchScreen hotelsSearchScreen;

    /**
     * The constructor initializing the hotel search screen entity.
     *
     * @param hotelsSearchScreen contains a hotel screen entity
     */
    public HotelsSearchService(HotelsSearchScreen hotelsSearchScreen) {
        this.hotelsSearchScreen = hotelsSearchScreen;
    }

    /**
     * The method for pressing the add rooms, adults or children button in the filter buttons.
     * The method will add the maximum number of items until the filter button becomes disabled.
     *
     * @param locator contains a xPath locator for the click button
     */
    public void clickFilterButtonUntilDisabled(String locator) {
        hotelsSearchScreen.clickGuestAndRoomsInput();
        while (Strings.isNullOrEmpty(AbstractScreen.getElement(locator).getAttribute("disabled")))
            AbstractScreen.clickOnElement(locator);
        hotelsSearchScreen.clickDoneFilterButton();
    }

    /**
     * The method returns the quantity of rooms, adults or children items of filter inputs.
     *
     * @param locator contains a xPath locator to get the quantity of items
     * @return quantity of rooms, adults or children items
     */
    public int getQuantityOfFilterInput(String locator) {
        hotelsSearchScreen.clickGuestAndRoomsInput();
        String quantity = AbstractScreen.getAttributeValueOnElement(locator, "value");
        hotelsSearchScreen.clickDoneFilterButton();
        return Integer.parseInt(quantity);
    }
}
