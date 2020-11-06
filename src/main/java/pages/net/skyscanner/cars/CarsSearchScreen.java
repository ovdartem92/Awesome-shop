package pages.net.skyscanner.cars;

import pages.AbstractScreen;

public class CarsSearchScreen extends AbstractScreen {
    private static final String CAR_HEADLINE_LOCATOR = "//button[contains(@class,'Search')]";

    public String getTextFromCarHeadline() {
        return getTextOnElement(CAR_HEADLINE_LOCATOR);
    }
}

