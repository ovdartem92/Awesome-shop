package page;

import driver.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    protected WebDriver driver;

    public AbstractPage() {
        this.driver = Browser.getDriver();
    }

    public static Logger logger = LogManager.getRootLogger();

    public abstract AbstractPage openPage();
}
