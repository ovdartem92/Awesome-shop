package pages.net.skyscanner.hotels;

import model.Hotel;
import org.openqa.selenium.WebElement;
import pages.AbstractScreen;
import service.HotelsResultService;
import utils.StringUtils;

import java.util.List;

import static driver.Browser.LONG_TIMEOUT_SECONDS;
import static service.WaitManager.waitForInvisibilityOfElementLocated;

public class HotelsResultScreen extends AbstractScreen {
    private final static String HOTEL_NAME_LOCATOR = ".//span[@data-test-id='hotel-name']";
    private final static String HOTEL_RATING_LOCATOR = ".//div[1]//div[3]/span";
    private final static String HOTEL_PRICE_LOCATOR = ".//div[3]//div[contains(@class, 'HotelCard_HotelCard__priceVariant')]";
    private final static String WAITING_MODAL_VIEW = "//div[starts-with(@class, 'WaitingModal_WaitingModal')]";
    private final static String HOTEL_BLOCK_LOCATOR = "//section//div[@role='button']";
    private final static String GUEST_RATING_SORT_BUTTON_LOCATOR = "//button[@data-test-id='search-sort-rating']";
    private final static String PRICE_SORT_BUTTON_LOCATOR = "//button[@data-test-id='search-sort-price']";
    private HotelsResultService hotelsResultService = new HotelsResultService(this);

    public static boolean isWaitingModalInvisible() {
        return waitForInvisibilityOfElementLocated(WAITING_MODAL_VIEW, LONG_TIMEOUT_SECONDS);
    }

    public List<WebElement> getElements() {
        return getElements(HOTEL_BLOCK_LOCATOR);
    }

    public List<Hotel> getHotels() {
        return hotelsResultService.getHotels();
    }

    public boolean isHotelSortedByRating(List<Hotel> hotels) {
        return hotelsResultService.isHotelSortedByRating(hotels);
    }

    public HotelsResultScreen clickToGuestRattingSortButton() {
        clickOnElement(GUEST_RATING_SORT_BUTTON_LOCATOR);
        return this;
    }

    public String getHotelName(WebElement hotelElement) {
        return hotelsResultService.getText(hotelElement, HOTEL_NAME_LOCATOR);
    }

    public double getHotelRating(WebElement hotelElement) {
        return Double.parseDouble(hotelsResultService.getText(hotelElement, HOTEL_RATING_LOCATOR));
    }

    public int getHotelPrice(WebElement hotelElement) {
        return Integer.parseInt(StringUtils.getMatcherByIndex(hotelsResultService
                .getText(hotelElement, HOTEL_PRICE_LOCATOR), "\\w+", 0));
    }
}
