package service;

import driver.Browser;
import model.Hotel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.net.skyscanner.hotels.source.CompareHotelsByPrice;
import pages.net.skyscanner.hotels.source.CompareHotelsByRating;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static driver.Browser.LONG_TIMEOUT_SECONDS;
import static pages.AbstractScreen.getElements;
import static pages.AbstractScreen.getTextOnElement;

public class HotelsResultService {
    public static Logger logger = LogManager.getRootLogger();
    private final String HOTEL_STRING = "HOTEL [name: '%s', rating: '%s', price: '%s']";
    private static final String WAITING_MODAL_VIEW = "//div[starts-with(@class, 'WaitingModal_WaitingModal')]";
    private final static String SEARCH_SUMMARY_LOCATOR = "//p[@data-test-id='search-summary']";
    private final static String HOTEL_BLOCK_LOCATOR = "//section//div[@role='button']";
    private final static String HOTEL_NAME_LOCATOR = ".//span[@data-test-id='hotel-name']";
    private final static String HOTEL_RATING_LOCATOR = ".//div[1]//div[3]/span";
    private final static String HOTEL_PRICE_LOCATOR = ".//div[3]//div[contains(@class, 'HotelCard_HotelCard__priceVariant')]";

    public static boolean isWaitingModalInvisible() {
        return new WebDriverWait(Browser.getDriver(), LONG_TIMEOUT_SECONDS)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(WAITING_MODAL_VIEW)));
    }

    public List<Hotel> getHotels() {
        List<Hotel> hotels = new ArrayList<>();
        List<WebElement> hotelElements = getElements(HOTEL_BLOCK_LOCATOR);

        for (WebElement hotel : hotelElements) {
            String name = getHotelName(hotel);
            double rating = getHotelRating(hotel);
            int price = getHotelPrice(hotel);
            logger.info(String.format(HOTEL_STRING, name, rating, price));
            hotels.add(new Hotel(name, rating, price));
        }
        return hotels;
    }

    public static int getFoundHotelsQuantity() {
        HotelsResultService.isWaitingModalInvisible();
        String searchSummaryLine = getTextOnElement(SEARCH_SUMMARY_LOCATOR);
        return Integer.parseInt(StringUtils.getMatcherByIndex(searchSummaryLine, "\\w+", 0));
    }

    private String getHotelName(WebElement hotel) {
        return getText(hotel, HOTEL_NAME_LOCATOR);
    }

    private double getHotelRating(WebElement hotel) {
        return Double.parseDouble(getText(hotel, HOTEL_RATING_LOCATOR));
    }

    private int getHotelPrice(WebElement hotel) {
        return Integer.parseInt(StringUtils.getMatcherByIndex(getText(hotel, HOTEL_PRICE_LOCATOR), "\\w+", 0));
    }

    private String getText(WebElement element, String locator) {
        try {
            return element.findElement(By.xpath(locator)).getText();
        } catch (NoSuchElementException e) {
            logger.debug("Find element with next xpath: {}", locator);
            logger.debug("Exception: {}", e.getMessage());
            return null;
        }
    }

    private boolean isHotelSortedByValue(List<Hotel> hotels, Comparator<Hotel> comparator) {
        List<Hotel> sortedHotels = new ArrayList<>(hotels);
        Collections.sort(sortedHotels, comparator);
        logger.info("Are hotel lists equal? {}", hotels.equals(sortedHotels));
        return hotels.equals(sortedHotels);
    }

    public boolean isHotelSortedByRating(List<Hotel> hotels) {
        return isHotelSortedByValue(hotels, new CompareHotelsByRating());
    }

    public boolean isHotelSortedByPrice(List<Hotel> hotels) {
        return isHotelSortedByValue(hotels, new CompareHotelsByPrice());
    }
}
