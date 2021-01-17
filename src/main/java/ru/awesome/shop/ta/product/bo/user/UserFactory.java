package ru.awesome.shop.ta.product.bo.user;

import org.apache.commons.lang3.RandomStringUtils;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfo;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfoFactory;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.product.bo.credentials.CredentialsFactory;

public final class UserFactory {
    private static final int NAME_START_INCLUSIVE = 1;
    private static final int NAME_END_EXCLUSIVE = 32;

    private UserFactory() {
        throw new AssertionError(String.format("Creation of instance of %s is prohibited.", UserFactory.class));
    }

    public static User generateUserWithRegisteredCredentialsWithInvalidEmail() {
        Credentials registeredCredentialsWithInvalidEmail = CredentialsFactory
                .generateRegisteredCredentialsWithInvalidEmail();
        String firstName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String lastName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String company = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        ContactInfo contactInfo = ContactInfoFactory.generateValidContactInfo();
        return new User.Builder(registeredCredentialsWithInvalidEmail).firstName(firstName).lastName(lastName)
                .companyName(company).contactInfo(contactInfo).build();
    }

    public static User generateUserWithRegisteredCredentialsWithInvalidPassword() {
        Credentials registeredCredentialsWithInvalidPassword = CredentialsFactory
                .generateRegisteredCredentialsWithInvalidPassword();
        String firstName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String lastName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String company = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        ContactInfo contactInfo = ContactInfoFactory.generateValidContactInfo();
        return new User.Builder(registeredCredentialsWithInvalidPassword).firstName(firstName).lastName(lastName)
                .companyName(company).contactInfo(contactInfo).build();
    }

    public static User generateValidUser() {
        Credentials validCredentials = CredentialsFactory.generateValidCredentials();
        String firstName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String lastName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String company = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        ContactInfo contactInfo = ContactInfoFactory.generateValidContactInfo();
        return new User.Builder(validCredentials).firstName(firstName).lastName(lastName)
                .companyName(company).contactInfo(contactInfo).build();
    }

    public static User generateUserWithInvalidFirstName() {
        Credentials validCredentials = CredentialsFactory.generateValidCredentials();
        String invalidFirstName = RandomStringUtils.randomAscii(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String lastName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String company = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        ContactInfo contactInfo = ContactInfoFactory.generateValidContactInfo();
        return new User.Builder(validCredentials).firstName(invalidFirstName).lastName(lastName)
                .companyName(company).contactInfo(contactInfo).build();
    }

    public static User generateUserWithInvalidLastName() {
        Credentials validCredentials = CredentialsFactory.generateValidCredentials();
        String firstName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String invalidLastName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String company = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        ContactInfo contactInfo = ContactInfoFactory.generateValidContactInfo();
        return new User.Builder(validCredentials).firstName(firstName).lastName(invalidLastName)
                .companyName(company).contactInfo(contactInfo).build();
    }

    public static User generateUserWithInvalidPassword() {
        Credentials credentialsWithInvalidPassword = CredentialsFactory.generateCredentialsWithInvalidPassword();
        String firstName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String lastName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String company = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        ContactInfo contactInfo = ContactInfoFactory.generateValidContactInfo();
        return new User.Builder(credentialsWithInvalidPassword).firstName(firstName).lastName(lastName)
                .companyName(company).contactInfo(contactInfo).build();
    }

    public static User generateUserWithInvalidEmail() {
        Credentials credentialsWithInvalidEmail = CredentialsFactory.generateCredentialsWithInvalidEmail();
        String firstName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String lastName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String company = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        ContactInfo contactInfo = ContactInfoFactory.generateValidContactInfo();
        return new User.Builder(credentialsWithInvalidEmail).firstName(firstName).lastName(lastName)
                .companyName(company).contactInfo(contactInfo).build();
    }

    public static User generateUserWithInvalidTelephone() {
        Credentials validCredentials = CredentialsFactory.generateValidCredentials();
        String firstName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String lastName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String company = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        ContactInfo contactInfoWithInvalidTelephone = ContactInfoFactory.generateContactInfoWithInvalidTelephone();
        return new User.Builder(validCredentials).firstName(firstName).lastName(lastName)
                .companyName(company).contactInfo(contactInfoWithInvalidTelephone).build();
    }

    public static User generateUserWithInvalidCity() {
        Credentials validCredentials = CredentialsFactory.generateValidCredentials();
        String firstName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String lastName = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        String company = RandomStringUtils.randomAlphabetic(NAME_START_INCLUSIVE, NAME_END_EXCLUSIVE);
        ContactInfo contactInfoWithInvalidCity = ContactInfoFactory.generateContactInfoWithInvalidCity();
        return new User.Builder(validCredentials).firstName(firstName).lastName(lastName)
                .companyName(company).contactInfo(contactInfoWithInvalidCity).build();
    }
}
