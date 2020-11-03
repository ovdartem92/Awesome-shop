package utils;

import java.security.SecureRandom;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public abstract class StringUtils {
    private final static String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz1234567890";
    private final static String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private final static String DATA_FOR_NEW_STRING = CHAR_LOWER + CHAR_UPPER;
    private final static SecureRandom RANDOM = new SecureRandom();

    public static String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }

    public static String getRandomString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int randomIndex = RANDOM.nextInt(DATA_FOR_NEW_STRING.length());
            char randomChar = DATA_FOR_NEW_STRING.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }
}
