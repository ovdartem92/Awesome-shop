package service;

import model.User;
import utils.StringUtils;

public class UserBuilder {
    private static final String EMAIL = TestDataReader.getTestData("testData.email");
    private static final String PASSWORD = TestDataReader.getTestData("testData.password");
    private static final String INVALID_PASSWORD = StringUtils.getRandomString();
    private static final String NAME = "John";
    private static final String LAST_NAME = "Smith";
    private static final String CITY = "London";

    public static User getUserWithValidPassword() {
        return new User(EMAIL, PASSWORD, NAME, LAST_NAME, CITY);
    }

    public static User getUserWithInvalidPassword() {
        return new User(EMAIL, INVALID_PASSWORD, NAME, LAST_NAME, CITY);
    }
}
