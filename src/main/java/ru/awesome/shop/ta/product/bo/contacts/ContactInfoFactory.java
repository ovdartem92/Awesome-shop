package ru.awesome.shop.ta.product.bo.contacts;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import ru.awesome.shop.ta.product.bo.address.Address;
import ru.awesome.shop.ta.product.bo.address.AddressFactory;

import static java.lang.String.format;

public final class ContactInfoFactory {
    private static final int START_INCLUSIVE = 6;
    private static final int END_EXCLUSIVE = 13;

    private ContactInfoFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", ContactInfoFactory.class));
    }

    public static ContactInfo generateValidContactInfo() {
        int telephoneNumberLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int faxNumberLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        String telephoneNumber = RandomStringUtils.randomNumeric(telephoneNumberLength);
        String faxNumber = RandomStringUtils.randomNumeric(faxNumberLength);
        Address address = AddressFactory.generateValidAddress();
        return new ContactInfo(telephoneNumber, faxNumber, address);
    }

    public static ContactInfo generateContactInfoWithInvalidTelephone() {
        int telephoneNumberLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int faxNumberLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        String invalidTelephone = RandomStringUtils.randomAscii(telephoneNumberLength);
        String faxNumber = RandomStringUtils.randomNumeric(faxNumberLength);
        Address address = AddressFactory.generateValidAddress();
        return new ContactInfo(invalidTelephone, faxNumber, address);
    }

    public static ContactInfo generateContactInfoWithInvalidCity() {
        int telephoneNumberLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int faxNumberLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        String telephoneNumber = RandomStringUtils.randomNumeric(telephoneNumberLength);
        String faxNumber = RandomStringUtils.randomNumeric(faxNumberLength);
        Address addressWithInvalidCity = AddressFactory.generateAddressWithInvalidCity();
        return new ContactInfo(telephoneNumber, faxNumber, addressWithInvalidCity);
    }
}
