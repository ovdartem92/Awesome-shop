package page;

import constants.Constants;
import driver.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.net.skyscanner.pageElements.Header;

public abstract class AbstractPage {
    public static final String CULTURE_SAVE_BUTTON_PATH = "//button[@id='culture-selector-save']";
    protected static final String WAITING_MODAL_VIEW = "//*[@class='WaitingModal_WaitingModal__container__2wluW']";
    public static Logger logger = LogManager.getRootLogger();

    public Header getHeader() {
        return new Header();
    }

    public void isWaitingModalViewOnPage() {
        new WebDriverWait(Browser.getDriver(), Constants.LONG_TIMEOUT_SECONDS).until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath(WAITING_MODAL_VIEW)));
    }
}
