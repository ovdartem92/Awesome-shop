package service;

import pages.net.skyscanner.elements.CalendarScreen;

public class CalendarService {
    private CalendarScreen calendarScreen = new CalendarScreen();

    public String getDateValue(String date) {
        calendarScreen.clickNextMonthButton();
        String dateValue = calendarScreen.getAreaLabelFromDate(date);
        calendarScreen.clickOnDate(date);
        return dateValue;
    }
}
