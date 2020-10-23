package service;

import model.User;

import static util.RandomString.getRandomString;

public class UserBuilder {
    private static final String EMAIL = TestDataReader.getTestData("testData.email");
    private static final String PASSWORD = TestDataReader.getTestData("testData.password");
    private static final String INVALID_PASSWORD = getRandomString();

    public static User getUserWithValidPassword() {
        return new User(EMAIL, PASSWORD);
    }

    public static User getUserWithInvalidPassword() {
        return new User(EMAIL, INVALID_PASSWORD);
    }
}
