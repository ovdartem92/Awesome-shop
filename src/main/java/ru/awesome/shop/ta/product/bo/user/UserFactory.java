package ru.awesome.shop.ta.product.bo.user;

import org.apache.commons.lang3.RandomStringUtils;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfo;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfoFactory;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.product.bo.credentials.CredentialsFactory;

public final class UserFactory {
    private static final int START_INCLUSIVE = 5;
    private static final int END_EXCLUSIVE = 15;
    private static final String FIRST_NAME = RandomStringUtils.randomAlphabetic(START_INCLUSIVE, END_EXCLUSIVE);
    private static final String LAST_NAME = RandomStringUtils.randomAlphabetic(START_INCLUSIVE, END_EXCLUSIVE);
    private static final String COMPANY = RandomStringUtils.randomAlphabetic(START_INCLUSIVE, END_EXCLUSIVE);
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
        Credentials validCredentials = CredentialsFactory.generateValidCredentials();
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(VALID_CONTACT_INFO).build();
    }

    public static User generateUserWithInvalidFirstName() {
        Credentials validCredentials = CredentialsFactory.generateValidCredentials();
        String invalidFirstName = RandomStringUtils.randomAscii(START_INCLUSIVE, END_EXCLUSIVE);
        return new User.Builder(validCredentials).firstName(invalidFirstName).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(VALID_CONTACT_INFO).build();
    }

    public static User generateUserWithInvalidLastName() {
        Credentials validCredentials = CredentialsFactory.generateValidCredentials();
        String invalidLastName = RandomStringUtils.randomAscii(START_INCLUSIVE, END_EXCLUSIVE);
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(invalidLastName)
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
        Credentials validCredentials = CredentialsFactory.generateValidCredentials();
        ContactInfo contactInfoWithInvalidTelephone = ContactInfoFactory.generateContactInfoWithInvalidTelephone();
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoWithInvalidTelephone).build();
    }

    public static User generateUserWithInvalidCity() {
        Credentials validCredentials = CredentialsFactory.generateValidCredentials();
        ContactInfo contactInfoWithInvalidCity = ContactInfoFactory.generateContactInfoWithInvalidCity();
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoWithInvalidCity).build();
    }
}
