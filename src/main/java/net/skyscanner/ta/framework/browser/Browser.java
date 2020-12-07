package net.skyscanner.ta.framework.browser;

import net.skyscanner.ta.framework.logging.Log;
import net.skyscanner.ta.framework.ui.elements.HighlightedWebElement;
import net.skyscanner.ta.utils.DirectoryGenerator;
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
    private HighlightedWebElement highlightedWebElement;

    private Browser() {
        BrowserType browserType = BrowserType.valueOf(System.getProperty("browser").toUpperCase());
        screenshotDirectoryPath = DirectoryGenerator.create("screenshots");
        Log.info("Creating instance of WebDriver for " + browserType);
        wrappedDriver = WebDriverFactory.getWebDriver(browserType);
        wrappedDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public static Browser getInstance() {
        Log.info("Getting instance of browser");
        if (instance == null) {
            instance = new Browser();
        }
        return instance;
    }

    public void stop() {
        Log.info("Stopping the browser");
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
        wrappedDriver.get(url);
    }

    public void click(By locator) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        WebElement webElement = wrappedDriver.findElement(locator);
        highlightedWebElement = new HighlightedWebElement(wrappedDriver, webElement);
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
        highlightedWebElement = new HighlightedWebElement(wrappedDriver, element);
        Select dropDownList = new Select(highlightedWebElement);
        dropDownList.selectByVisibleText(option);
    }

    public String getFirstSelectedOption(By locator) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        WebElement element = wrappedDriver.findElement(locator);
        highlightedWebElement = new HighlightedWebElement(wrappedDriver, element);
        Select dropDownList = new Select(highlightedWebElement);
        String selectedOptionText = dropDownList.getFirstSelectedOption().getText();
        return selectedOptionText.replaceAll(" ", "").replaceAll("\n", "");
    }

    public void sendKeys(By locator, CharSequence... keysToSend) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        Objects.requireNonNull(keysToSend, "KEYS TO SEND cannot be null.");
        WebElement webElement = wrappedDriver.findElement(locator);
        highlightedWebElement = new HighlightedWebElement(wrappedDriver, webElement);
        highlightedWebElement.sendKeys(keysToSend);
    }

    public void clear(By locator) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        WebElement webElement = wrappedDriver.findElement(locator);
        highlightedWebElement = new HighlightedWebElement(wrappedDriver, webElement);
        highlightedWebElement.clear();
    }

    public void reloadPage() {
        wrappedDriver.navigate().refresh();
    }

    public String getText(By locator) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        Log.info("Getting the text of WebElement located by " + locator);
        WebElement webElement = wrappedDriver.findElement(locator);
        highlightedWebElement = new HighlightedWebElement(wrappedDriver, webElement);
        return highlightedWebElement.getText().trim();
    }

    public File takeScreenshot() {
        screenshotDirectoryPath = DirectoryGenerator.create("screenshots");
        String screenshotPath = String.format("%s/%s.png", screenshotDirectoryPath, System.nanoTime());
        File screenshotFile = ((TakesScreenshot) wrappedDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            Log.info("Screenshot has been saved as file: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotFile;
    }

    public String openNewTab() {
        ArrayList<String> oldTabs = new ArrayList<>(wrappedDriver.getWindowHandles());
        JavascriptExecutor executor = (JavascriptExecutor) wrappedDriver;
        executor.executeScript("window.open('','_blank');");
        ArrayList<String> newTabs = new ArrayList<>(wrappedDriver.getWindowHandles());
        newTabs.removeAll(oldTabs);
        return newTabs.get(0);
    }

    public void switchTab(String windowHandle) {
        Objects.requireNonNull(windowHandle, "Window handle cannot be null.");
        wrappedDriver.switchTo().window(windowHandle);
    }

    public void switchTabByIndex(int index) {
        Objects.requireNonNull(index, "INDEX cannot be null.");
        List<String> allTabs = new ArrayList<>(wrappedDriver.getWindowHandles());
        wrappedDriver.switchTo().window(allTabs.get(index));
    }

    public void closeTab(String windowHandle) {
        Objects.requireNonNull(windowHandle, "Window handle cannot be null.");
        switchTab(windowHandle);
        wrappedDriver.close();
    }

    @Override
    public WebDriver getWrappedDriver() {
        Log.info("Getting WebDriver");
        return wrappedDriver;
    }
}
