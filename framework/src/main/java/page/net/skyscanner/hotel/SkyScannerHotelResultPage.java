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

    private final static By SEARCH_SUMMARY_LOCATOR = By.xpath("//p[@data-test-id='search-summary']"); //
    private final static By GUEST_RATING_SORT_BUTTON_LOCATOR = By.xpath("//button/span[contains(text(), 'Guest rating')]"); //
    private final static By PRICE_SORT_BUTTON_LOCATOR = By.xpath("//button/span[contains(text(), 'Price')]"); //
    private final static By FOUND_HOTEL_NAME_LOCATOR = By.xpath("//span[@data-test-id='hotel-name']");
    private final static By FOUND_HOTEL_RATING = By.xpath("//div[@class='HotelCard_HotelCard__reviewSummary__1Rqp3']/span");
    private final static By FOUND_HOTEL_PRICE = By.xpath("//div[@class='HotelCard_HotelCard__priceVariant__3dC83']");

    private static String FOUND_HOTEL_RATING_WITH_HOTEL_NAME_PATH = "//span[@data-test-id='hotel-name'][contains(text(), '%s')]" +
            "/../following-sibling::div[@class='HotelCard_HotelCard__reviewSummary__1Rqp3']/span";
    private static String FOUND_HOTEL_PRICE_WITH_HOTEL_NAME_PATH = "//span[@data-test-id='hotel-name'][contains(text(), '%s')]" +
            "/../../../../following-sibling::div//div[@class='HotelCard_HotelCard__priceVariant__3dC83']";
    private List<Hotel> hotels;

    public int getFoundHotelsQuantity() {
        String searchSummaryLine = getTextOnElementBy(SEARCH_SUMMARY_LOCATOR);
        return Integer.parseInt(searchSummaryLine.split(" ")[0]);
    }

    public SkyScannerHotelResultPage clickToGuestRattingSortButton() {
        clickOnElementBy(GUEST_RATING_SORT_BUTTON_LOCATOR);
        return this;
    }

    public SkyScannerHotelResultPage clickToPriceSortButton() {
        clickOnElementBy(PRICE_SORT_BUTTON_LOCATOR);
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

    private List<Hotel> getHotelsList() {
        List<WebElement> names = getElementsByLocator(FOUND_HOTEL_NAME_LOCATOR);

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

    public List<WebElement> getElementsByLocator(By by) {
        waitForElementLocatedBy(by);
        return driver.findElements(by);
    }

    public int getQuantityOfWebElementsOnPage(By by) {
        waitForElementLocatedBy(by);
        List<WebElement> elements = driver.findElements(by);
        return elements.size();
    }

    public String getPathFromLocator(By by) {
        return by.toString().split(" ")[1].trim();
    }
}
