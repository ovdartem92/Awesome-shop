package ru.awesome.shop.ta.product.bo.credentials;

import org.apache.commons.lang3.RandomStringUtils;
import ru.awesome.shop.ta.framework.configuration.PropertyManager;

import static java.lang.String.format;

public final class CredentialsFactory {
    private static final String DOMAIN = "@mail.net";
    private static final int CREDENTIALS_START_INCLUSIVE = 4;
    private static final int CREDENTIALS_END_EXCLUSIVE = 20;

    private CredentialsFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", CredentialsFactory.class));
    }

    public static Credentials generateValidCredentials() {
        String email = RandomStringUtils.randomAlphanumeric(CREDENTIALS_START_INCLUSIVE, CREDENTIALS_END_EXCLUSIVE)
                .concat(DOMAIN);
        String password = RandomStringUtils.randomAlphanumeric(CREDENTIALS_START_INCLUSIVE, CREDENTIALS_END_EXCLUSIVE);
        return new Credentials(email, password);
    }

    public static Credentials generateEmptyCredentials() {
        return new Credentials("", "");
    }

    public static Credentials generateRegisteredCredentialsWithInvalidEmail() {
        String registeredPassword = PropertyManager.getEmail();
        String invalidEmail = RandomStringUtils.randomAscii(CREDENTIALS_START_INCLUSIVE, CREDENTIALS_END_EXCLUSIVE)
                .concat(DOMAIN);
        return new Credentials(invalidEmail, registeredPassword);
    }

    public static Credentials generateRegisteredCredentialsWithInvalidPassword() {
        String registeredEmail = PropertyManager.getEmail();
        String invalidPassword = RandomStringUtils.randomAscii(CREDENTIALS_START_INCLUSIVE, CREDENTIALS_END_EXCLUSIVE);
        return new Credentials(registeredEmail, invalidPassword);
    }

    public static Credentials generateCredentialsWithInvalidEmail() {
        String invalidEmail = RandomStringUtils.randomAscii(CREDENTIALS_START_INCLUSIVE, CREDENTIALS_END_EXCLUSIVE)
                .concat(DOMAIN);
        String password = RandomStringUtils.randomAlphanumeric(CREDENTIALS_START_INCLUSIVE, CREDENTIALS_END_EXCLUSIVE);
        return new Credentials(invalidEmail, password);
    }

    public static Credentials generateCredentialsWithInvalidPassword() {
        String email = RandomStringUtils.randomAlphanumeric(CREDENTIALS_START_INCLUSIVE, CREDENTIALS_END_EXCLUSIVE);
        String invalidPassword = RandomStringUtils.randomAscii(CREDENTIALS_START_INCLUSIVE, CREDENTIALS_END_EXCLUSIVE);
        return new Credentials(email, invalidPassword);
    }
}
