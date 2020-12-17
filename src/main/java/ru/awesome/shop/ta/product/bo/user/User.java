package ru.awesome.shop.ta.product.bo.user;

public class User {
    private final String email;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String telephoneNumber;
    private final String faxNumber;
    private final String companyName;
    private final String firstAddress;
    private final String secondAddress;
    private final String city;
    private final String postCode;
    private final String country;
    private final String region;
    private final String passwordConfirm;

    public static class Builder {
        private final String email;
        private final String password;
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
        private String passwordConfirm = "";

        public Builder(String email, String password) {
            this.email = email;
            this.password = password;
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
