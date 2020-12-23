package ru.awesome.shop.ta.product.bo.user;

import org.apache.commons.lang3.RandomStringUtils;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfo;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfoFactory;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.product.bo.credentials.CredentialsFactory;

public final class UserFactory {
    private static final int startInclusive = 5;
    private static final int endExclusive = 15;
    private static final String FIRST_NAME = RandomStringUtils.randomAlphabetic(startInclusive, endExclusive);
    private static final String LAST_NAME = RandomStringUtils.randomAlphabetic(startInclusive, endExclusive);
    private static final String COMPANY = RandomStringUtils.randomAlphabetic(startInclusive, endExclusive);
    private static final Credentials VALID_CREDENTIALS = CredentialsFactory.generateValidCredentials();
    private static final ContactInfo VALID_CONTACT_INFO = ContactInfoFactory.generateValidContactInfo();

    private UserFactory() {
        throw new AssertionError(String.format("Creation of instance of %s is prohibited.", UserFactory.class));
    }

    public static User generateUserWithRegisteredCredentialsWithInvalidEmail() {
        Credentials registeredCredentials = CredentialsFactory.generateRegisteredCredentialsWithInvalidEmail();
        return new User.Builder(registeredCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(VALID_CONTACT_INFO).build();
    }

    public static User generateUserWithRegisteredCredentialsWithInvalidPassword() {
        Credentials registeredCredentials = CredentialsFactory.generateRegisteredCredentialsWithInvalidPassword();
        return new User.Builder(registeredCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(VALID_CONTACT_INFO).build();
    }

    public static User generateValidUser() {
        return new User.Builder(VALID_CREDENTIALS).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(VALID_CONTACT_INFO).build();
    }

    public static User generateUserWithInvalidFirstName() {
        String invalidFirstName = RandomStringUtils.randomAscii(startInclusive, endExclusive);
        return new User.Builder(VALID_CREDENTIALS).firstName(invalidFirstName).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(VALID_CONTACT_INFO).build();
    }

    public static User generateUserWithInvalidLastName() {
        String invalidLastName = RandomStringUtils.randomAscii(startInclusive, endExclusive);
        return new User.Builder(VALID_CREDENTIALS).firstName(FIRST_NAME).lastName(invalidLastName)
                .companyName(COMPANY).contactInfo(VALID_CONTACT_INFO).build();
    }

    public static User generateUserWithInvalidPassword() {
        Credentials credentialsWithInvalidPassword = CredentialsFactory.generateCredentialsWithInvalidPassword();
        return new User.Builder(credentialsWithInvalidPassword).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(VALID_CONTACT_INFO).build();
    }

    public static User generateUserWithInvalidEmail() {
        Credentials credentialsWithInvalidEmail = CredentialsFactory.generateCredentialsWithInvalidEmail();
        return new User.Builder(credentialsWithInvalidEmail).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(VALID_CONTACT_INFO).build();
    }

    public static User generateUserWithInvalidTelephone() {
        ContactInfo contactInfoWithInvalidTelephone = ContactInfoFactory.generateContactInfoWithInvalidTelephone();
        return new User.Builder(VALID_CREDENTIALS).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoWithInvalidTelephone).build();
    }

    public static User generateUserWithInvalidCity() {
        ContactInfo contactInfoWithInvalidCity = ContactInfoFactory.generateContactInfoWithInvalidCity();
        return new User.Builder(VALID_CREDENTIALS).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoWithInvalidCity).build();
    }
}
