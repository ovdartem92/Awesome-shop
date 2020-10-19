//package page.net.skyscanner;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import page.AbstractPage;
//
//import static util.Waiter.*;
//
//public class SkyScannerCarSearchPage extends AbstractPage {
//    protected SkyScannerCarSearchPage(WebDriver driver) {
//        super(driver);
//    }
//    private static final By CAR_HEADER = By.xpath("//div[@class='SearchControls_search-controls-title__27T3N']");
//
//    public String getTextFromCarHeader() {
//        return waitForElementLocatedBy(driver, CAR_HEADER).getText();
//    }
//}
