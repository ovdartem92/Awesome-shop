package service;

import model.Hotel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.net.skyscanner.hotels.HotelsResultScreen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HotelsResultService {
    private static Logger logger = LogManager.getRootLogger();
    private HotelsResultScreen hotelsResultScreen;

    public HotelsResultService(HotelsResultScreen hotelsResultScreen) {
        this.hotelsResultScreen = hotelsResultScreen;
    }

    public List<Hotel> getHotels() {
        List<Hotel> hotels = new ArrayList<>();
        List<WebElement> hotelElements = hotelsResultScreen.getElements();

        for (WebElement hotel : hotelElements) {
            String name = hotelsResultScreen.getHotelName(hotel);
            double rating = hotelsResultScreen.getHotelRating(hotel);
            int price = hotelsResultScreen.getHotelPrice(hotel);
            logger.info("HOTEL [name: {}, rating: {}, price: {}]", name, rating, price);
            hotels.add(new Hotel(name, rating, price));
        }
        return hotels;
    }

    public String getText(WebElement element, String locator) {
        try {
            return element.findElement(By.xpath(locator)).getText();
        } catch (NoSuchElementException e) {
            logger.debug("Find element with next xpath: {}", locator);
            logger.debug("Exception: {}", e.getMessage());
            return null;
        }
    }

    public boolean isHotelSortedByRating(List<Hotel> hotels) {
        return isHotelSortedByValue(hotels, comparatorByRating);
    }

    public boolean isHotelSortedByPrice(List<Hotel> hotels) {
        return isHotelSortedByValue(hotels, comparatorByPrice);
    }

    private boolean isHotelSortedByValue(List<Hotel> hotels, Comparator<Hotel> comparator) {
        List<Hotel> sortedHotels = new ArrayList<>(hotels);
        Collections.sort(sortedHotels, comparator);
        logger.info("Are hotel lists equal? {}", hotels.equals(sortedHotels));
        return hotels.equals(sortedHotels);
    }

    private Comparator<Hotel> comparatorByRating = (h1, h2) -> {
        if (h1.getRating() > h2.getRating()) return -1;
        else if (h1.getRating() < h2.getRating()) return 1;
        else return 0;
    };

    private Comparator<Hotel> comparatorByPrice = (h1, h2) -> {
        if (h1.getPrice() > h2.getPrice()) return 1;
        else if (h1.getPrice() < h2.getPrice()) return -1;
        else return 0;
    };
}
