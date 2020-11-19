package service;

import model.Hotel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.net.skyscanner.hotels.HotelsResultScreen;
import pages.net.skyscanner.hotels.source.CompareHotelsByPrice;
import pages.net.skyscanner.hotels.source.CompareHotelsByRating;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HotelsResultService {
    public static Logger logger = LogManager.getRootLogger();
    private HotelsResultScreen hotelsResultScreen;

    public HotelsResultService(HotelsResultScreen hotelsResultScreen) {
        this.hotelsResultScreen = hotelsResultScreen;
    }

    public List<Hotel> getHotels() {
        List<Hotel> hotels = new ArrayList<>();
        List<WebElement> hotelElements = hotelsResultScreen.getElements();

        for (WebElement hotel : hotelElements) {
            String name = getHotelName(hotel);
            double rating = getHotelRating(hotel);
            int price = getHotelPrice(hotel);
            logger.info("HOTEL [name: {}, rating: {}, price: {}]", name, rating, price);
            hotels.add(new Hotel(name, rating, price));
        }
        return hotels;
    }

    private String getHotelName(WebElement hotel) {
        return getText(hotel, hotelsResultScreen.HOTEL_NAME_LOCATOR);
    }

    private double getHotelRating(WebElement hotel) {
        return Double.parseDouble(getText(hotel, hotelsResultScreen.HOTEL_RATING_LOCATOR));
    }

    private int getHotelPrice(WebElement hotel) {
        return Integer.parseInt(StringUtils.getMatcherByIndex(getText(hotel, hotelsResultScreen.HOTEL_PRICE_LOCATOR), "\\w+", 0));
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
