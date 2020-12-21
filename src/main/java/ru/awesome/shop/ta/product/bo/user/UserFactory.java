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

    public static User generateUserWithEmptyFirstName() {
        return new User.Builder(VALID_CREDENTIALS).firstName("").lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(VALID_CONTACT_INFO).build();
    }

    public static User generateUserWithEmptyLastName() {
        return new User.Builder(VALID_CREDENTIALS).firstName(FIRST_NAME).lastName("")
                .companyName(COMPANY).contactInfo(VALID_CONTACT_INFO).build();
    }

    public static User generateUserWithEmptyCompany() {
        return new User.Builder(VALID_CREDENTIALS).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName("").contactInfo(VALID_CONTACT_INFO).build();
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

    public static User generateUserWithEmptyPassword() {
        Credentials credentialsWithEmptyPassword = CredentialsFactory.generateCredentialsWithEmptyPassword();
        return new User.Builder(credentialsWithEmptyPassword).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(VALID_CONTACT_INFO).build();
    }

    public static User generateUserWithEmptyEmail() {
        Credentials credentialsWithEmptyEmail = CredentialsFactory.generateCredentialsWithEmptyEmail();
        return new User.Builder(credentialsWithEmptyEmail).firstName(FIRST_NAME).lastName(LAST_NAME)
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

    public static User generateUserWithEmptyTelephone() {
        ContactInfo contactInfoWithEmptyTelephone = ContactInfoFactory.generateContactInfoWithEmptyTelephone();
        return new User.Builder(VALID_CREDENTIALS).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoWithEmptyTelephone).build();
    }

    public static User generateUserWithEmptyFax() {
        ContactInfo contactInfoWithEmptyFax = ContactInfoFactory.generateContactInfoWithEmptyFax();
        return new User.Builder(VALID_CREDENTIALS).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoWithEmptyFax).build();
    }

    public static User generateUserWithEmptyCity() {
        ContactInfo contactInfoWithEmptyCity = ContactInfoFactory.generateContactInfoWithEmptyCity();
        return new User.Builder(VALID_CREDENTIALS).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoWithEmptyCity).build();
    }

    public static User generateUserWithEmptyFirstAddress() {
        ContactInfo contactInfoWithEmptyFirstAddress = ContactInfoFactory
                .generateContactInfoWithEmptyFirstAddress();
        return new User.Builder(VALID_CREDENTIALS).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoWithEmptyFirstAddress).build();
    }

    public static User generateUserWithEmptySecondAddress() {
        ContactInfo contactInfoWithEmptySecondAddress = ContactInfoFactory
                .generateContactInfoWithEmptySecondAddress();
        return new User.Builder(VALID_CREDENTIALS).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoWithEmptySecondAddress).build();
    }

    public static User generateUserWithEmptyPostCode() {
        ContactInfo contactInfoWithEmptyPostCode = ContactInfoFactory.generateContactInfoWithEmptyPostCode();
        return new User.Builder(VALID_CREDENTIALS).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoWithEmptyPostCode).build();
    }

    public static User generateUserWithEmptyCountry() {
        ContactInfo contactInfoWithEmptyCountry = ContactInfoFactory.generateContactInfoWithEmptyCountry();
        return new User.Builder(VALID_CREDENTIALS).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoWithEmptyCountry).build();
    }

    public static User generateUserWithEmptyRegion() {
        ContactInfo contactInfoWithEmptyRegion = ContactInfoFactory.generateContactInfoWithEmptyRegion();
        return new User.Builder(VALID_CREDENTIALS).firstName(FIRST_NAME).lastName(LAST_NAME)
                .companyName(COMPANY).contactInfo(contactInfoWithEmptyRegion).build();
    }
}
