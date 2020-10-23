package page.net.skyscanner.hotel.resultPage;

import model.Hotel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.AbstractPage;

import java.util.ArrayList;
import java.util.List;

import static service.ActionManager.*;

public class SkyScannerHotelResultPage extends AbstractPage {
    private List<Hotel> hotels;
    private final static String SEARCH_SUMMARY_PATH = "//p[@data-test-id='search-summary']";
    private final static String GUEST_RATING_SORT_BUTTON_PATH = "//button[@data-test-id='search-sort-rating']";
    private final static String PRICE_SORT_BUTTON_PATH = "//button[@data-test-id='search-sort-price']";
    private final static String HOTEL_BLOCK_PATH = "//div[@class='CardRowLayout_CardRowLayout__3d3Kh']";
    private final static String HOTEL_NAME_PATH = "//*[@data-test-id='hotel-name']";
    private final static String HOTEL_RATING_PATH = "//span[@data-test-id='hotel-name']/../following-sibling::" +
            "div[@class='HotelCard_HotelCard__reviewSummary__1Rqp3']/span";
    private final static String HOTEL_PRICE_PATH = "//span[@data-test-id='hotel-name']/../../../../following-sibling::" +
            "div//div[@class='HotelCard_HotelCard__priceVariant__3dC83']";

    public SkyScannerHotelResultPage() {
        isWaitingModalViewOnPage();
    }

    public int getFoundHotelsQuantity() {
        String searchSummaryLine = getTextOnElementBy(SEARCH_SUMMARY_PATH);
        return Integer.parseInt(searchSummaryLine.split(" ")[0]);
    }

    public SkyScannerHotelResultPage clickToGuestRattingSortButton() {
        clickOnElementBy(GUEST_RATING_SORT_BUTTON_PATH);
        return this;
    }

    public SkyScannerHotelResultPage clickToPriceSortButton() {
        logger.info("CLICK SORT BUTTON");
        clickOnElementBy(PRICE_SORT_BUTTON_PATH);
        return this;
    }

    public List<Hotel> getHotels() {
        List<Hotel> hotels = new ArrayList<>();

        List<WebElement> hotelElements = getElementsBy(HOTEL_BLOCK_PATH);
        for (WebElement hotel : hotelElements) {
            String name = getHotelName(hotel);
            double rating = getHotelRating(hotel);
            int price = getHotelPrice(hotel);

            logger.info("HOTEL [name: + " + name + "], [rating:" + rating + "], [" + price + "]");
            hotels.add(new Hotel(name, rating, price));
        }
        return hotels;
    }

    private String getHotelName(WebElement hotel) {
        return hotel.findElement(By.xpath(HOTEL_NAME_PATH)).isDisplayed() ?
                hotel.findElement(By.xpath(HOTEL_NAME_PATH)).getText() : "";
    }

    private double getHotelRating(WebElement hotel) {
        return hotel.findElement(By.xpath(HOTEL_RATING_PATH)).isDisplayed() ?
                Double.parseDouble(hotel.findElement(By.xpath(HOTEL_RATING_PATH)).getText()) : -1d;
    }

    private int getHotelPrice(WebElement hotel) {
        return hotel.findElement(By.xpath(HOTEL_PRICE_PATH)).isDisplayed() ?
                Integer.parseInt(hotel.findElement(By.xpath(HOTEL_RATING_PATH)).getText()) : -1;
    }
}
