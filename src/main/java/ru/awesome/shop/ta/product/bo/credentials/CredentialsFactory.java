package ru.awesome.shop.ta.product.bo.credentials;

import org.apache.commons.lang3.RandomStringUtils;
import ru.awesome.shop.ta.framework.configuration.PropertyManager;

import static java.lang.String.format;

public final class CredentialsFactory {
    private static final int startInclusive = 5;
    private static final int endExclusive = 20;
    private static final String EMAIL = RandomStringUtils.randomAlphanumeric(startInclusive, endExclusive)
            .concat("@mail.com");
    private static final String PASSWORD = RandomStringUtils.randomAlphanumeric(startInclusive, endExclusive);
    private static final String REGISTERED_EMAIL = PropertyManager.getEmail();
    private static final String REGISTERED_PASSWORD = PropertyManager.getPassword();

    private CredentialsFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", CredentialsFactory.class));
    }

    public static Credentials generateValidCredentials() {
        return new Credentials(EMAIL, PASSWORD);
    }

    public static Credentials generateCredentialsWithInvalidPassword() {
        String invalidPassword = RandomStringUtils.randomAscii(startInclusive, endExclusive);
        return new Credentials(EMAIL, invalidPassword);
    }

    public static Credentials generateRegisteredCredentialsWithInvalidPassword() {
        String invalidPassword = RandomStringUtils.randomAscii(startInclusive, endExclusive);
        return new Credentials(REGISTERED_EMAIL, invalidPassword);
    }

    public static Credentials generateRegisteredCredentialsWithInvalidEmail() {
        String invalidEmail = RandomStringUtils.randomAscii(startInclusive, endExclusive).concat("@mail.com");
        return new Credentials(invalidEmail, REGISTERED_PASSWORD);
    }

    public static Credentials generateCredentialsWithInvalidEmail() {
        String invalidEmail = RandomStringUtils.randomAscii(startInclusive, endExclusive).concat("@mail.com");
        return new Credentials(invalidEmail, PASSWORD);
    }

    public static Credentials generateCredentialsWithCustomPassword(String password) {
        return new Credentials(EMAIL, password);
    }

    public static Credentials generateCredentialsWithCustomEmail(String email) {
        return new Credentials(email, PASSWORD);
    }
}
