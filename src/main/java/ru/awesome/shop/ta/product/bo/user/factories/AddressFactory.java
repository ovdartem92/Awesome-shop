package ru.awesome.shop.ta.product.bo.user.factories;

import ru.awesome.shop.ta.utils.TestDataReader;

public class AddressFactory {
    private static final String COMPANY_NAME = TestDataReader.getStageData("company");
    private static final String FIRST_ADDRESS = TestDataReader.getStageData("Address1");
    private static final String SECOND_ADDRESS = TestDataReader.getStageData("Address2");
    private static final String CITY = TestDataReader.getStageData("city");
    private static final String POSTCODE = TestDataReader.getStageData("postcode");
    private static final String COUNTRY = TestDataReader.getStageData("country");
    private static final String REGION = TestDataReader.getStageData("region");
}
