package ru.awesome.shop.ta.product.bo.address;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.String.format;

public final class AddressFactory {
    private static final int START_INCLUSIVE = 3;
    private static final int END_EXCLUSIVE = 10;

    private AddressFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", AddressFactory.class));
    }

    public static Address generateValidAddress() {
        int firstAddressLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int secondAddressLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int cityLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int postCodeLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        String firstAddress = RandomStringUtils.randomAlphanumeric(firstAddressLength);
        String secondAddress = RandomStringUtils.randomAlphanumeric(secondAddressLength);
        String city = RandomStringUtils.randomAlphabetic(cityLength);
        String postcode = RandomStringUtils.randomNumeric(postCodeLength);
        Region region = generateRegion();
        return new Address(firstAddress, secondAddress, city, postcode, region);
    }

    public static Address generateAddressWithInvalidCity() {
        int firstAddressLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int secondAddressLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int cityLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        int postCodeLength = RandomUtils.nextInt(START_INCLUSIVE, END_EXCLUSIVE);
        String firstAddress = RandomStringUtils.randomAlphanumeric(firstAddressLength);
        String secondAddress = RandomStringUtils.randomAlphanumeric(secondAddressLength);
        String invalidCity = RandomStringUtils.randomAscii(cityLength);
        String postcode = RandomStringUtils.randomNumeric(postCodeLength);
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
