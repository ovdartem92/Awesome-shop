package net.skyscanner.ta.framework.browser;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;


public enum Browser {
    INSTANCE;

    public void stop() {
        for (String handle : getWrappedDriver().getWindowHandles()) {
            getWrappedDriver().switchTo().window(handle);
            getWrappedDriver().close();
        }
        WebDriverFactory.closeWebDriver();
    }

    public void openPage(String url) {
        getWrappedDriver().get(url);
    }

    public WebDriver getWrappedDriver() {
        return WebDriverFactory.getWebDriver(BrowserType.valueOf(System.getProperty("browser").toUpperCase()));
    }

    public void click(By locator) {
        getElement(locator).click();
    }

    public boolean isSelected(By locator) {
        //implement later
        return true;
    }

    public void select(By locator, String option) {
        click(locator);
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(option);
    }

    public void sendKeys(By locator, CharSequence... keysToSend) {
        getElement(locator).sendKeys(keysToSend);
    }

    public void clear(By locator) {
        getElement(locator).clear();
    }

    public void reloadPage() {
        getWrappedDriver().get(getWrappedDriver().getCurrentUrl());
    }

    public String getText(By locator) {
        return getElement(locator).getText();
    }

    public File takeScreenshot() {
        return ((TakesScreenshot) getWrappedDriver()).getScreenshotAs(OutputType.FILE);
    }

    public WebElement getElement(By locator) {
        return getWrappedDriver().findElement(locator);
    }

    public void openNewTab() {
        ((JavascriptExecutor) getWrappedDriver()).executeScript("window.open();");
    }

    public void switchTab(String windowHandle) {
        //implement later
    }

    public void closeTab(String windowHandle) {
        //implement later
    }
}
