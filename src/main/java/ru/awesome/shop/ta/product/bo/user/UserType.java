package ru.awesome.shop.ta.product.bo.user;

public enum UserType {
    USER_WITH_VALID_CREDENTIALS,
    USER_WITH_VALID_EMAIL_AND_INVALID_PASSWORD,
    USER_WITH_INVALID_EMAIL_AND_VALID_PASSWORD,
}
