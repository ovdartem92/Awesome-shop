package net.skyscanner.ta.framework.browser;

import net.skyscanner.ta.utils.DirectoryGenerator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public enum Browser {
    INSTANCE;

    private String screenshotDirectoryPath;

    public void stop() {
        getWrappedDriver().quit();
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
        return getWrappedDriver().findElement(locator).isSelected();
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
        screenshotDirectoryPath = DirectoryGenerator.create("screenshots_2");
        String screenshotPath = String.format("%s/%s.png", screenshotDirectoryPath, System.nanoTime());
        File screenshotFile = ((TakesScreenshot) getWrappedDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotFile;
    }

    public void openNewTab() {
        JavascriptExecutor executor = (JavascriptExecutor) getWrappedDriver();
        executor.executeScript("window.open();");
    }

    public void switchTab(String windowHandle) {
        for (String tab : getWrappedDriver().getWindowHandles()) {
            if (tab.equals(windowHandle)) {
                getWrappedDriver().switchTo().window(tab);
            }
        }
    }

    public void switchTabByIndex(int index) {
        List<String> allTabs = new ArrayList<>(getWrappedDriver().getWindowHandles());
        getWrappedDriver().switchTo().window(allTabs.get(index));
    }

    public void closeTab(String windowHandle) {
        for (String tab : getWrappedDriver().getWindowHandles()) {
            if (tab.equals(windowHandle)) {
                Browser.INSTANCE.getWrappedDriver().close();
            }
        }
    }
}
