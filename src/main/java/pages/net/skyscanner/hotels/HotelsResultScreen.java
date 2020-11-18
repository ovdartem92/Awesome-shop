package pages.net.skyscanner.hotels;

import model.Hotel;
import pages.AbstractScreen;
import service.HotelsResultService;

import java.util.List;

public class HotelsResultScreen extends AbstractScreen {
    private final static String GUEST_RATING_SORT_BUTTON_LOCATOR = "//button[@data-test-id='search-sort-rating']";
    private final static String PRICE_SORT_BUTTON_LOCATOR = "//button[@data-test-id='search-sort-price']";

    public List<Hotel> getHotels() {
        HotelsResultService.isWaitingModalInvisible();
        return new HotelsResultService().getHotels();
    }

    public boolean isHotelSortedByRating(List<Hotel> hotels) {
        HotelsResultService.isWaitingModalInvisible();
        return new HotelsResultService().isHotelSortedByRating(hotels);
    }

    public int getFoundHotelsQuantity() {
        HotelsResultService.isWaitingModalInvisible();
        return HotelsResultService.getFoundHotelsQuantity();
    }

    public HotelsResultScreen clickToGuestRattingSortButton() {
        HotelsResultService.isWaitingModalInvisible();
        clickOnElement(GUEST_RATING_SORT_BUTTON_LOCATOR);
        return this;
    }

    public HotelsResultScreen clickToPriceSortButton() {
        HotelsResultService.isWaitingModalInvisible();
        clickOnElement(PRICE_SORT_BUTTON_LOCATOR);
        return this;
    }
}
