package pages.net.skyscanner.hotels.source;

import pages.AbstractScreen;
import service.HotelSearchService;

import static service.HotelSearchService.Title.DECREASE;
import static service.HotelSearchService.Title.INCREASE;

public class FilterButtonsScreen extends AbstractScreen {
    public void maxClickButton(HotelSearchService.Id id) {
        String locator = HotelSearchService.getStringLocatorForFilterButton(INCREASE, id);
        HotelSearchService.clickButtonUntilThenDisabled(locator);
    }

    public void minClickButton(HotelSearchService.Id id) {
        String locator = HotelSearchService.getStringLocatorForFilterButton(DECREASE, id);
        HotelSearchService.clickButtonUntilThenDisabled(locator);
    }

    public void clickButton(HotelSearchService.Title title, HotelSearchService.Id id) {
        String locator = HotelSearchService.getStringLocatorForFilterButton(title, id);
        HotelSearchService.clickAddItemButton(locator);
    }

    public void clickButton(HotelSearchService.Title title, HotelSearchService.Id id, int quantity) {
        for (int i = 0; i < quantity; i++)
            clickButton(title, id);
    }

    public int getQuantityInput(HotelSearchService.Id id) {
        return HotelSearchService.getQuantityItemInput(HotelSearchService.getStringLocatorForFilterInput(id));
    }
}
