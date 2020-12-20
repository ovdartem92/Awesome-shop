package ru.awesome.shop.ta.product.bo.credentials;

import org.apache.commons.lang3.RandomStringUtils;
import ru.awesome.shop.ta.utils.TestDataReader;

import static java.lang.String.format;

public final class CredentialsFactory {
    private static final int startInclusive = 5;
    private static final int endExclusive = 20;
    private static final String EMAIL = RandomStringUtils.randomAlphanumeric(startInclusive, endExclusive)
            .concat("@mail.com");
    private static final String PASSWORD = RandomStringUtils.randomAlphanumeric(startInclusive, endExclusive);

    private CredentialsFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", CredentialsFactory.class));
    }

    public static Credentials getRegisteredCredentials() {
        String registeredEmail = TestDataReader.getTestData("testData.email",
                                 TestDataReader.getStageData("email"));
        String registeredPassword = TestDataReader.getTestData("testData.password",
                                    TestDataReader.getStageData("password"));
        return new Credentials(registeredEmail, registeredPassword);
    }

    public static Credentials generateValidCredentials() {
        return new Credentials(EMAIL, PASSWORD);
    }

    public static Credentials generateCredentialsWithInvalidPassword() {
        String invalidPassword = RandomStringUtils.randomAscii(startInclusive, endExclusive);
        return new Credentials(EMAIL, invalidPassword);
    }

    public static Credentials generateCredentialsWithInvalidEmail() {
        String invalidEmail = RandomStringUtils.randomAscii(startInclusive, endExclusive).concat("@mail.com");
        return new Credentials(invalidEmail, PASSWORD);
    }

    public static Credentials generateCredentialsWithEmptyPassword() {
        return new Credentials(EMAIL, "");
    }

    public static Credentials generateCredentialsWithEmptyEmail() {
        return new Credentials("", PASSWORD);
    }
}
