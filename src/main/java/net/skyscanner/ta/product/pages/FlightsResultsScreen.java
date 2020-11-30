package net.skyscanner.ta.product.pages;

import pages.AbstractScreen;

import java.util.List;

public class FlightsResultsScreen extends AbstractScreen {
    private static final String FLIGHTS_PRISES_SPAN_LOCATOR = "//span[contains(text(),'from')]/parent::p";
    private static final String CITIES_SPAN_LOCATOR = "//span[@data-e2e='search-summary-places']";
    private static final String DATE_DEPART_AND_RETURN_SPAN_LOCATOR = "//input[@id='datepicker']";

    public List<String> getTextFromPrices() {
        return getTextFromElements(FLIGHTS_PRISES_SPAN_LOCATOR);
    }

    public String getAriaLabelDepartDate() {
        return getElements(DATE_DEPART_AND_RETURN_SPAN_LOCATOR).get(0).getAttribute("aria-label");
    }

    public String getAriaLabelReturnDate() {
        return getElements(DATE_DEPART_AND_RETURN_SPAN_LOCATOR).get(1).getAttribute("aria-label");
    }

    public String getTextFromCitiesSpan() {
        return getTextOnElement(CITIES_SPAN_LOCATOR);
    }
}
