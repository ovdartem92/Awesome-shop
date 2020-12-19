package ru.awesome.shop.ta.product.bo.user;

import ru.awesome.shop.ta.product.bo.credentials.CredentialsFactory;
import ru.awesome.shop.ta.utils.TestDataReader;

public final class UserFactory {
    private static final String FIRST_NAME = TestDataReader.getStageData("firstname");
    private static final String LAST_NAME = TestDataReader.getStageData("lastname");
    private static final String COMPANY = TestDataReader.getStageData("company");

    private UserFactory() {
        throw new AssertionError(String.format("Creation of instance of %s is prohibited.", UserFactory.class));
    }

    public static User generateValidUser() {
        return new User.Builder(CredentialsFactory.getValidCredentials()).build();
    }
}
