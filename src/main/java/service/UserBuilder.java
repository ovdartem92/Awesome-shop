package service;

import model.User;
import utils.Constants;
import utils.StringUtils;

public class UserBuilder {
    private static final String EMAIL = TestDataReader.getTestData("testData.email", TestDataReader.getStageData("email"));
    private static final String PASSWORD = TestDataReader.getTestData("testData.password", TestDataReader.getStageData("password"));
    private static final String INVALID_PASSWORD = StringUtils.getRandomString();
    private static final String FIRST_NAME = Constants.FIRST_NAME;
    private static final String LAST_NAME = Constants.LAST_NAME;
    private static final String CITY = Constants.MOSCOW;

    public static User getUserWithValidPassword() {
        return new User(EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, CITY);
    }

    public static User getUserWithInvalidPassword() {
        return new User(EMAIL, INVALID_PASSWORD, FIRST_NAME, LAST_NAME, CITY);
    }
}
