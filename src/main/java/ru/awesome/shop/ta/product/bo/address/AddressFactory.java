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

    public static Address generateAddressWithCustomFirstAddress(String firstAddress) {
        return new Address(firstAddress, SECOND_ADDRESS, CITY, POSTCODE, COUNTRY, REGION);
    }

    public static Address generateAddressWithCustomSecondAddress(String secondAddress) {
        return new Address(FIRST_ADDRESS, secondAddress, CITY, POSTCODE, COUNTRY, REGION);
    }

    public static Address generateAddressWithCustomCity(String city) {
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, city, POSTCODE, COUNTRY, REGION);
    }

    public static Address generateAddressWithCustomPostCode(String postCode) {
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, CITY, postCode, COUNTRY, REGION);
    }

    public static Address generateAddressWithCustomCountry(String country) {
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, CITY, CITY, country, REGION);
    }

    public static Address generateAddressWithCustomRegion(String region) {
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, CITY, CITY, COUNTRY, region);
    }
}
