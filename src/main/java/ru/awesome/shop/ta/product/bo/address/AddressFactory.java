package ru.awesome.shop.ta.product.bo.address;

import ru.awesome.shop.ta.utils.TestDataReader;

import static java.lang.String.format;

public class AddressFactory {
    private static final String FIRST_ADDRESS = TestDataReader.getStageData("address1");
    private static final String SECOND_ADDRESS = TestDataReader.getStageData("address2");
    private static final String CITY = TestDataReader.getStageData("city");
    private static final String POSTCODE = TestDataReader.getStageData("postcode");
    private static final String COUNTRY = TestDataReader.getStageData("country");
    private static final String REGION = TestDataReader.getStageData("region");

    private AddressFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", AddressFactory.class));
    }
}
