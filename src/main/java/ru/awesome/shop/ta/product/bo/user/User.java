package ru.awesome.shop.ta.product.bo.user;

import ru.awesome.shop.ta.product.bo.credentials.Credentials;

public class User {
    private final Credentials credentials;

    public static class Builder {
        private final Credentials credentials;

        public Builder(Credentials credentials) {
            this.credentials = new Credentials(credentials.getEmail(), credentials.getPassword());
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        credentials = builder.credentials;
    }

    public Credentials getCredentials() {
        return new Credentials(credentials.getEmail(), credentials.getPassword());
    }
}
