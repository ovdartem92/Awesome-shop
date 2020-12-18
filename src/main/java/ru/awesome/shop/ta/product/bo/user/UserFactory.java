package ru.awesome.shop.ta.product.bo.user;

import ru.awesome.shop.ta.utils.TestDataReader;

import static ru.awesome.shop.ta.utils.StringUtils.getRandomString;

public final class UserFactory {
    private static final String EMAIL = TestDataReader.getTestData("testData.email",
            TestDataReader.getStageData("email"));
    private static final String PASSWORD = TestDataReader.getTestData("testData.password",
            TestDataReader.getStageData("password"));

    private UserFactory() {
        throw new AssertionError(String.format("Creation of instance of %s is prohibited.", UserFactory.class));
    }

    public static User getUserWithValidCredentials() {
        return new User.Builder(EMAIL, PASSWORD).build();
    }

    public static User getUserWithValidEmailAndInvalidPassword() {
        return new User.Builder(EMAIL, getRandomString()).build();
    }

    public static User getUserWithInvalidEmailAndValidPassword() {
        return new User.Builder(getRandomString(), PASSWORD).build();
    }

    public static User getValidUserForRegistration() {
        return new User.Builder(EMAIL, PASSWORD).passwordConfirm(PASSWORD).firstName("Jhon")
                .lastName("Doe").telephoneNumber("+1234567890").faxNumber("+1234567890").companyName("Epam")
                .firstAddress("Baker street 1").secondAddress("Baker street 1").city("London").postCode("12323")
                .country("United Kingdom").region("Greater London").build();
    }
}
