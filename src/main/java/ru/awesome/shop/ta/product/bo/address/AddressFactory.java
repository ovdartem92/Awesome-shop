package ru.awesome.shop.ta.product.bo.address;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.String.format;

public final class AddressFactory {
    private static final int LOCATION_START_INCLUSIVE = 3;
    private static final int LOCATION_END_EXCLUSIVE = 128;
    private static final int POSTCODE_START_INCLUSIVE = 2;
    private static final int POSTCODE_END_EXCLUSIVE = 10;

    private AddressFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", AddressFactory.class));
    }

    public static Address generateValidAddress() {
        String firstAddress = RandomStringUtils.randomAlphanumeric(LOCATION_START_INCLUSIVE, LOCATION_END_EXCLUSIVE);
        String secondAddress = RandomStringUtils.randomAlphanumeric(LOCATION_START_INCLUSIVE, LOCATION_END_EXCLUSIVE);
        String city = RandomStringUtils.randomAlphabetic(LOCATION_START_INCLUSIVE, LOCATION_END_EXCLUSIVE);
        String postcode = RandomStringUtils.randomNumeric(POSTCODE_START_INCLUSIVE, POSTCODE_END_EXCLUSIVE);
        Region region = generateRegion();
        return new Address(firstAddress, secondAddress, city, postcode, region);
    }

    public static Address generateAddressWithInvalidCity() {
        String firstAddress = RandomStringUtils.randomAlphanumeric(LOCATION_START_INCLUSIVE, LOCATION_END_EXCLUSIVE);
        String secondAddress = RandomStringUtils.randomAlphanumeric(LOCATION_START_INCLUSIVE, LOCATION_END_EXCLUSIVE);
        String invalidCity = RandomStringUtils.randomAscii(LOCATION_START_INCLUSIVE, LOCATION_END_EXCLUSIVE);
        String postcode = RandomStringUtils.randomNumeric(POSTCODE_START_INCLUSIVE, POSTCODE_END_EXCLUSIVE);
        Region region = generateRegion();
        return new Address(firstAddress, secondAddress, invalidCity, postcode, region);
    }

    private static Region generateRegion() {
        Random random = new SecureRandom();
        List<Region> regionList = Arrays.asList(Region.values());
        int size = regionList.size();
        int randomIndex = random.nextInt(size);
        return regionList.get(randomIndex);
    }
}
