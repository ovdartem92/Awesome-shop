package ru.awesome.shop.ta.product.bo.user;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfo;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfoFactory;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.product.bo.credentials.CredentialsFactory;

public final class UserFactory {
    private static final int START_INCLUSIVE = 5;
    private static final int END_EXCLUSIVE = 15;

    private UserFactory() {
        throw new AssertionError(String.format("Creation of instance of %s is prohibited.", UserFactory.class));
    }

    public static User generateUserWithRegisteredCredentialsWithInvalidEmail() {
        int firstNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int lastNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int companyLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        Credentials registeredCredentialsWithInvalidEmail = CredentialsFactory
                .generateRegisteredCredentialsWithInvalidEmail();
        String firstName = RandomStringUtils.randomAlphabetic(firstNameLength);
        String lastName = RandomStringUtils.randomAlphabetic(lastNameLength);
        String company = RandomStringUtils.randomAlphabetic(companyLength);
        ContactInfo contactInfo = ContactInfoFactory.generateValidContactInfo();
        return new User.Builder(registeredCredentialsWithInvalidEmail).firstName(firstName).lastName(lastName)
                .companyName(company).contactInfo(contactInfo).build();
    }

    public static User generateUserWithRegisteredCredentialsWithInvalidPassword() {
        int firstNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int lastNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int companyLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        Credentials registeredCredentialsWithInvalidPassword = CredentialsFactory
                .generateRegisteredCredentialsWithInvalidPassword();
        String firstName = RandomStringUtils.randomAlphabetic(firstNameLength);
        String lastName = RandomStringUtils.randomAlphabetic(lastNameLength);
        String company = RandomStringUtils.randomAlphabetic(companyLength);
        ContactInfo contactInfo = ContactInfoFactory.generateValidContactInfo();
        return new User.Builder(registeredCredentialsWithInvalidPassword).firstName(firstName).lastName(lastName)
                .companyName(company).contactInfo(contactInfo).build();
    }

    public static User generateValidUser() {
        int firstNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int lastNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int companyLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        Credentials validCredentials = CredentialsFactory.generateValidCredentials();
        String firstName = RandomStringUtils.randomAlphabetic(firstNameLength);
        String lastName = RandomStringUtils.randomAlphabetic(lastNameLength);
        String company = RandomStringUtils.randomAlphabetic(companyLength);
        ContactInfo contactInfo = ContactInfoFactory.generateValidContactInfo();
        return new User.Builder(validCredentials).firstName(firstName).lastName(lastName)
                .companyName(company).contactInfo(contactInfo).build();
    }

    public static User generateUserWithInvalidFirstName() {
        int firstNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int lastNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int companyLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        Credentials validCredentials = CredentialsFactory.generateValidCredentials();
        String invalidFirstName = RandomStringUtils.randomAscii(firstNameLength);
        String lastName = RandomStringUtils.randomAlphabetic(lastNameLength);
        String company = RandomStringUtils.randomAlphabetic(companyLength);
        ContactInfo contactInfo = ContactInfoFactory.generateValidContactInfo();
        return new User.Builder(validCredentials).firstName(invalidFirstName).lastName(lastName)
                .companyName(company).contactInfo(contactInfo).build();
    }

    public static User generateUserWithInvalidLastName() {
        int firstNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int lastNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int companyLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        Credentials validCredentials = CredentialsFactory.generateValidCredentials();
        String firstName = RandomStringUtils.randomAlphabetic(firstNameLength);
        String invalidLastName = RandomStringUtils.randomAlphabetic(lastNameLength);
        String company = RandomStringUtils.randomAlphabetic(companyLength);
        ContactInfo contactInfo = ContactInfoFactory.generateValidContactInfo();
        return new User.Builder(validCredentials).firstName(firstName).lastName(invalidLastName)
                .companyName(company).contactInfo(contactInfo).build();
    }

    public static User generateUserWithInvalidPassword() {
        int firstNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int lastNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int companyLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        Credentials credentialsWithInvalidPassword = CredentialsFactory.generateCredentialsWithInvalidPassword();
        String firstName = RandomStringUtils.randomAlphabetic(firstNameLength);
        String lastName = RandomStringUtils.randomAlphabetic(lastNameLength);
        String company = RandomStringUtils.randomAlphabetic(companyLength);
        ContactInfo contactInfo = ContactInfoFactory.generateValidContactInfo();
        return new User.Builder(credentialsWithInvalidPassword).firstName(firstName).lastName(lastName)
                .companyName(company).contactInfo(contactInfo).build();
    }

    public static User generateUserWithInvalidEmail() {
        int firstNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int lastNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int companyLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        Credentials credentialsWithInvalidEmail = CredentialsFactory.generateCredentialsWithInvalidEmail();
        String firstName = RandomStringUtils.randomAlphabetic(firstNameLength);
        String lastName = RandomStringUtils.randomAlphabetic(lastNameLength);
        String company = RandomStringUtils.randomAlphabetic(companyLength);
        ContactInfo contactInfo = ContactInfoFactory.generateValidContactInfo();
        return new User.Builder(credentialsWithInvalidEmail).firstName(firstName).lastName(lastName)
                .companyName(company).contactInfo(contactInfo).build();
    }

    public static User generateUserWithInvalidTelephone() {
        int firstNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int lastNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int companyLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        Credentials validCredentials = CredentialsFactory.generateValidCredentials();
        String firstName = RandomStringUtils.randomAlphabetic(firstNameLength);
        String lastName = RandomStringUtils.randomAlphabetic(lastNameLength);
        String company = RandomStringUtils.randomAlphabetic(companyLength);
        ContactInfo contactInfoWithInvalidTelephone = ContactInfoFactory.generateContactInfoWithInvalidTelephone();
        return new User.Builder(validCredentials).firstName(firstName).lastName(lastName)
                .companyName(company).contactInfo(contactInfoWithInvalidTelephone).build();
    }

    public static User generateUserWithInvalidCity() {
        int firstNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int lastNameLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int companyLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        Credentials validCredentials = CredentialsFactory.generateValidCredentials();
        String firstName = RandomStringUtils.randomAlphabetic(firstNameLength);
        String lastName = RandomStringUtils.randomAlphabetic(lastNameLength);
        String company = RandomStringUtils.randomAlphabetic(companyLength);
        ContactInfo contactInfoWithInvalidCity = ContactInfoFactory.generateContactInfoWithInvalidCity();
        return new User.Builder(validCredentials).firstName(firstName).lastName(lastName)
                .companyName(company).contactInfo(contactInfoWithInvalidCity).build();
    }
}
