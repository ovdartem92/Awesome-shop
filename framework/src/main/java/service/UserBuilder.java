package service;

import model.User;

import static util.RandomString.getRandomString;

public class UserBuilder {
    private static final String EMAIL = getEmailToProperties();
    private static final String PASSWORD = getPasswordToProperties();
    private static final String INVALID_PASSWORD = getRandomString();

    public static User getUserWithValidPassword() {
        return new User(EMAIL, PASSWORD);
    }

    public static User getUserWithInvalidPassword() {
        return new User(EMAIL, INVALID_PASSWORD);
    }

    public static String getEmailToProperties() {
        if (System.getProperty("testData.email") == null) {
            return "user@mail.com";
        }
        return TestDataReader.getTestData("testData.email");
    }

    public static String getPasswordToProperties() {
        if (System.getProperty("testData.password") == null) {
            return getRandomString();
        }
        return TestDataReader.getTestData("testData.password");
    }
}
