package net.skyscanner.ta.product.pages;

import pages.AbstractScreen;

public class CalendarScreen extends AbstractScreen {
    private static final String NEXT_MONTH_BUTTON_LOCATOR = "//button[contains(@id,'next')]";
    private static final String DAY_LOCATOR = "//button[contains(@aria-label,'%s')]";

    public CalendarScreen clickNextMonthButton() {
        clickOnElement(NEXT_MONTH_BUTTON_LOCATOR);
        return this;
    }

    public void clickOnDate(String date) {
        clickOnElement(String.format(DAY_LOCATOR, date));
    }

    public String getAreaLabelFromDate(String date) {
        return getAttributeValueOnElement(String.format(DAY_LOCATOR, date), "aria-label");
    }
}
