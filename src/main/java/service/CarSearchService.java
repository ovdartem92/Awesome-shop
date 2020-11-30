package service;

import pages.net.skyscanner.elements.HeaderScreen;

import java.util.List;

/**
 * The service class that performs actions to fill in the data for the cars search and performs the search itself.
 */
public class CarSearchService {
    private HeaderScreen headerScreen = new HeaderScreen();

    /**
     * The method performs search cars using pick up and drop off locations data.
     *
     * @param pickUpLock  the necessary location for pick up car.
     * @param dropOffLock the necessary location for leave car.
     */
    public void searchCarUsingLocationsData(String pickUpLock, String dropOffLock) {
        headerScreen.clickCarButton()
                .choiceReturnCarToADifferentLocation()
                .setUpPickUpLocation(pickUpLock)
                .setUpDropOffLocation(dropOffLock)
                .clickSearchButton();
    }

    /**
     * The method performs search cars using pick up location and age of driver data.
     *
     * @param pickUpLock the necessary location for pick up car.
     * @param age        the driver's age which selected from dropdown menu.
     */
    public void searchCarUsingAgeAndPickUpLocation(String pickUpLock, String age) {
        headerScreen.clickCarButton()
                .unSetAgeCheckbox()
                .setDriverAge(age)
                .setUpPickUpLocation(pickUpLock)
                .clickSearchButton();
    }

    /**
     * The method performs search cars using pick up location data, filters results by selected type and class of car.
     *
     * @param pickUpLock the necessary location for pick up car.
     * @param carClass   the selected option of car's class.
     * @param carType    the selected option of car's type.
     * @return list of strings, each string contains info about set type and class.
     */
    public List<String> getCarClassTypeInfoFromSearchResults(String pickUpLock, String carClass, String carType) {
        return headerScreen.clickCarButton()
                .setUpPickUpLocation(pickUpLock)
                .clickSearchButton()
                .setCarClass(carClass)
                .setCarType(carType)
                .getListCarClassTypeFromGroupPanel();
    }
}
