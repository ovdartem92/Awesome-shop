package pages.net.skyscanner;

import pages.AbstractPage;

public class SkyScannerHomePage extends AbstractPage {
    public static final String SEARCH_FLIGHTS_BUTTON_PATH = "//button[text()='Search flights']";
    private static final String HOMEPAGE_URL = "https://www.skyscanner.net/";
    private static final String HELP_LINK_PATH = "//a[(@id='ss-footer-links-faq')]";

    public String getTextFromFlightsButton() {
        return getTextOnElementBy(SEARCH_FLIGHTS_BUTTON_PATH);
    }

    public static String getHomepageUrl() {
        return HOMEPAGE_URL;
    }


}
