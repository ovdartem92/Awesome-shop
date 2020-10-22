package page.net.skyscanner.car;

import page.AbstractPage;

import static service.ActionManager.*;
import static service.WaitManager.*;

public class VipCarsReserveYourCarPage extends AbstractPage {

    private static final String TOTAL_RENTAL_PRICE = "//span[@id='totalVehiclePrice']";

    public String getTotalRentalPrice() {
        waitForElementLocatedBy(TOTAL_RENTAL_PRICE);
        return getTextOnElementBy(TOTAL_RENTAL_PRICE);
    }

    @Override
    public AbstractPage openPage() {
        return null;
    }
}
