package ru.awesome.shop.ta.product.bo.address;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.String.format;

public final class AddressFactory {
    private static final int START_INCLUSIVE = 3;
    private static final int END_EXCLUSIVE = 10;
    private static final String FIRST_ADDRESS = RandomStringUtils.randomAlphanumeric(START_INCLUSIVE, END_EXCLUSIVE);
    private static final String SECOND_ADDRESS = RandomStringUtils.randomAlphanumeric(START_INCLUSIVE, END_EXCLUSIVE);
    private static final String CITY = RandomStringUtils.randomAlphabetic(START_INCLUSIVE, END_EXCLUSIVE);
    private static final String POSTCODE = RandomStringUtils.randomNumeric(START_INCLUSIVE, END_EXCLUSIVE);
    private static final Region REGION = generateRegion();

    private AddressFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", AddressFactory.class));
    }

    public static Address generateValidAddress() {
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, CITY, POSTCODE, REGION);
    }

    public static Address generateAddressWithInvalidCity() {
        String invalidCity = RandomStringUtils.randomAscii(START_INCLUSIVE, END_EXCLUSIVE);
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, invalidCity,
                POSTCODE, REGION);
    }

    private static Region generateRegion() {
        Random random = new Random();
        List<Region> regionList = Arrays.asList(Region.values());
        int size = regionList.size();
        int randomIndex = random.nextInt(size);
        return regionList.get(randomIndex);
    }
}
