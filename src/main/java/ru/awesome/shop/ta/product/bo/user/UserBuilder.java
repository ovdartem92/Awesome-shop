package ru.awesome.shop.ta.product.bo.user;

public class UserBuilder {
    private User user;

    public UserBuilder() {
        user = new User();
    }

    public UserBuilder(User user) {
        this.user = user;
    }

    public UserBuilder email(String email) {
        user.setEmail(email);
        return this;
    }

    public UserBuilder password(String password) {
        user.setPassword(password);
        return this;
    }

    public UserBuilder passwordConfirm(String passwordConfirm) {
        user.setPasswordConfirm(passwordConfirm);
        return this;
    }

    public UserBuilder firstName(String firstName) {
        user.setFirstName(firstName);
        return this;
    }

    public UserBuilder lastName(String lastName) {
        user.setLastName(lastName);
        return this;
    }

    public UserBuilder telephoneNumber(String telephoneNumber) {
        user.setTelephoneNumber(telephoneNumber);
        return this;
    }

    public UserBuilder faxNumber(String faxNumber) {
        user.setFaxNumber(faxNumber);
        return this;
    }

    public UserBuilder companyName(String companyName) {
        user.setCompanyName(companyName);
        return this;
    }

    public UserBuilder firstAddress(String firstAddress) {
        user.setFirstAddress(firstAddress);
        return this;
    }

    public UserBuilder secondAddress(String secondAddress) {
        user.setSecondAddress(secondAddress);
        return this;
    }

    public UserBuilder city(String city) {
        user.setCity(city);
        return this;
    }

    public UserBuilder postCode(String postCode) {
        user.setPostCode(postCode);
        return this;
    }

    public UserBuilder country(String country) {
        user.setCountry(country);
        return this;
    }

    public UserBuilder region(String region) {
        user.setRegion(region);
        return this;
    }

    public User build() {
        return user;
    }
}
