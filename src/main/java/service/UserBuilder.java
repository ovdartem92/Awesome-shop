package service;

import model.User;
import utils.StringUtils;

public class UserBuilder {
    private static final String EMAIL = TestDataReader.getTestData("testData.email");
    private static final String PASSWORD = TestDataReader.getTestData("testData.password");
    private static final String INVALID_PASSWORD = StringUtils.getRandomString();

    public static User getUserWithValidPassword() {
        return new User(EMAIL, PASSWORD);
    }

    public static User getUserWithInvalidPassword() {
        return new User(EMAIL, INVALID_PASSWORD);
    }
}
