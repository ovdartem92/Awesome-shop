package ru.awesome.shop.ta.product.bo.contacts;

import org.apache.commons.lang3.RandomStringUtils;
import ru.awesome.shop.ta.product.bo.address.Address;
import ru.awesome.shop.ta.product.bo.address.AddressFactory;

import static java.lang.String.format;

public final class ContactInfoFactory {
    private static final int startInclusive = 6;
    private static final int endExclusive = 13;
    private static final String TELEPHONE_NUMBER = RandomStringUtils.randomNumeric(startInclusive, endExclusive);
    private static final String FAX_NUMBER = RandomStringUtils.randomNumeric(startInclusive, endExclusive);
    private static final Address VALID_ADDRESS = AddressFactory.generateValidAddress();

    private ContactInfoFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", ContactInfoFactory.class));
    }

    // ContactInfo factories.
    public static ContactInfo generateValidContactInfo() {
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, VALID_ADDRESS);
    }

    public static ContactInfo generateContactInfoWithInvalidTelephone() {
        String invalidTelephone = RandomStringUtils.randomAscii(startInclusive, endExclusive);
        return new ContactInfo(invalidTelephone, FAX_NUMBER, VALID_ADDRESS);
    }

    public static ContactInfo generateContactInfoWithCustomTelephone(String telephoneNumber) {
        return new ContactInfo(telephoneNumber, FAX_NUMBER, VALID_ADDRESS);
    }

    public static ContactInfo generateContactInfoWithCustomFax(String faxNumber) {
        return new ContactInfo(TELEPHONE_NUMBER, faxNumber, VALID_ADDRESS);
    }

    // ContactInfo factories with Address factories.
    public static ContactInfo generateContactInfoWithInvalidCity() {
        Address addressWithInvalidCity = AddressFactory.generateAddressWithInvalidCity();
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, addressWithInvalidCity);
    }

    public static ContactInfo generateContactInfoWithCustomFirstAddress(String firstAddress) {
        Address addressWithCustomFirstAddress = AddressFactory.generateAddressWithCustomFirstAddress(firstAddress);
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, addressWithCustomFirstAddress);
    }

    public static ContactInfo generateContactInfoWithCustomSecondAddress(String secondAddress) {
        Address addressWithCustomSecondAddress = AddressFactory.generateAddressWithCustomSecondAddress(secondAddress);
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, addressWithCustomSecondAddress);
    }

    public static ContactInfo generateContactInfoWithCustomCity(String city) {
        Address addressWithCustomCity = AddressFactory.generateAddressWithCustomCity(city);
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, addressWithCustomCity);
    }

    public static ContactInfo generateContactInfoWithCustomPostCode(String postCode) {
        Address addressWithCustomPostCode = AddressFactory.generateAddressWithCustomPostCode(postCode);
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, addressWithCustomPostCode);
    }

    public static ContactInfo generateContactInfoWithCustomCountry(String country) {
        Address addressWithCustomCountry = AddressFactory.generateAddressWithCustomCountry(country);
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, addressWithCustomCountry);
    }

    public static ContactInfo generateContactInfoWithCustomRegion(String region) {
        Address addressWithCustomRegion = AddressFactory.generateAddressWithCustomRegion(region);
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, addressWithCustomRegion);
    }
}
