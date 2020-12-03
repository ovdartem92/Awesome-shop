package net.skyscanner.ta.product.bo.user;

import model.User;
import net.skyscanner.ta.product.services.TestDataReader;
import utils.Constants;
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
    private static final String FIRST_NAME = Constants.FIRST_NAME;
    private static final String LAST_NAME = Constants.LAST_NAME;
    private static final String CITY = Constants.MOSCOW;

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
        return new User(EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, CITY);
    }

    /**
     * This method create user with invalid email and password. We need this to check if the login failed.
     *
     * @return new user with invalid data
     */
    public static User getUserWithInvalidPassword() {
        return new User(EMAIL, INVALID_PASSWORD, FIRST_NAME, LAST_NAME, CITY);
    }
}
