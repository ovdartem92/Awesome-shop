package ru.awesome.shop.ta.product.bo.credentials;

import ru.awesome.shop.ta.utils.TestDataReader;

import static java.lang.String.format;
import static ru.awesome.shop.ta.utils.StringUtils.getRandomString;

public final class CredentialsFactory {
    private static final String EMAIL = TestDataReader.getTestData("testData.email",
                                        TestDataReader.getStageData("email"));
    private static final String PASSWORD = TestDataReader.getTestData("testData.password",
                                           TestDataReader.getStageData("password"));

    private CredentialsFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", CredentialsFactory.class));
    }

    public static Credentials getValidCredentials() {
        return new Credentials(EMAIL, PASSWORD);
    }

    public static Credentials generateCredentialsWithInvalidPassword() {
        return new Credentials(EMAIL, getRandomString());
    }

    public static Credentials generateCredentialsWithInvalidEmail() {
        return new Credentials(getRandomString(), PASSWORD);
    }
}
