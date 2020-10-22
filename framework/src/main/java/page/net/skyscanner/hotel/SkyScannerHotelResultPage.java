package page.net.skyscanner.hotel;

import model.Hotel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.AbstractPage;
import java.util.List;
import static service.ActionManager.clickOnElementBy;
import static service.ActionManager.getTextOnElementBy;
import static service.WaitManager.waitForElementLocatedBy;

public class SkyScannerHotelResultPage extends AbstractPage {

    private final static String SEARCH_SUMMARY_PATH = "//p[@data-test-id='search-summary']";
    private final static String GUEST_RATING_SORT_BUTTON_PATH = "//button/span[contains(text(), 'Guest rating')]";
    private final static String PRICE_SORT_BUTTON_PATH = "//button/span[contains(text(), 'Price')]";
    private final static String FOUND_HOTEL_NAME_PATH = "//span[@data-test-id='hotel-name']";
    private final static String FOUND_HOTEL_PATH = "//div[@class='HotelCard_HotelCard__reviewSummary__1Rqp3']/span";

    private static String FOUND_HOTEL_RATING_WITH_HOTEL_NAME_PATH = "//span[@data-test-id='hotel-name'][contains(text(), '%s')]" +
            "/../following-sibling::div[@class='HotelCard_HotelCard__reviewSummary__1Rqp3']/span";
    private static String FOUND_HOTEL_PRICE_WITH_HOTEL_NAME_PATH = "//span[@data-test-id='hotel-name'][contains(text(), '%s')]" +
            "/../../../../following-sibling::div//div[@class='HotelCard_HotelCard__priceVariant__3dC83']";
    private List<Hotel> hotels;

    public int getFoundHotelsQuantity() {
        String searchSummaryLine = getTextOnElementBy(SEARCH_SUMMARY_PATH);
        return Integer.parseInt(searchSummaryLine.split(" ")[0]);
    }

    public SkyScannerHotelResultPage clickToGuestRattingSortButton() {
        clickOnElementBy(GUEST_RATING_SORT_BUTTON_PATH);
        return this;
    }

    public SkyScannerHotelResultPage clickToPriceSortButton() {
        clickOnElementBy(PRICE_SORT_BUTTON_PATH);
        return this;
    }

    public boolean isHotelsSortedByPrice() {
        boolean answer = true;
        this.getHotelsList();

        if (hotels.size() <= 1) {
            return answer;
        } else {
            for (int i = 0; i < hotels.size() - 1; i++) {
                if (hotels.get(i).getPrice() == -1 || hotels.get(i + 1).getPrice() == -1)
                    continue;
                if (hotels.get(i).getPrice() > hotels.get(i + 1).getPrice())
                    return !answer;
            }
        }
        return answer;
    }

    public boolean isHotelsSortedByRating() {
        boolean answer = true;
        this.getHotelsList();

        if (hotels.size() <= 1) {
            return answer;
        } else {
            for (int i = 0; i < hotels.size() - 1; i++) {
                if (hotels.get(i).getRating() == -1 || hotels.get(i + 1).getRating() == -1)
                    continue;
                if (hotels.get(i).getRating() > hotels.get(i + 1).getRating())
                    return !answer;
            }
        }
        return answer;
    }

    public List<Hotel> getHotelsList() {
        List<WebElement> names = getElementsByLocator(FOUND_HOTEL_NAME_PATH);

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i).getText();
            double rating = getHotelRatingsByHotelName(name);
            int price = getHotelPriceByHotelName(name);

            hotels.add(new Hotel(name, rating, price));
            logger.info(name + " - " + getHotelRatingsByHotelName(name) + " - " + getHotelPriceByHotelName(name));
        }
        return hotels;
    }

    private double getHotelRatingsByHotelName(String name) {
        By by = By.xpath(String.format(FOUND_HOTEL_RATING_WITH_HOTEL_NAME_PATH, name));
        if (driver.findElements(by).size() > 0) {
            return Double.parseDouble(driver.findElement(by).getText());
        } else {
            return -1d;
        }
    }

    private int getHotelPriceByHotelName(String name) {
        By by = By.xpath(String.format(FOUND_HOTEL_PRICE_WITH_HOTEL_NAME_PATH, name));
        if (driver.findElements(by).size() > 0) {
            return Integer.parseInt(driver.findElement(by).getText().split("[^0-9]+")[1]);
        } else {
            return -1;
        }
    }

    public List<WebElement> getElementsByLocator(String string) {
        waitForElementLocatedBy(string);
        return driver.findElements(By.xpath(string));
    }

    public int getQuantityOfWebElementsOnPage(String string) {
        waitForElementLocatedBy(string);
        List<WebElement> elements = driver.findElements(By.xpath(string));
        return elements.size();
    }

    public String getPathFromLocator(By by) {
        return by.toString().split(" ")[1].trim();
    }

    @Override
    public AbstractPage openPage() {
        return null;
    }
}
