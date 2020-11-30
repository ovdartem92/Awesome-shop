package net.skyscanner.ta.product.services;

import model.Hotel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.net.skyscanner.hotels.HotelsResultScreen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The service class for hotel result screen.
 */
public class HotelsResultService {
    private static final Logger logger = LogManager.getRootLogger();
    private final HotelsResultScreen hotelsResultScreen;
    /**
     * The comparator for sorting items by rating.
     */
    private final Comparator<Hotel> comparatorByRating = Comparator.comparingDouble(Hotel::getRating).reversed();
    /**
     * The comparator for sorting items by price.
     */
    private final Comparator<Hotel> comparatorByPrice = Comparator.comparingInt(Hotel::getPrice);

    /**
     * The constructor initializing the hotel result screen entity.
     *
     * @param hotelsResultScreen contains a hotel result screen entity
     */
    public HotelsResultService(HotelsResultScreen hotelsResultScreen) {
        this.hotelsResultScreen = hotelsResultScreen;
    }

    /**
     * The method that returns a collection of hotels containing the hotel name, cost, and hotel rating.
     *
     * @return collection of hotels
     */
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

    /**
     * The method returns the text of the found element by the passed locator inside the web element,
     * or null if the element is not found.
     *
     * @param element contains a element within which the search will be performed
     * @param locator contains a path along which the search will be carried out
     * @return text inside the web element, or null if the element is not found
     */
    public String getText(WebElement element, String locator) {
        try {
            return element.findElement(By.xpath(locator)).getText();
        } catch (NoSuchElementException e) {
            logger.debug("Find element with next xpath: {}", locator);
            logger.debug("Exception: {}", e.getMessage());
            return null;
        }
    }

    /**
     * The method that returns a boolean value, whether the passed collection is sorted by hotel rating or not.
     *
     * @param hotels contains a hotel collection
     * @return boolean value for hotel rating sorting
     */
    public boolean isHotelSortedByRating(List<Hotel> hotels) {
        return isHotelSortedByValue(hotels, comparatorByRating);
    }

    /**
     * The method that returns a boolean value, whether the passed collection is sorted by hotel price or not.
     *
     * @param hotels contains a hotel collection
     * @return boolean value for hotel price sorting
     */
    public boolean isHotelSortedByPrice(List<Hotel> hotels) {
        return isHotelSortedByValue(hotels, comparatorByPrice);
    }

    /**
     * The method checks is the hotel collection sorted by the passed comparator or not.
     *
     * @param hotels     contains a hotel collection
     * @param comparator contains a hotels comparator
     * @return boolean value for hotel comparator sorting
     */
    private boolean isHotelSortedByValue(List<Hotel> hotels, Comparator<Hotel> comparator) {
        List<Hotel> sortedHotels = new ArrayList<>(hotels);
        sortedHotels.sort(comparator);
        logger.info("Are hotel lists equal? {}", hotels.equals(sortedHotels));
        return hotels.equals(sortedHotels);
    }
}
