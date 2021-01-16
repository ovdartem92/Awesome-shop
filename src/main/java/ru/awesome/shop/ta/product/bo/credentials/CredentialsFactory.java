package ru.awesome.shop.ta.product.bo.credentials;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import ru.awesome.shop.ta.framework.configuration.PropertyManager;

import static java.lang.String.format;

public final class CredentialsFactory {
    private static final String DOMAIN = "@mail.net";
    private static final int START_INCLUSIVE = 5;
    private static final int END_EXCLUSIVE = 20;

    private CredentialsFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", CredentialsFactory.class));
    }

    public static Credentials generateValidCredentials() {
        int emailLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int passwordLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        String validEmail = RandomStringUtils.randomAlphanumeric(emailLength).concat(DOMAIN);
        String validPassword = RandomStringUtils.randomAlphanumeric(passwordLength);
        return new Credentials(validEmail, validPassword);
    }

    public static Credentials generateEmptyCredentials() {
        return new Credentials("", "");
    }

    public static Credentials generateCredentialsWithInvalidPassword() {
        int emailLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int passwordLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        String validEmail = RandomStringUtils.randomAlphanumeric(emailLength);
        String invalidPassword = RandomStringUtils.randomAscii(passwordLength);
        return new Credentials(validEmail, invalidPassword);
    }

    public static Credentials generateRegisteredCredentialsWithInvalidPassword() {
        int passwordLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        String registeredEmail = PropertyManager.getEmail();
        String invalidPassword = RandomStringUtils.randomAscii(passwordLength);
        return new Credentials(registeredEmail, invalidPassword);
    }

    public static Credentials generateRegisteredCredentialsWithInvalidEmail() {
        int emailLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        String registeredPassword = PropertyManager.getEmail();
        String invalidEmail = RandomStringUtils.randomAscii(emailLength).concat(DOMAIN);
        return new Credentials(invalidEmail, registeredPassword);
    }

    public static Credentials generateCredentialsWithInvalidEmail() {
        int emailLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int passwordLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        String invalidEmail = RandomStringUtils.randomAscii(emailLength).concat(DOMAIN);
        String validPassword = RandomStringUtils.randomAlphanumeric(passwordLength);
        return new Credentials(invalidEmail, validPassword);
    }
}
