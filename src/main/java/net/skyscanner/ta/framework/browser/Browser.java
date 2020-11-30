package net.skyscanner.ta.framework.browser;

import org.openqa.selenium.*;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public enum Browser {
    INSTANCE;

    public static void stop() {
        WebDriverFactory.closeWebDriver();
    }

    public static WebDriver getWrappedDriver() {
        return WebDriverFactory.getWebDriver(BrowserType.valueOf(System.getProperty("browser")));
    }

    public static void click(By locator) {
        getWrappedDriver().findElement(locator).click();
    }

    public static boolean isSelected(By locator) {
        //implement later
        return true;
    }

    public static void select(By locator, String option) {
        //implement later
    }

    public static void sendKeys(By locator, CharSequence... keysToSend) {
        getWrappedDriver().findElement(locator).sendKeys(keysToSend);
    }

    public void clear(By locator) {
        getWrappedDriver().findElement(locator).clear();
    }

    public void reloadPage() {
        getWrappedDriver().get(getWrappedDriver().getCurrentUrl());
    }

    public String getText(By locator) {
        //implement later
        return "";
    }

    public File takeScreenshot() {
        File scrShot = ((TakesScreenshot) getWrappedDriver()).getScreenshotAs(OutputType.FILE);
//        try {
//            Path path = Paths.get(".", "target", "screenshots", String.format("%s %s.png", getWrappedDriver().getTitle(), getCurrentTimeAsString()));
//            FileUtils.copyFile(scrShot, new File(path.toString()));
//        } catch (IOException e) {
//            System.out.println(String.format("Failed to save screenshots %s", e.getLocalizedMessage()));
//        }
        return scrShot;
    }

    //temp solution while class StringUtils isn't created

    public static String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }

    public static WebElement getElement(By locator) {
        return getWrappedDriver().findElement(locator);
    }

    public static void openNewTab() {
        sendKeys(By.tagName("Body"), Keys.CONTROL + "t");
//        or
//        ((JavascriptExecutor) getWrappedDriver()).executeScript("window.open();");
    }

    public static void switchTab(String windowHandle) {
        //implement later
    }

    public static void closeTab(String windowHandle) {
        //implement later
    }
}
