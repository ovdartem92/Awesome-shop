package service;

import pages.net.skyscanner.cars.CarsSearchResultsScreen;
import pages.net.skyscanner.elements.HeaderScreen;

import java.util.List;

public class CarSearchService {
    private HeaderScreen headerScreen = new HeaderScreen();

    public CarsSearchResultsScreen searchCarUsingLocationsData(String pickUpLock, String dropOffLock) {
        headerScreen.clickCarButton()
                .choiceReturnCarToADifferentLocation()
                .setUpPickUpLocation(pickUpLock)
                .setUpDropOffLocation(dropOffLock)
                .clickSearchButton();
        return new CarsSearchResultsScreen();
    }

    public List<String> getCarClassTypeInfoFromSearchResults(String pickUpLock, String carClass, String carType) {
        return headerScreen.clickCarButton()
                .setUpPickUpLocation(pickUpLock)
                .clickSearchButton()
                .setCarClass(carClass)
                .setCarType(carType)
                .getListCarClassTypeFromGroupPanel();
    }
}
