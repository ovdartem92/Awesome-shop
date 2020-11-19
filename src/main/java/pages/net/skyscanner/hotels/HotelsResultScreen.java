package pages.net.skyscanner.hotels;

import model.Hotel;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;
import service.HotelsResultService;

import java.util.List;

import static service.WaitManager.waitForInvisibilityOfElementLocated;

public class HotelsResultScreen extends AbstractScreen {
    public final static String HOTEL_NAME_LOCATOR = ".//span[@data-test-id='hotel-name']";
    public final static String HOTEL_RATING_LOCATOR = ".//div[1]//div[3]/span";
    public final static String HOTEL_PRICE_LOCATOR = ".//div[3]//div[contains(@class, 'HotelCard_HotelCard__priceVariant')]";
    private static final String WAITING_MODAL_VIEW = "//div[starts-with(@class, 'WaitingModal_WaitingModal')]";
    private final static String HOTEL_BLOCK_LOCATOR = "//section//div[@role='button']";
    private final static String GUEST_RATING_SORT_BUTTON_LOCATOR = "//button[@data-test-id='search-sort-rating']";
    private final static String PRICE_SORT_BUTTON_LOCATOR = "//button[@data-test-id='search-sort-price']";
    private HotelsResultService hotelsResultService = new HotelsResultService(this);

    public static boolean isWaitingModalInvisible() {
        return waitForInvisibilityOfElementLocated(WAITING_MODAL_VIEW);
    }

    public List<WebElement> getElements() {
        isWaitingModalInvisible();
        return getElements(HOTEL_BLOCK_LOCATOR);
    }

    public List<Hotel> getHotels() {
        isWaitingModalInvisible();
        return hotelsResultService.getHotels();
    }

    public boolean isHotelSortedByRating(List<Hotel> hotels) {
        isWaitingModalInvisible();
        return hotelsResultService.isHotelSortedByRating(hotels);
    }

    public HotelsResultScreen clickToGuestRattingSortButton() {
        isWaitingModalInvisible();
        clickOnElement(GUEST_RATING_SORT_BUTTON_LOCATOR);
        return this;
    }

    public HotelsResultScreen clickToPriceSortButton() {
        isWaitingModalInvisible();
        clickOnElement(PRICE_SORT_BUTTON_LOCATOR);
        return this;
    }
}
