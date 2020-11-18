package utils;

import java.security.SecureRandom;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz1234567890";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String DATA_FOR_NEW_STRING = CHAR_LOWER + CHAR_UPPER;
    private static final SecureRandom RANDOM = new SecureRandom();

    private StringUtils() {
    }

    public static String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }

    public static List<String> getMatches(String text, String regEx) {
        List<String> stringList = new ArrayList<>();
        Matcher matcher = Pattern.compile(regEx)
                .matcher(text);
        while (matcher.find())
            stringList.add(matcher.group().trim());
        return stringList;
    }

    public static String getMatcherByIndex(String text, String regEx, int index) {
        return getMatches(text, regEx).get(index);
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
