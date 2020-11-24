package service;

import pages.net.skyscanner.cars.CarsSearchResultsScreen;
import pages.net.skyscanner.elements.HeaderScreen;

/**
 * The service class that performs actions to fill in the data for the cars search and performs the search itself.
 */
public class CarSearchService {
    /**
     * This is a method that performs search cars using locations data.
     *
     * @param pickUpLoc  the necessary location for pick up car.
     * @param dropOffLoc the necessary location for leave car.
     * @return the screen with search results.
     */
    public CarsSearchResultsScreen searchCarUsingLocationsData(String pickUpLoc, String dropOffLoc) {
        new HeaderScreen().clickCarButton()
                .choiceReturnCarToADifferentLocation()
                .setUpPickUpLocation(pickUpLoc)
                .setUpDropOffLocation(dropOffLoc)
                .clickSearchButton();
        return new CarsSearchResultsScreen();
    }
}
