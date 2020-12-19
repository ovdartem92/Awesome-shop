package ru.awesome.shop.ta.product.bo.address;

import static java.lang.String.format;

public class AddressFactory {

    private AddressFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", AddressFactory.class));
    }
}
