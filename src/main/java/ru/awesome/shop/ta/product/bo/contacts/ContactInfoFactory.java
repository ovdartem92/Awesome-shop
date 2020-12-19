package ru.awesome.shop.ta.product.bo.contacts;

import ru.awesome.shop.ta.product.bo.address.AddressFactory;
import ru.awesome.shop.ta.utils.TestDataReader;

import static java.lang.String.format;

public class ContactInfoFactory {
    private static final String TELEPHONE_NUMBER = TestDataReader.getStageData("telephone");
    private static final String FAX_NUMBER = TestDataReader.getStageData("fax");

    private ContactInfoFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", ContactInfoFactory.class));
    }

    public static ContactInfo getValidContactInfo() {
        return new ContactInfo(TELEPHONE_NUMBER, FAX_NUMBER, AddressFactory.getValidAddress());
    }
}
