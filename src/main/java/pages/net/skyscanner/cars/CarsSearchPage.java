package pages.net.skyscanner.cars;

import pages.AbstractPage;

public class CarsSearchPage extends AbstractPage {
    private static final String CAR_HEADER_LOCATOR = "//div[contains(@class,'search-controls-title')]";

    public String getTextFromCarHeader() {
        return getTextOnElement(CAR_HEADER_LOCATOR);
    }
}
