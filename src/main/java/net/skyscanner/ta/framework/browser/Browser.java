package net.skyscanner.ta.framework.browser;

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
    private final String screenshotDirectoryPath;

    private Browser() {
        BrowserType browserType = BrowserType.valueOf(System.getProperty("browser").toUpperCase());
        screenshotDirectoryPath = DirectoryGenerator.create("screenshots");
        //change to log later
        System.out.println("Creating instance of WebDriver for " + browserType);
        wrappedDriver = WebDriverFactory.getWebDriver(browserType);
        wrappedDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public static Browser getInstance() {
        //change to log later
        System.out.println("Getting instance of browser");
        if (instance == null) {
            instance = new Browser();
        }
        return instance;
    }

    public void stop() {
        //change to log later
        System.out.println("Stopping the browser");
        try {
            if (instance != null) {
                wrappedDriver.quit();
            }
        } finally {
            instance = null;
        }
    }

    public WebDriver getWrappedDriver() {
        //change to log later
        System.out.println("Getting WebDriver");
        return wrappedDriver;

    }

    public void navigate(String url) {
        Objects.requireNonNull(url, "URL cannot be null.");
        wrappedDriver.get(url);
    }

    public void click(By locator) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        WebElement webElement = wrappedDriver.findElement(locator);
        webElement.click();
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
        Select dropDownList = new Select(wrappedDriver.findElement(locator));
        dropDownList.selectByVisibleText(option);
    }

    public String getFirstSelectedOption(By locator) {
        Objects.requireNonNull(locator, "Locator cannot be null.");
        Select dropDownList = new Select(wrappedDriver.findElement(locator));
        String selectedOptionText = dropDownList.getFirstSelectedOption().getText();
        return selectedOptionText.replaceAll(" ", "").replaceAll("\n", "");
    }

    public void sendKeys(By locator, CharSequence... keysToSend) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        Objects.requireNonNull(keysToSend, "KEYS TO SEND cannot be null.");
        WebElement webElement = wrappedDriver.findElement(locator);
        webElement.sendKeys(keysToSend);
    }

    public void clear(By locator) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        WebElement webElement = wrappedDriver.findElement(locator);
        webElement.clear();
    }

    public void reloadPage() {
        wrappedDriver.navigate().refresh();
    }

    public String getText(By locator) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        //change to log later
        System.out.println(("Getting the text of WebElement located by " + locator));
        WebElement webElement = wrappedDriver.findElement(locator);
        return webElement.getText().trim();
    }

    public File takeScreenshot() {
        String screenshotPath = String.format("%s/%s.png", screenshotDirectoryPath, System.nanoTime());
        File screenshotFile = ((TakesScreenshot) wrappedDriver).getScreenshotAs(OutputType.FILE);
        try {
            byte[] screenshotBytes = ((TakesScreenshot) wrappedDriver).getScreenshotAs(OutputType.BYTES);
            FileUtils.writeByteArrayToFile(screenshotFile, screenshotBytes);
            //change to log later
            System.out.println("Screenshot has been saved as file: " + screenshotFile.getAbsolutePath());
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
}
