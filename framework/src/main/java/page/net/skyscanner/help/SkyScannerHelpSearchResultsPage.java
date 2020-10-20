package page.net.skyscanner.help;

import static service.WaitManager.*;

public class SkyScannerHelpSearchResultsPage {

    private static final String SEARCH_NO_RESULTS_HEADER_PATH = "//div[@class='inbenta-search-no-results__header inbenta-search-title']";

    public boolean isSearchResultInvalid(){
        return isElementVisibleBy(SEARCH_NO_RESULTS_HEADER_PATH);
    }
}
