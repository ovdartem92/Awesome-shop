package service;

import model.User;

public class UserBuilder {
    private static User user = new User();

    public static User getUserWithProperties() {
        user.setEmail(TestDataReader.getTestData("testData.email"));
        user.setPassword(TestDataReader.getTestData("testData.password"));
        return user;
    }

    public static User getUserWithInvalidPassword() {
        user.setEmail(TestDataReader.getTestData("testData.email"));
        user.setPassword(TestDataReader.getTestData("testData.invalidPassword"));
        return user;
    }
}
