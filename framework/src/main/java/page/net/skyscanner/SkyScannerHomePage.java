package page.net.skyscanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;

public class SkyScannerHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://www.skyscanner.net/";
    private WebElement element;

    public SkyScannerHomePage(WebDriver driver) {
        super(driver);
    }

    public SkyScannerHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10);
        return this;
    }

    public static String getHomepageUrl() {
        return HOMEPAGE_URL;
    }
}
