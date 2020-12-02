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

public enum Browser implements WrapsDriver {
    INSTANCE();

    private final WebDriver wrappedDriver = WebDriverFactory.getWebDriver(BrowserType.valueOf(System.getProperty("browser").toUpperCase()));

    Browser() {
    }

    public Browser getInstance() {
        return INSTANCE;
    }

    public void stop() {
        wrappedDriver.quit();
    }

    public void navigate(String url) {
        Objects.requireNonNull(url, "URL cannot be null.");
        wrappedDriver.get(url);
    }

    public void click(By locator) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        wrappedDriver.findElement(locator).click();
    }

    public boolean isSelected(By locator) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        return wrappedDriver.findElement(locator).isSelected();
    }

    public void select(By locator, String option) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        Objects.requireNonNull(option, "OPTION cannot be null.");
        click(locator);
        Select select = new Select(wrappedDriver.findElement(locator));
        select.selectByVisibleText(option);
    }

    public void sendKeys(By locator, CharSequence... keysToSend) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        Objects.requireNonNull(keysToSend, "KEYS TO SEND cannot be null.");
        wrappedDriver.findElement(locator).sendKeys(keysToSend);
    }

    public void clear(By locator) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        wrappedDriver.findElement(locator).clear();
    }

    public void reloadPage() {
        wrappedDriver.get(wrappedDriver.getCurrentUrl());
    }

    public String getText(By locator) {
        Objects.requireNonNull(locator, "LOCATOR cannot be null.");
        return wrappedDriver.findElement(locator).getText();
    }

    public File takeScreenshot() {
        String screenshotDirectoryPath = DirectoryGenerator.create("screenshots");
        String screenshotPath = String.format("%s/%s.png", screenshotDirectoryPath, System.nanoTime());
        File screenshotFile = ((TakesScreenshot) wrappedDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotFile;
    }

    public void openNewTab() {
        ((JavascriptExecutor) wrappedDriver).executeScript("window.open();");
    }

    public void switchTab(String windowHandle) {
        Objects.requireNonNull(windowHandle, "WINDOW HANDLE cannot be null.");
        for (String tab : wrappedDriver.getWindowHandles()) {
            if (tab.equals(windowHandle)) {
                wrappedDriver.switchTo().window(tab);
            }
        }
    }

    public void switchTabByIndex(int index) {
        Objects.requireNonNull(index, "INDEX cannot be null.");
        List<String> allTabs = new ArrayList<>(wrappedDriver.getWindowHandles());
        wrappedDriver.switchTo().window(allTabs.get(index));
    }

    public void closeTab(String windowHandle) {
        Objects.requireNonNull(windowHandle, "WINDOW HANDLE cannot be null.");
        for (String tab : wrappedDriver.getWindowHandles()) {
            if (tab.equals(windowHandle)) {
                wrappedDriver.close();
            }
        }
    }

    @Override
    public WebDriver getWrappedDriver() {
        System.out.println("Getting WebDriver");
        return wrappedDriver;
    }
}
