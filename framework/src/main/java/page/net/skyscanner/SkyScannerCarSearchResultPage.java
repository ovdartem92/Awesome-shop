package page.net.skyscanner;

import page.AbstractPage;
import static service.ActionManager.*;

public class SkyScannerCarSearchResultPage extends AbstractPage {

    private static final String CAR_SEARCH_SUMMARY_ROUTE_PATH = "//div[@id='carhire-search-summary-route']";

    public String getInfoAboutPickUpLocationFromSummary (){
        String [] array = getTextOnElementBy(CAR_SEARCH_SUMMARY_ROUTE_PATH).split(" - ");
        return array[0];
    }

    public String getInfoAboutDropOffLocationFromSummary (){
        String [] array = getTextOnElementBy(CAR_SEARCH_SUMMARY_ROUTE_PATH).split(" - ");
        return array[1];
    }
}
