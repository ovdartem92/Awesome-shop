package pages.net.skyscanner.cars;

import pages.AbstractScreen;
import pages.net.skyscanner.cars.carService.CarSearchService;

public class CarsSearchScreen extends AbstractScreen {
    CarSearchService carSearchService = new CarSearchService();
    private static final String CAR_HEADLINE_LOCATOR = "//div[contains(@class,'controls-title')]";

    public String getTextFromCarHeadline() {
        return getTextOnElement(CAR_HEADLINE_LOCATOR);
    }

    public CarsSearchResultsScreen searchCarUsingLocationsData(String pickUpLock, String dropOffLock) {
        carSearchService.choiceReturnCarToADifferentLocation();
        carSearchService.setUpPickUpLocation(pickUpLock);
        carSearchService.setUpDropOffLocation(dropOffLock);
        carSearchService.clickSearchButton();
        return new CarsSearchResultsScreen();
    }
}