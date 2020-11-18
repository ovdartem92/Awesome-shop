package service;

import pages.net.skyscanner.cars.CarsSearchResultsScreen;
import pages.net.skyscanner.elements.HeaderScreen;

public class CarSearchService {
    HeaderScreen headerScreen = new HeaderScreen();

    public CarsSearchResultsScreen searchCarUsingLocationsData(String pickUpLock, String dropOffLock) {
        headerScreen.clickCarButton()
                .choiceReturnCarToADifferentLocation()
                .setUpPickUpLocation(pickUpLock)
                .setUpDropOffLocation(dropOffLock)
                .clickSearchButton();
        return new CarsSearchResultsScreen();
    }

    public CarsSearchResultsScreen searchCarUsingAgeAndPickUpLocation(String pickUpLock, String age) {
        headerScreen.clickCarButton()
                .unSetAgeCheckbox()
                .setDriverAge(age)
                .setUpPickUpLocation(pickUpLock)
                .clickSearchButton();
        return new CarsSearchResultsScreen();
    }
}
