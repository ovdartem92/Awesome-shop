package pages.net.skyscanner.cars.car_service;

import pages.net.skyscanner.cars.CarsSearchResultsScreen;
import pages.net.skyscanner.elements.HeaderScreen;

public class CarSearchService {
    private final HeaderScreen headerScreen = new HeaderScreen();

    public CarsSearchResultsScreen searchCarUsingLocationsData(String pickUpLock, String dropOffLock) {
        headerScreen.clickCarButton()
                .choiceReturnCarToADifferentLocation()
                .setUpPickUpLocation(pickUpLock)
                .setUpDropOffLocation(dropOffLock)
                .clickSearchButton();
        return new CarsSearchResultsScreen();
    }
}
