package util;

import java.security.SecureRandom;

public interface RandomString {
    String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz1234567890";
    String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    String DATA_FOR_NEW_STRING = CHAR_LOWER + CHAR_UPPER;
    SecureRandom random = new SecureRandom();

    static String getRandomString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(DATA_FOR_NEW_STRING.length());
            char randomChar = DATA_FOR_NEW_STRING.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }
}
