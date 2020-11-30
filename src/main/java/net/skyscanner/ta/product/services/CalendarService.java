package net.skyscanner.ta.product.services;

import pages.net.skyscanner.elements.CalendarScreen;

/**
 * This is a service class that performs logic during set dates for searching flights,
 * hotels and cars.
 */
public class CalendarService {

    /**
     * The method is used for set date and get value of this date (weekday, month, day, year).
     *
     * @param date is required for set particular date
     */
    public String getDateValue(String date) {
        CalendarScreen calendarScreen = new CalendarScreen();
        calendarScreen.clickNextMonthButton();
        String dateValue = calendarScreen.getAreaLabelFromDate(date);
        calendarScreen.clickOnDate(date);
        return dateValue;
    }
}
