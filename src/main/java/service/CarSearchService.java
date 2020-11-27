package service;

import pages.net.skyscanner.elements.HeaderScreen;

import java.util.List;

/**
 * The service class that performs actions to fill in the data for the cars search and performs the search itself.
 */
public class CarSearchService {
    private HeaderScreen headerScreen = new HeaderScreen();
    /**
     * This is a method that performs search cars using locations data.
     *
     * @param pickUpLoc  the necessary location for pick up car.
     * @param dropOffLoc the necessary location for leave car.
     * @return the screen with search results.
     */
    public void searchCarUsingLocationsData(String pickUpLock, String dropOffLock) {
        headerScreen.clickCarButton()
                .choiceReturnCarToADifferentLocation()
                .setUpPickUpLocation(pickUpLock)
                .setUpDropOffLocation(dropOffLock)
                .clickSearchButton();
    }

    public void searchCarUsingAgeAndPickUpLocation(String pickUpLock, String age) {
        headerScreen.clickCarButton()
                .unSetAgeCheckbox()
                .setDriverAge(age)
                .setUpPickUpLocation(pickUpLock)
                .clickSearchButton();
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
