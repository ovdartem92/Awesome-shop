package utils;

import java.security.SecureRandom;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is required to call custom methods for working with strings.
 */
public class StringUtils {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz1234567890";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String DATA_FOR_NEW_STRING = CHAR_LOWER + CHAR_UPPER;
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * The private constructor is needed because we don't create any instance of this class.
     */
    private StringUtils() {
    }

    /**
     * The method is needed to get a substring as the current time in a given format.
     *
     * @return string with current time
     */
    public static String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }

    /**
     * The method is needed to get a collection of substrings matching the regular expression from the text.
     *
     * @param text contains a string to split into the given substrings
     * @param regEx contains a regular expression
     * @return collection of substrings matching the regular expression
     */
    public static List<String> getMatches(String text, String regEx) {
        List<String> stringList = new ArrayList<>();
        Matcher matcher = Pattern.compile(regEx)
                .matcher(text);
        while (matcher.find())
            stringList.add(matcher.group().trim());
        return stringList;
    }

    /**
     * The method returns the string by index from the collection of substrings that match the regular expression.
     *
     * @param text contains a string to split into the given substrings
     * @param regEx contains a regular expression
     * @param index contains an index of the resulting string
     * @return collection item at the specified index
     */
    public static String getMatcherByIndex(String text, String regEx, int index) {
        return getMatches(text, regEx).get(index);
    }

    /**
     * The method is needed to get a string from a set of random characters in the amount of 8 letters.
     *
     * @return string of random letters
     */
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
