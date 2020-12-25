package ru.awesome.shop.ta.product.bo.contacts;

import org.apache.commons.lang3.RandomStringUtils;
import ru.awesome.shop.ta.product.bo.address.Address;
import ru.awesome.shop.ta.product.bo.address.AddressFactory;

import static java.lang.String.format;

public final class ContactInfoFactory {
    private static final int START_INCLUSIVE = 6;
    private static final int END_EXCLUSIVE = 13;
    private static final String TELEPHONE_NUMBER = RandomStringUtils.randomNumeric(START_INCLUSIVE, END_EXCLUSIVE);
    private static final String FAX_NUMBER = RandomStringUtils.randomNumeric(START_INCLUSIVE, END_EXCLUSIVE);
    private static final Address VALID_ADDRESS = AddressFactory.generateValidAddress();

    private ContactInfoFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", ContactInfoFactory.class));
    }

    public static ContactInfo generateValidContactInfo() {
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, VALID_ADDRESS);
    }

    public static ContactInfo generateContactInfoWithInvalidTelephone() {
        String invalidTelephone = RandomStringUtils.randomAscii(START_INCLUSIVE, END_EXCLUSIVE);
        return new ContactInfo(invalidTelephone, FAX_NUMBER, VALID_ADDRESS);
    }

    public static ContactInfo generateContactInfoWithInvalidCity() {
        Address addressWithInvalidCity = AddressFactory.generateAddressWithInvalidCity();
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, addressWithInvalidCity);
    }
}
