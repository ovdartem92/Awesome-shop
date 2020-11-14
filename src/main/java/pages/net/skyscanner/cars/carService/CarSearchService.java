package pages.net.skyscanner.cars.carService;

import pages.net.skyscanner.cars.CarsSearchResultsScreen;
import pages.net.skyscanner.cars.CarsSearchScreen;

public class CarSearchService {
    CarsSearchScreen carsSearchScreen = new CarsSearchScreen();

    public CarsSearchResultsScreen searchCarUsingLocationsData(String pickUpLock, String dropOffLock) {
        carsSearchScreen.choiceReturnCarToADifferentLocation();
        carsSearchScreen.setUpPickUpLocation(pickUpLock);
        carsSearchScreen.setUpDropOffLocation(dropOffLock);
        carsSearchScreen.clickSearchButton();
        return new CarsSearchResultsScreen();
    }
}
