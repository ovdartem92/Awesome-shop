package ru.awesome.shop.ta.product.bo.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class User {
    private String email;
    private String password;
    private String passwordConfirm;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String faxNumber;
    private String companyName;
    private String firstAddress;
    private String secondAddress;
    private String city;
    private String postCode;
    private String country;
    private String region;

    public static class Builder {
        private String email;
        private String password;
        private String passwordConfirm = "";
        private String firstName = "";
        private String lastName = "";
        private String telephoneNumber = "";
        private String faxNumber = "";
        private String companyName = "";
        private String firstAddress = "";
        private String secondAddress = "";
        private String city = "";
        private String postCode = "";
        private String country = "";
        private String region = "";

        public Builder(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder passwordConfirm(String passwordConfirm) {
            this.passwordConfirm = passwordConfirm;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder telephoneNumber(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }

        public Builder faxNumber(String faxNumber) {
            this.faxNumber = faxNumber;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder firstAddress(String firstAddress) {
            this.firstAddress = firstAddress;
            return this;
        }

        public Builder secondAddress(String secondAddress) {
            this.secondAddress = secondAddress;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder postCode(String postCode) {
            this.postCode = postCode;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        email = builder.email;
        password = builder.password;
        passwordConfirm = builder.passwordConfirm;
        firstName = builder.firstName;
        lastName = builder.lastName;
        telephoneNumber = builder.telephoneNumber;
        faxNumber = builder.faxNumber;
        companyName = builder.companyName;
        firstAddress = builder.firstAddress;
        secondAddress = builder.secondAddress;
        city = builder.city;
        postCode = builder.postCode;
        country = builder.country;
        region = builder.region;
    }
}