package service;

import model.User;
import utils.StringUtils;

/**
 * This class is needed to create a user instance.
 */
public class UserBuilder {
    /**
     * These variables get data from a property file.
     */
    private static final String EMAIL = TestDataReader.getTestData("testData.email", TestDataReader.getStageData("email"));
    private static final String PASSWORD = TestDataReader.getTestData("testData.password", TestDataReader.getStageData("password"));
    /**
     * This variable always get a random string.
     */
    private static final String INVALID_PASSWORD = StringUtils.getRandomString();

    /**
     * The private constructor is needed because we don't create any instance of this class.
     */
    private UserBuilder() {
    }

    /**
     * This method create user with valid email and password. We need this to successfully log in to the user's account.
     *
     * @return new user with valid data
     */
    public static User getUserWithValidPassword() {
        return new User(EMAIL, PASSWORD);
    }

    /**
     * This method create user with invalid email and password. We need this to check if the login failed.
     *
     * @return new user with invalid data
     */
    public static User getUserWithInvalidPassword() {
        return new User(EMAIL, INVALID_PASSWORD);
    }
}
