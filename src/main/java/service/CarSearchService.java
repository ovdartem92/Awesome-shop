package service;

import pages.net.skyscanner.elements.HeaderScreen;

public class CarSearchService {
    HeaderScreen headerScreen = new HeaderScreen();

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
}
