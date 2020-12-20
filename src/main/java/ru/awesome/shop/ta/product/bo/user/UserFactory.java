package ru.awesome.shop.ta.product.bo.user;

import ru.awesome.shop.ta.product.bo.credentials.CredentialsFactory;

public final class UserFactory {

    private UserFactory() {
        throw new AssertionError(String.format("Creation of instance of %s is prohibited.", UserFactory.class));
    }

    public static User generateValidUser() {
        return new User.Builder(CredentialsFactory.getValidCredentials()).build();
    }

    public static User generateUserWithValidEmailInvalidPassword() {
        return new User.Builder(CredentialsFactory.getValidEmailInvalidPassword()).build();
    }

    public static User generateUserWithInvalidEmailValidPassword() {
        return new User.Builder(CredentialsFactory.getInvalidEmailValidPassword()).build();
    }
}
