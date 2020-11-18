package pages.net.skyscanner.hotels;

import model.Hotel;
import pages.AbstractScreen;
import service.HotelsResultService;

import java.util.List;

public class HotelsResultScreen extends AbstractScreen {
    private final static String GUEST_RATING_SORT_BUTTON_LOCATOR = "//button[@data-test-id='search-sort-rating']";
    private final static String PRICE_SORT_BUTTON_LOCATOR = "//button[@data-test-id='search-sort-price']";
    private HotelsResultService hotelsResultService = new HotelsResultService(this);

    public List<Hotel> getHotels() {
        hotelsResultService.isWaitingModalInvisible();
        return hotelsResultService.getHotels();
    }

    public boolean isHotelSortedByRating(List<Hotel> hotels) {
        hotelsResultService.isWaitingModalInvisible();
        return hotelsResultService.isHotelSortedByRating(hotels);
    }

    public int getFoundHotelsQuantity() {
        hotelsResultService.isWaitingModalInvisible();
        return hotelsResultService.getFoundHotelsQuantity();
    }

    public HotelsResultScreen clickToGuestRattingSortButton() {
        hotelsResultService.isWaitingModalInvisible();
        clickOnElement(GUEST_RATING_SORT_BUTTON_LOCATOR);
        return this;
    }

    public HotelsResultScreen clickToPriceSortButton() {
        hotelsResultService.isWaitingModalInvisible();
        clickOnElement(PRICE_SORT_BUTTON_LOCATOR);
        return this;
    }
}
