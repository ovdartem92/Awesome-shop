package ru.awesome.shop.ta.utils;

import static java.lang.String.format;

public final class StringUtils {

    private StringUtils() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", StringUtils.class));
    }

    public static String convertTime(long milliseconds) {
        int secondsInMinute = 60;
        final int millisecondsInSecond = 1000;
        long minutes = (milliseconds / millisecondsInSecond) / secondsInMinute;
        long seconds = (milliseconds / millisecondsInSecond) % secondsInMinute;
        return String.format("%s min %s sec", minutes, seconds);
    }
}
