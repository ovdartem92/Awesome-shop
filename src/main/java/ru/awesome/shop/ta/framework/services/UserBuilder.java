package ru.awesome.shop.ta.framework.services;

import ru.awesome.shop.ta.product.bo.user.User;
import ru.awesome.shop.ta.utils.TestDataReader;

import static ru.awesome.shop.ta.utils.StringUtils.getRandomString;

public final class UserBuilder {
    private static final String EMAIL = TestDataReader.getTestData("testData.email");
    private static final String PASSWORD = TestDataReader.getTestData("testData.password");

    public static User getUserWithValidCredentials() {
        return new User(EMAIL, PASSWORD);
    }

    public static User getUserWithValidEmailAndInvalidPassword() {
        return new User(EMAIL, getRandomString());
    }

    public static User getUserWithInValidEmailAndValidPassword() {
        return new User(getRandomString(), PASSWORD);
    }
}
