package pages.net.skyscanner.cars;

import pages.AbstractScreen;
import service.WaitManager;


public class CarsSearchResultsScreen extends AbstractScreen {
    private static final String ALERT_AGE_MESSAGE = "//span[contains(text(), 'Driver aged under 25')]";

    public boolean isAgeAlertVisible() {
        return WaitManager.isElementVisible(ALERT_AGE_MESSAGE);
    }
}
