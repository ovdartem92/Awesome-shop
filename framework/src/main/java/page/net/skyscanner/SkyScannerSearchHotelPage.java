package page.net.skyscanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.AbstractPage;

import static util.Utils.waitForElementLocatedBy;

public class SkyScannerSearchHotelPage extends AbstractPage {
    protected SkyScannerSearchHotelPage(WebDriver driver) {
        super(driver);
    }
    private static final By DESTINATION_OR_HOSTEL_NAME_INPUT = By.xpath("//input[@name='destination-autosuggest']");
    private static final By HOSTEL_CHECK_IN_INPUT = By.xpath("//input[@id='checkin']");
    private static final By HOSTEL_CHECK_OUT_INPUT = By.xpath("//input[@id='checkout']");
    private static final By GUESTS_AND_ROOM_INPUT = By.xpath("//input[@id='guests-rooms']");
    private static final By SEARCH_HOTEL_BUTTON = By.xpath("//button[contains(text(), 'Search hotels')]");
    private static final By QUANTITY_ROOMS_INPUT = By.xpath("//input[@id='rooms']");
    private static final By INCREASE_ROOM_BUTTON = By.xpath("//button[@aria-controls='rooms'][@title='Increase']");
    private static final By DECREASE_ROOM_BUTTON = By.xpath("//button[@aria-controls='rooms'][@title='Decrease']");
    private static final By QUANTITY_ADULT_PEOPLE_INPUT = By.xpath("//input[@id='adults']");
    private static final By INCREASE_ADULT_BUTTON = By.xpath("//button[@aria-controls='adults'][@title='Increase']");
    private static final By DECREASE_ADULT_BUTTON = By.xpath("//button[@aria-controls='adults'][@title='Decrease']");
    private static final By QUANTITY_CHILDREN_INPUT = By.xpath("//input[@id='children']");
    private static final By INCREASE_CHILD_BUTTON = By.xpath("//button[@aria-controls='children'][@title='Increase']");
    private static final By DECREASE_CHILD_BUTTON = By.xpath("//button[@aria-controls='children'][@title='Decrease']");
    private static final By DONE_BUTTON = By.xpath("//footer/button");
    private static final By SEARCH_HOTELS_BUTTON = By.xpath("//form[@id='search-controls']//button");

    public SkyScannerSearchHotelPage addDestination(String destination) {
        waitForElementLocatedBy(driver, DESTINATION_OR_HOSTEL_NAME_INPUT).click();
        waitForElementLocatedBy(driver, DESTINATION_OR_HOSTEL_NAME_INPUT).sendKeys(destination);
        return this;
    }

    public SkyScannerSearchHotelPage increaseRoom() {
        waitForElementLocatedBy(driver, GUESTS_AND_ROOM_INPUT).click();
        waitForElementLocatedBy(driver, INCREASE_ROOM_BUTTON).click();
        waitForElementLocatedBy(driver, DONE_BUTTON).click();
        return this;
    }

    public SkyScannerSearchHotelPage increaseRoom(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseRoom();
        return this;
    }

    public SkyScannerSearchHotelPage increaseAdult() {
        waitForElementLocatedBy(driver, GUESTS_AND_ROOM_INPUT).click();
        waitForElementLocatedBy(driver, INCREASE_ADULT_BUTTON).click();
        waitForElementLocatedBy(driver, DONE_BUTTON).click();
        return this;
    }

    public SkyScannerSearchHotelPage increaseAdult(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseAdult();
        return this;
    }

    public SkyScannerSearchHotelPage increaseChild() {
        waitForElementLocatedBy(driver, GUESTS_AND_ROOM_INPUT).click();
        waitForElementLocatedBy(driver, INCREASE_CHILD_BUTTON).click();
        waitForElementLocatedBy(driver, DONE_BUTTON).click();
        return this;
    }

    public SkyScannerSearchHotelPage increaseChild(int quantity) {
        for (int i = 0; i < quantity; i++)
            increaseChild();
        return this;
    }

    public String getQuantityRooms() {
        waitForElementLocatedBy(driver, GUESTS_AND_ROOM_INPUT).click();
        String quantity = waitForElementLocatedBy(driver, QUANTITY_ROOMS_INPUT).getAttribute("value");
        waitForElementLocatedBy(driver, DONE_BUTTON).click();
        return quantity;
    }

    public String getQuantityAdultPeople() {
        waitForElementLocatedBy(driver, GUESTS_AND_ROOM_INPUT).click();
        String quantity = waitForElementLocatedBy(driver, QUANTITY_ADULT_PEOPLE_INPUT).getAttribute("value");
        waitForElementLocatedBy(driver, DONE_BUTTON).click();
        return quantity;
    }

    public String getQuantityChildren() {
        waitForElementLocatedBy(driver, GUESTS_AND_ROOM_INPUT).click();
        String quantity = waitForElementLocatedBy(driver, QUANTITY_CHILDREN_INPUT).getAttribute("value");
        waitForElementLocatedBy(driver, DONE_BUTTON).click();
        return quantity;
    }

    public SkyScannerHotelResultPage clickToSearchHotelsButton() {
        waitForElementLocatedBy(driver, SEARCH_HOTELS_BUTTON).click();
        return new SkyScannerHotelResultPage(driver);
    }

    public String getTextFromHotelButton() {
        return waitForElementLocatedBy(driver, SEARCH_HOTEL_BUTTON).getText();
    }

}
