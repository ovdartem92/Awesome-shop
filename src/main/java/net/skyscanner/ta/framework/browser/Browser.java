package net.skyscanner.ta.framework.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;


public enum Browser {
    INSTANCE;

    public void stop() {
        for (String handle : getWrappedDriver().getWindowHandles()) {
            getWrappedDriver().switchTo().window(handle);
            getWrappedDriver().close();
        }
        getWrappedDriver().close();
    }

    public void navigate(String url) {
        getWrappedDriver().get(url);
    }

    public WebDriver getWrappedDriver() {
        return WebDriverFactory.getWebDriver(BrowserType.valueOf(System.getProperty("browser").toUpperCase()));
    }

    public void click(By locator) {
        getWrappedDriver().findElement(locator).click();
    }

    public boolean isSelected(By locator) {
        //implement later
        return true;
    }

    public void select(By locator, String option) {
        click(locator);
        Select select = new Select(getWrappedDriver().findElement(locator));
        select.selectByVisibleText(option);
    }

    public void sendKeys(By locator, CharSequence... keysToSend) {
        getWrappedDriver().findElement(locator).sendKeys(keysToSend);
    }

    public void clear(By locator) {
        getWrappedDriver().findElement(locator).clear();
    }

    public void reloadPage() {
        getWrappedDriver().get(getWrappedDriver().getCurrentUrl());
    }

    public String getText(By locator) {
        return getWrappedDriver().findElement(locator).getText();
    }

    public File takeScreenshot() {
        //extended realization will be later
        File scrShot = ((TakesScreenshot) getWrappedDriver()).getScreenshotAs(OutputType.FILE);
        return scrShot;
    }

    public void switchTab(String windowHandle) {
        //implement later
    }

    public void closeTab(String windowHandle) {
        //implement later
    }
}
