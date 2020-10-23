package page.net.skyscanner.car;

import org.openqa.selenium.WebElement;
import page.AbstractPage;

import java.util.List;

import static service.ActionManager.getElementsBy;

public class VipCarsChooseYourCarPage extends AbstractPage {
    private static final String CAR_PRISE = "//span[@class='scv-new-amount']";
    private static final String SELECT_BUTTON = "//button[@class='scv-select']";

    public String getCarPriseFromElementOfList(int numberOfElement) {
        List<WebElement> carsList = getElementsBy(CAR_PRISE);
        String[] arr = carsList.get(numberOfElement).getText().split(" ");
        return arr[1];
    }

    public VipCarsReserveYourCarPage clickOnSelectButton(int numberOfButton) {
        List<WebElement> buttonsList = getElementsBy(SELECT_BUTTON);
        buttonsList.get(numberOfButton).click();
        return new VipCarsReserveYourCarPage();
    }
}
