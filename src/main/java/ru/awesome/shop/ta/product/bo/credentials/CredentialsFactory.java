package ru.awesome.shop.ta.product.bo.credentials;

import org.apache.commons.lang3.RandomStringUtils;
import ru.awesome.shop.ta.framework.configuration.PropertyManager;

import static java.lang.String.format;

public final class CredentialsFactory {
    private static final String DOMAIN = "@mail.net";
    private static final int START_INCLUSIVE = 5;
    private static final int END_EXCLUSIVE = 20;
    private static final String EMAIL = RandomStringUtils.randomAlphanumeric(START_INCLUSIVE, END_EXCLUSIVE)
            .concat(DOMAIN);
    private static final String PASSWORD = RandomStringUtils.randomAlphanumeric(START_INCLUSIVE, END_EXCLUSIVE);
    private static final String REGISTERED_EMAIL = PropertyManager.getEmail();
    private static final String REGISTERED_PASSWORD = PropertyManager.getPassword();

    private CredentialsFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", CredentialsFactory.class));
    }

    public static Credentials generateValidCredentials() {
        String validEmail = RandomStringUtils.randomAlphanumeric(START_INCLUSIVE, END_EXCLUSIVE).concat(DOMAIN);
        String validPassword = RandomStringUtils.randomAlphanumeric(START_INCLUSIVE, END_EXCLUSIVE);
        return new Credentials(validEmail, validPassword);
    }

    public static Credentials generateEmptyCredentials() {
        return new Credentials("", "");
    }

    public static Credentials generateCredentialsWithInvalidPassword() {
        String invalidPassword = RandomStringUtils.randomAscii(START_INCLUSIVE, END_EXCLUSIVE);
        return new Credentials(EMAIL, invalidPassword);
    }

    public static Credentials generateRegisteredCredentialsWithInvalidPassword() {
        String invalidPassword = RandomStringUtils.randomAscii(START_INCLUSIVE, END_EXCLUSIVE);
        return new Credentials(REGISTERED_EMAIL, invalidPassword);
    }

    public static Credentials generateRegisteredCredentialsWithInvalidEmail() {
        String invalidEmail = RandomStringUtils.randomAscii(START_INCLUSIVE, END_EXCLUSIVE).concat(DOMAIN);
        return new Credentials(invalidEmail, REGISTERED_PASSWORD);
    }

    public static Credentials generateCredentialsWithInvalidEmail() {
        String invalidEmail = RandomStringUtils.randomAscii(START_INCLUSIVE, END_EXCLUSIVE).concat(DOMAIN);
        return new Credentials(invalidEmail, PASSWORD);
    }
}
