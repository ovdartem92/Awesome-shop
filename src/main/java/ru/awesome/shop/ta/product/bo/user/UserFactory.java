package ru.awesome.shop.ta.product.bo.user;

import ru.awesome.shop.ta.product.bo.user.factories.CredentialsFactory;
import ru.awesome.shop.ta.utils.TestDataReader;

public final class UserFactory {
    private static final String EMAIL = TestDataReader.getTestData("testData.email",
            TestDataReader.getStageData("email"));
    private static final String PASSWORD = TestDataReader.getTestData("testData.password",
            TestDataReader.getStageData("password"));

    private UserFactory() {
        throw new AssertionError(String.format("Creation of instance of %s is prohibited.", UserFactory.class));
    }

//    public static User getUserWithValidCredentials() {
//        return new User.Builder(EMAIL, PASSWORD).build();
//    }

//    public static User getUserWithValidEmailAndInvalidPassword() {
//        return new User.Builder(EMAIL, getRandomString()).build();
//    }

    public static User getUserWithInvalidEmailAndValidPassword() {
        return new User.Builder(CredentialsFactory.getCredentialsWithInvalidEmailAndValidPassword()).build();
    }
}
