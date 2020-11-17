package pages.net.skyscanner.cars.carService;

import pages.net.skyscanner.cars.CarsSearchResultsScreen;
import pages.net.skyscanner.elements.HeaderScreen;

public class CarSearchService {
    HeaderScreen headerScreen = new HeaderScreen();
    CarsSearchResultsScreen carsSearchResultsScreen = new CarsSearchResultsScreen();

    public CarsSearchResultsScreen searchCarUsingLocationsData(String pickUpLock, String dropOffLock) {
        headerScreen.clickCarButton()
                .choiceReturnCarToADifferentLocation()
                .setUpPickUpLocation(pickUpLock)
                .setUpDropOffLocation(dropOffLock)
                .clickSearchButton();
        return new CarsSearchResultsScreen();
    }

    public CarsSearchResultsScreen searchCarUsingPickUpLocation(String pickUpLock) {
        headerScreen.clickCarButton()
                .setUpPickUpLocation(pickUpLock)
                .clickSearchButton();
        return new CarsSearchResultsScreen();
    }

    public void setCheckboxForCarClassAndType(String carClass, String carType) {
        carsSearchResultsScreen.setCarClass(carClass).setCarType(carType);
    }
}
