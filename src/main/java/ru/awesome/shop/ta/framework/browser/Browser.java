package ru.awesome.shop.ta.framework.browser;

import ru.awesome.shop.ta.framework.logging.Log;
import ru.awesome.shop.ta.framework.ui.elements.HighlightedWebElement;

import ru.awesome.shop.ta.utils.DirectoryGenerator;
import ru.awesome.shop.ta.utils.TestDataReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class Browser implements WrapsDriver {
    private static Browser instance;
    private final WebDriver wrappedDriver;
    private String screenshotDirectoryPath;

    private Browser() {
        BrowserType browserType = BrowserType.valueOf(System.getProperty("browser",
                TestDataReader.getStageData("browser")).toUpperCase());
        screenshotDirectoryPath = DirectoryGenerator.create("./target/screenshots");
        Log.debug("Creating instance of WebDriver for " + browserType);
        wrappedDriver = WebDriverFactory.getWebDriver(browserType);
        wrappedDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public static Browser getInstance() {
        Log.debug("Getting instance of browser");
        if (instance == null) {
            instance = new Browser();
        }
        return instance;
    }

    public void stop() {
        Log.debug("Stopping the browser");
        try {
            if (instance != null) {
                wrappedDriver.quit();
            }
        } finally {
            instance = null;
        }
    }

    public void navigate(String url) {
        Objects.requireNonNull(url, "URL cannot be null.");
        Log.debug("Navigating to " + url);
        wrappedDriver.get(url);
    }

    public void click(By locator) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        Log.debug("Click on " + locator);
        WebElement webElement = wrappedDriver.findElement(locator);
        HighlightedWebElement highlightedWebElement = new HighlightedWebElement(wrappedDriver, webElement);
        highlightedWebElement.click();
    }

    public boolean isSelected(By locator) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        WebElement webElement = wrappedDriver.findElement(locator);
        return webElement.isSelected();
    }

    public void select(By locator, String option) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        Objects.requireNonNull(option, "OPTION cannot be null.");
        click(locator);
        WebElement element = wrappedDriver.findElement(locator);
        HighlightedWebElement highlightedWebElement = new HighlightedWebElement(wrappedDriver, element);
        Select dropDownList = new Select(highlightedWebElement);
        Log.debug("Selecting " + option);
        dropDownList.selectByVisibleText(option);
    }

    public String getFirstSelectedOption(By locator) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        Log.debug("Selecting the first option from " + locator);
        WebElement element = wrappedDriver.findElement(locator);
        HighlightedWebElement highlightedWebElement = new HighlightedWebElement(wrappedDriver, element);
        Select dropDownList = new Select(highlightedWebElement);
        String selectedOptionText = dropDownList.getFirstSelectedOption().getText();
        return selectedOptionText.replaceAll(" ", "").replaceAll("\n", "");
    }

    public void sendKeys(By locator, CharSequence... keysToSend) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        Objects.requireNonNull(keysToSend, "KEYS TO SEND cannot be null.");
        Log.debug("Send text " + keysToSend + " to " + locator);
        WebElement webElement = wrappedDriver.findElement(locator);
        HighlightedWebElement highlightedWebElement = new HighlightedWebElement(wrappedDriver, webElement);
        highlightedWebElement.sendKeys(keysToSend);
    }

    public void clear(By locator) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        Log.debug("Clearing field " + locator);
        WebElement webElement = wrappedDriver.findElement(locator);
        HighlightedWebElement highlightedWebElement = new HighlightedWebElement(wrappedDriver, webElement);
        highlightedWebElement.clear();
    }

    public void reloadPage() {
        Log.debug("Reloading page " + wrappedDriver.getCurrentUrl());
        wrappedDriver.navigate().refresh();
    }

    public String getText(By locator) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        Log.debug("Getting the text of WebElement located by " + locator);
        WebElement webElement = wrappedDriver.findElement(locator);
        HighlightedWebElement highlightedWebElement = new HighlightedWebElement(wrappedDriver, webElement);
        return highlightedWebElement.getText().trim();
    }

    public File takeScreenshot() {
        String screenshotPath = String.format("%s/%s.png", screenshotDirectoryPath, System.nanoTime());
        File screenshotFile = ((TakesScreenshot) wrappedDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            Log.debug("Screenshot has been saved as file: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotFile;
    }

    public String openNewTab() {
        Log.debug("Opening new tab");
        ArrayList<String> oldTabs = new ArrayList<>(wrappedDriver.getWindowHandles());
        JavascriptExecutor executor = (JavascriptExecutor) wrappedDriver;
        executor.executeScript("window.open('','_blank');");
        ArrayList<String> newTabs = new ArrayList<>(wrappedDriver.getWindowHandles());
        newTabs.removeAll(oldTabs);
        return newTabs.get(0);
    }

    public void switchTab(String windowHandle) {
        Objects.requireNonNull(windowHandle, "Window handle cannot be null.");
        Log.debug("Switching to the next tab " + windowHandle);
        wrappedDriver.switchTo().window(windowHandle);
    }

    public void switchTabByIndex(int index) {
        Objects.requireNonNull(index, "INDEX cannot be null.");
        Log.debug("Switching to the tab with index " + index);
        List<String> allTabs = new ArrayList<>(wrappedDriver.getWindowHandles());
        wrappedDriver.switchTo().window(allTabs.get(index));
    }

    public void closeTab(String windowHandle) {
        Objects.requireNonNull(windowHandle, "Window handle cannot be null.");
        Log.debug("Closing the next tab " + windowHandle);
        switchTab(windowHandle);
        wrappedDriver.close();
    }

    public String getPageTitle() {
        return wrappedDriver.getTitle();
    }

    public String getAttribute(By locator, String attribute) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        Objects.requireNonNull(locator, "ATTRIBUTE cannot be null.");
        WebElement webElement = wrappedDriver.findElement(locator);
        return webElement.getAttribute(attribute);
    }

    @Override
    public WebDriver getWrappedDriver() {
        Log.debug("Getting WebDriver");
        return wrappedDriver;
    }
}
