package ru.awesome.shop.ta.product.bo.contacts;

import static java.lang.String.format;

public class ContactInfoFactory {

    private ContactInfoFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", ContactInfoFactory.class));
    }
}
