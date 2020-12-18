package ru.awesome.shop.ta.product.bo.user.factories;

import ru.awesome.shop.ta.product.bo.user.Credentials;
import ru.awesome.shop.ta.product.bo.user.UserFactory;
import ru.awesome.shop.ta.utils.TestDataReader;

import static ru.awesome.shop.ta.utils.StringUtils.getRandomString;

public class CredentialsFactory {
    private static final String EMAIL = TestDataReader.getTestData("testData.email",
            TestDataReader.getStageData("email"));
    private static final String PASSWORD = TestDataReader.getTestData("testData.password",
            TestDataReader.getStageData("password"));
    private static final String PASSWORD_CONFIRM = PASSWORD;

    private CredentialsFactory() {
        throw new AssertionError(String.format("Creation of instance of %s is prohibited.", UserFactory.class));
    }

    public static Credentials getValidCredentials() {
        return new Credentials(EMAIL, PASSWORD, PASSWORD_CONFIRM);
    }

    public static Credentials getCredentialsWithValidEmailAndInvalidPassword() {
        String invalidPassword = getRandomString();
        return new Credentials(EMAIL, invalidPassword, invalidPassword);
    }

    public static Credentials getCredentialsWithInvalidEmailAndValidPassword() {
        return new Credentials(getRandomString(), PASSWORD, PASSWORD_CONFIRM);
    }
}
