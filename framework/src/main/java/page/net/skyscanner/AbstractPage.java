package page.net.skyscanner;

import driver.Browser;
import org.openqa.selenium.WebDriver;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage() {
        this.driver = Browser.getDriver();
    }
}
