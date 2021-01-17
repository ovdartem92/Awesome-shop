package ru.awesome.shop.ta.product.bo.contacts;

import org.apache.commons.lang3.RandomStringUtils;
import ru.awesome.shop.ta.product.bo.address.Address;
import ru.awesome.shop.ta.product.bo.address.AddressFactory;

import static java.lang.String.format;

public final class ContactInfoFactory {
    private static final int TELEPHONE_START_INCLUSIVE = 3;
    private static final int TELEPHONE_END_EXCLUSIVE = 32;

    private ContactInfoFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", ContactInfoFactory.class));
    }

    public static ContactInfo generateValidContactInfo() {
        String telephoneNumber = RandomStringUtils.randomNumeric(TELEPHONE_START_INCLUSIVE, TELEPHONE_END_EXCLUSIVE);
        String faxNumber = RandomStringUtils.randomNumeric(TELEPHONE_START_INCLUSIVE, TELEPHONE_END_EXCLUSIVE);
        Address address = AddressFactory.generateValidAddress();
        return new ContactInfo(telephoneNumber, faxNumber, address);
    }

    public static ContactInfo generateContactInfoWithInvalidTelephone() {
        String invalidTelephone = RandomStringUtils.randomAscii(TELEPHONE_START_INCLUSIVE, TELEPHONE_END_EXCLUSIVE);
        String faxNumber = RandomStringUtils.randomNumeric(TELEPHONE_START_INCLUSIVE, TELEPHONE_END_EXCLUSIVE);
        Address address = AddressFactory.generateValidAddress();
        return new ContactInfo(invalidTelephone, faxNumber, address);
    }

    public static ContactInfo generateContactInfoWithInvalidCity() {
        String telephoneNumber = RandomStringUtils.randomNumeric(TELEPHONE_START_INCLUSIVE, TELEPHONE_END_EXCLUSIVE);
        String faxNumber = RandomStringUtils.randomNumeric(TELEPHONE_START_INCLUSIVE, TELEPHONE_END_EXCLUSIVE);
        Address addressWithInvalidCity = AddressFactory.generateAddressWithInvalidCity();
        return new ContactInfo(telephoneNumber, faxNumber, addressWithInvalidCity);
    }
}
