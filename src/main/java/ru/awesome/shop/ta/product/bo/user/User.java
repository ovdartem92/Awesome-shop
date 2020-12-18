package ru.awesome.shop.ta.product.bo.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
    private Credentials credentials;
    private PersonalDetails personalDetails;
    private Address address;

    public static class Builder {
        private Credentials credentials;
        private PersonalDetails personalDetails;
        private Address address;

        public Builder(Credentials credentials) {
            this.credentials = credentials;
        }

        public Builder personalDetails(PersonalDetails personalDetails) {
            this.personalDetails = personalDetails;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        this.credentials = builder.credentials;
        this.personalDetails = builder.personalDetails;
        this.address = builder.address;
    }
}