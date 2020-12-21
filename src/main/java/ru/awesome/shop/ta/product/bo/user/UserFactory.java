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
    private static final Credentials validCredentials = CredentialsFactory.generateValidCredentials();
    private static final ContactInfo validContactInfo = ContactInfoFactory.generateValidContactInfo();

    private UserFactory() {
        throw new AssertionError(String.format("Creation of instance of %s is prohibited.", UserFactory.class));
    }

    // User factories.
    public static User getRegisteredUser() {
        Credentials registeredCredentials = CredentialsFactory.getRegisteredCredentials();
        return new User.Builder(registeredCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(validContactInfo).build();
    }

    public static User generateValidUser() {
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(validContactInfo).build();
    }

    public static User generateUserWithInvalidFirstName() {
        String invalidFirstName = RandomStringUtils.randomAscii(startInclusive, endExclusive);
        return new User.Builder(validCredentials).firstName(invalidFirstName).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(validContactInfo).build();
    }

    public static User generateUserWithInvalidLastName() {
        String invalidLastName = RandomStringUtils.randomAscii(startInclusive, endExclusive);
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(invalidLastName)
                .companyName(COMPANY).contactInfo(validContactInfo).build();
    }

    public static User generateUserWithEmptyFirstName() {
        return new User.Builder(validCredentials).firstName("").lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(validContactInfo).build();
    }

    public static User generateUserWithEmptyLastName() {
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName("")
                .companyName(COMPANY).contactInfo(validContactInfo).build();
    }

    public static User generateUserWithEmptyCompany() {
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName("").contactInfo(validContactInfo).build();
    }

    // User factories with Credentials factories.
    public static User generateUserWithInvalidPassword() {
        Credentials credentialsWithInvalidPassword = CredentialsFactory.generateCredentialsWithInvalidPassword();
        return new User.Builder(credentialsWithInvalidPassword).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(validContactInfo).build();
    }

    public static User generateUserWithInvalidEmail() {
        Credentials credentialsWithInvalidEmail = CredentialsFactory.generateCredentialsWithInvalidEmail();
        return new User.Builder(credentialsWithInvalidEmail).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(validContactInfo).build();
    }

    public static User generateUserWithEmptyPassword() {
        Credentials credentialsWithEmptyPassword = CredentialsFactory.generateCredentialsWithEmptyPassword();
        return new User.Builder(credentialsWithEmptyPassword).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(validContactInfo).build();
    }

    public static User generateUserWithEmptyEmail() {
        Credentials credentialsWithEmptyEmail = CredentialsFactory.generateCredentialsWithEmptyEmail();
        return new User.Builder(credentialsWithEmptyEmail).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(validContactInfo).build();
    }

    // User factories with ContactInfo factories.
    public static User generateUserWithInvalidTelephone() {
        ContactInfo contactInfoWithInvalidTelephone = ContactInfoFactory.generateContactInfoWithInvalidTelephone();
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoWithInvalidTelephone).build();
    }

    public static User generateUserWithInvalidCity() {
        ContactInfo contactInfoWithInvalidCity = ContactInfoFactory.generateContactInfoWithInvalidCity();
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoWithInvalidCity).build();
    }

    public static User generateUserWithEmptyTelephone() {
        ContactInfo contactInfoEmptyTelephone = ContactInfoFactory.generateContactInfoWithEmptyTelephone();
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoEmptyTelephone).build();
    }

    public static User generateUserWithEmptyFax() {
        ContactInfo contactInfoEmptyFax = ContactInfoFactory.generateContactInfoWithEmptyFax();
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoEmptyFax).build();
    }

    public static User generateUserWithEmptyCity() {
        ContactInfo contactInfoEmptyCity = ContactInfoFactory.generateContactInfoWithEmptyCity();
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoEmptyCity).build();
    }

    public static User generateUserWithEmptyFirstAddress() {
        ContactInfo contactInfoEmptyFirstAddress = ContactInfoFactory.generateContactInfoWithEmptyFirstAddress();
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoEmptyFirstAddress).build();
    }

    public static User generateUserWithEmptySecondAddress() {
        ContactInfo contactInfoEmptySecondAddress = ContactInfoFactory.generateContactInfoWithEmptySecondAddress();
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoEmptySecondAddress).build();
    }

    public static User generateUserWithEmptyPostCode() {
        ContactInfo contactInfoEmptyPostCode = ContactInfoFactory.generateContactInfoWithEmptyPostCode();
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoEmptyPostCode).build();
    }

    public static User generateUserWithEmptyCountry() {
        ContactInfo contactInfoEmptyCountry = ContactInfoFactory.generateContactInfoWithEmptyCountry();
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoEmptyCountry).build();
    }

    public static User generateUserWithEmptyRegion() {
        ContactInfo contactInfoEmptyRegion = ContactInfoFactory.generateContactInfoWithEmptyRegion();
        return new User.Builder(validCredentials).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoEmptyRegion).build();
    }
}
