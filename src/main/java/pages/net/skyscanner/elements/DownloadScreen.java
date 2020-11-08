package pages.net.skyscanner.elements;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractScreen;
import pages.net.skyscanner.cars.VipCarsChooseYourCarScreen;
import service.WaitManager;

public class DownloadScreen extends AbstractScreen {
    private static final String REDIRECT_LOCATOR = "//div[@id='Redirect']";

    public VipCarsChooseYourCarScreen waitForDownloadVipCars() {
        //WaitManager.waitForInvisibilityOfElementLocated(REDIRECT_LOCATOR, Browser.LONG_TIMEOUT_SECONDS);
        new WebDriverWait(Browser.getDriver(), 30).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(REDIRECT_LOCATOR)));
        return new VipCarsChooseYourCarScreen();
    }
}
