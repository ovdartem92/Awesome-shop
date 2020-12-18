package ru.awesome.shop.ta.product.bo.user.factories;

import ru.awesome.shop.ta.utils.TestDataReader;

public class PersonalDetailsFactory {
    private static final String FIRST_NAME = TestDataReader.getStageData("firstname");
    private static final String LAST_NAME = TestDataReader.getStageData("lastname");
    private static final String TELEPHONE_NUMBER = TestDataReader.getStageData("telephone");
    private static final String FAX_NUMBER = TestDataReader.getStageData("fax");
}
