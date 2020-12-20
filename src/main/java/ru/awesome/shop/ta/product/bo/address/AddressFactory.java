package ru.awesome.shop.ta.product.bo.address;

import org.apache.commons.lang3.RandomStringUtils;

import static java.lang.String.format;

public final class AddressFactory {
    private static final int startInclusive = 5;
    private static final int endExclusive = 20;
    private static final String FIRST_ADDRESS = RandomStringUtils.randomAlphanumeric(startInclusive, endExclusive);
    private static final String SECOND_ADDRESS = RandomStringUtils.randomAlphanumeric(startInclusive, endExclusive);
    private static final String CITY = RandomStringUtils.randomAlphabetic(startInclusive, endExclusive);
    private static final String POSTCODE = RandomStringUtils.randomAlphanumeric(startInclusive, endExclusive);
    private static final String COUNTRY = RandomStringUtils.randomAlphabetic(startInclusive, endExclusive);
    private static final String REGION = RandomStringUtils.randomAlphabetic(startInclusive, endExclusive);

    private AddressFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", AddressFactory.class));
    }

    public static Address generateValidAddress() {
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, CITY, POSTCODE, COUNTRY, REGION);
    }

    public static Address generateAddressWithInvalidCity() {
        String invalidCity = RandomStringUtils.randomAscii(startInclusive, endExclusive);
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, invalidCity,
                POSTCODE, COUNTRY, REGION);
    }

    public static Address generateAddressWithEmptyFirstAddress() {
        return new Address("", SECOND_ADDRESS, CITY, POSTCODE, COUNTRY, REGION);
    }

    public static Address generateAddressWithEmptySecondAddress() {
        return new Address(FIRST_ADDRESS, "", CITY, POSTCODE, COUNTRY, REGION);
    }

    public static Address generateAddressWithEmptyCity() {
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, "", POSTCODE, COUNTRY, REGION);
    }

    public static Address generateAddressWithEmptyPostCode() {
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, CITY, "", COUNTRY, REGION);
    }

    public static Address generateAddressWithEmptyCountry() {
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, CITY, CITY, "", REGION);
    }

    public static Address generateAddressWithEmptyRegion() {
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, CITY, CITY, COUNTRY, "");
    }
}
