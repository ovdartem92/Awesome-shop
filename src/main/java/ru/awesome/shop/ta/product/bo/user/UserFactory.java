package ru.awesome.shop.ta.product.bo.user;

import ru.awesome.shop.ta.utils.TestDataReader;

import static java.lang.String.format;
import static ru.awesome.shop.ta.utils.StringUtils.getRandomString;

public final class UserFactory {
    private static final String EMAIL = TestDataReader.getTestData("testData.email");
    private static final String PASSWORD = TestDataReader.getTestData("testData.password");

    private UserFactory() {
        throw new AssertionError(String.format("Creation of instance of %s is prohibited.", UserFactory.class));
    }

    public static User getUser(UserType type) {
        User user;
        switch (type) {
            case USER_WITH_VALID_CREDENTIALS:
                user = getUserWithValidCredentials();
                break;
            case USER_WITH_VALID_EMAIL_AND_INVALID_PASSWORD:
                user = getUserWithValidEmailAndInvalidPassword();
                break;
            case USER_WITH_INVALID_EMAIL_AND_VALID_PASSWORD:
                user = getUserWithInvalidEmailAndValidPassword();
                break;
            default:
                throw new IllegalArgumentException(format("Unexpected user type: %s", type));
        }
        return user;
    }

    private static User getUserWithValidCredentials() {
        return new User.Builder(EMAIL, PASSWORD).passwordConfirm(PASSWORD).firstName("Jhon").lastName("Doe")
                .telephoneNumber("+1234567890").faxNumber("+1234567890").companyName("Epam")
                .firstAddress("Baker street 1").secondAddress("Baker street 1").city("London").postCode("12323")
                .country("United Kingdom").region("Greater London").build();
    }

    private static User getUserWithValidEmailAndInvalidPassword() {
        return new User.Builder(EMAIL, getRandomString()).build();
    }

    private static User getUserWithInvalidEmailAndValidPassword() {
        return new User.Builder(getRandomString(), PASSWORD).build();
    }
}
