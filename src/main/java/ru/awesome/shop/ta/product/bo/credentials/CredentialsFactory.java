package ru.awesome.shop.ta.product.bo.credentials;

import ru.awesome.shop.ta.utils.TestDataReader;

import static java.lang.String.format;
import static ru.awesome.shop.ta.utils.StringUtils.getRandomString;

public class CredentialsFactory {
    private static final String EMAIL = TestDataReader.getTestData("testData.email",
            "nivanis@yandex.ru");
    private static final String PASSWORD = TestDataReader.getTestData("testData.password",
            "testPassword");

    private CredentialsFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", CredentialsFactory.class));
    }

    public static Credentials getValidCredentials() {
        return new Credentials(EMAIL, PASSWORD);
    }

    public static Credentials getValidEmailInvalidPassword() {
        return new Credentials(EMAIL, getRandomString());
    }

    public static Credentials getInvalidEmailValidPassword() {
        return new Credentials(getRandomString(), PASSWORD);
    }
}
