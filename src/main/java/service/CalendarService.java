package service;

import pages.net.skyscanner.elements.CalendarScreen;

public class CalendarService {

    public String getDateValue(String date) {
        CalendarScreen calendarScreen = new CalendarScreen();
        calendarScreen.clickNextMonthButton();
        String dateValue = calendarScreen.getAreaLabelFromDate(date);
        calendarScreen.clickOnDate(date);
        return dateValue;
    }
}
