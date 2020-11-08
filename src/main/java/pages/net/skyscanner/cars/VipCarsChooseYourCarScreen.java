package pages.net.skyscanner.cars;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractScreen;

import java.util.List;

public class VipCarsChooseYourCarScreen extends AbstractScreen {
    private static final String CAR_PRISE_LOCATOR = "//span[contains(@id,'car_price')]";
    private static final String SELECT_BUTTON_LOCATOR = "//button[contains(@onclick,'book_car')]";
    //private static final String BE_PANEL_BODY_LOCATOR = "//div[@class='be_panel-body']";
    //private static final String REDIRECT_LOCATOR = "//div[@id='Redirect']";
    private static final String REDIRECT_LOCATOR = "//*[contains(text(),'Thank you, almost there')]";

    public String getCarPriseFromElementOfList(int numberOfElement) {
        new WebDriverWait(Browser.getDriver(), 20).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(REDIRECT_LOCATOR)));
        System.out.println("VIP CARS PAGE IS LOADED");
        clickOnElement("//img[@title='VIP Cars']");
        System.out.println("CLICKED ON TITLE");
        //List<WebElement> carsList = getElements(CAR_PRISE_LOCATOR);
        //String[] arr = carsList.get(numberOfElement).getText().split(" ");
        String txt = getTextOnElement(CAR_PRISE_LOCATOR);
        System.out.println("CAR_PRISE = " + txt);
        return txt;
    }

    public VipCarsReserveYourCarScreen clickOnSelectButtonOnVipPage(int numberOfButton) {
        List<WebElement> buttonsList = getElements(SELECT_BUTTON_LOCATOR);
        buttonsList.get(numberOfButton).click();
        System.out.println("clicked on SELECT_BUTTON" + numberOfButton);
        return new VipCarsReserveYourCarScreen();
    }


}
