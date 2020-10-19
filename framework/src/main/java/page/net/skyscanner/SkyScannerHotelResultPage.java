package page.net.skyscanner;

import model.Hotel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.AbstractPage;

import java.util.List;

public class SkyScannerHotelResultPage extends AbstractPage {

    private final static By SEARCH_SUMMARY = By.xpath("//p[@data-test-id='search-summary']"); //
    private final static By GUEST_RATING_SORT_BUTTON = By.xpath("//button/span[contains(text(), 'Guest rating')]"); //
    private final static By PRICE_SORT_BUTTON = By.xpath("//button/span[contains(text(), 'Price')]"); //
    private final static By FOUND_HOTEL_NAME = By.xpath("//span[@data-test-id='hotel-name']");
    private final static By FOUND_HOTEL_RATING = By.xpath("//div[@class='HotelCard_HotelCard__reviewSummary__1Rqp3']/span");
    private final static By FOUND_HOTEL_PRICE = By.xpath("//div[@class='HotelCard_HotelCard__priceVariant__3dC83']");

    private static String FOUND_HOTEL_RATING_WITH_HOTEL_NAME_PATH = "//span[@data-test-id='hotel-name'][contains(text(), '%s')]" +
            "/../following-sibling::div[@class='HotelCard_HotelCard__reviewSummary__1Rqp3']/span";
    private static String FOUND_HOTEL_PRICE_WITH_HOTEL_NAME_PATH = "//span[@data-test-id='hotel-name'][contains(text(), '%s')]" +
            "/../../../../following-sibling::div//div[@class='HotelCard_HotelCard__priceVariant__3dC83']";
    private List<Hotel> hotels;

    protected SkyScannerHotelResultPage(WebDriver driver) {
        super(driver);
    }
}
