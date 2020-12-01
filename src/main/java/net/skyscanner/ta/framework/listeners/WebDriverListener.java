package net.skyscanner.ta.framework.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class WebDriverListener extends AbstractWebDriverEventListener {
    private final Logger logger = LogManager.getRootLogger();

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        logger.info("Before alert acceptance");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        logger.info("Before navigate to {}", url);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Before find by web element with locator |{}|", by);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("Before click on element {}", element);
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        logger.info("Before change value of element {} to {}", element, keysToSend);
    }
}
