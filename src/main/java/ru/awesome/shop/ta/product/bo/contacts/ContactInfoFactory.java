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

    public static ContactInfo generateValidContactInfo() {
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, VALID_ADDRESS);
    }

    public static ContactInfo generateContactInfoWithInvalidTelephone() {
        String invalidTelephone = RandomStringUtils.randomAscii(startInclusive, endExclusive);
        return new ContactInfo(invalidTelephone, FAX_NUMBER, VALID_ADDRESS);
    }

    public static ContactInfo generateContactInfoWithEmptyTelephone() {
        return new ContactInfo("", FAX_NUMBER, VALID_ADDRESS);
    }

    public static ContactInfo generateContactInfoWithEmptyFax() {
        return new ContactInfo(TELEPHONE_NUMBER, "", VALID_ADDRESS);
    }

    public static ContactInfo generateContactInfoWithInvalidCity() {
        Address addressWithInvalidCity = AddressFactory.generateAddressWithInvalidCity();
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, addressWithInvalidCity);
    }

    public static ContactInfo generateContactInfoWithEmptyFirstAddress() {
        Address addressWithEmptyFirstAddress = AddressFactory.generateAddressWithEmptyFirstAddress();
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, addressWithEmptyFirstAddress);
    }

    public static ContactInfo generateContactInfoWithEmptySecondAddress() {
        Address addressWithEmptySecondAddress = AddressFactory.generateAddressWithEmptySecondAddress();
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, addressWithEmptySecondAddress);
    }

    public static ContactInfo generateContactInfoWithEmptyCity() {
        Address addressWithEmptyCity = AddressFactory.generateAddressWithEmptyCity();
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, addressWithEmptyCity);
    }

    public static ContactInfo generateContactInfoWithEmptyPostCode() {
        Address addressWithEmptyPostCode = AddressFactory.generateAddressWithEmptyPostCode();
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, addressWithEmptyPostCode);
    }

    public static ContactInfo generateContactInfoWithEmptyCountry() {
        Address addressWithEmptyCountry = AddressFactory.generateAddressWithEmptyCountry();
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, addressWithEmptyCountry);
    }

    public static ContactInfo generateContactInfoWithEmptyRegion() {
        Address addressWithEmptyRegion = AddressFactory.generateAddressWithEmptyRegion();
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, addressWithEmptyRegion);
    }
}
