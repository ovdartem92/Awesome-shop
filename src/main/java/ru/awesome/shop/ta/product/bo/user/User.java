package ru.awesome.shop.ta.product.bo.user;

import ru.awesome.shop.ta.product.bo.address.Address;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfo;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;

public final class User {
    private final Credentials credentials;
    private final String firstName;
    private final String lastName;
    private final String companyName;
    private final ContactInfo contactInfo;

    public static class Builder {
        // Required parameters.
        private final Credentials credentials;

        // Optional parameters - initialized to default values.
        private String firstName = "";
        private String lastName = "";
        private String companyName = "";
        private ContactInfo contactInfo = new ContactInfo("", "",
                new Address("", "", "", "", "", ""));

        public Builder(Credentials credentials) {
            this.credentials = new Credentials(credentials.getEmail(), credentials.getPassword());
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder contactInfo(ContactInfo contactInfo) {
            Address contactAddress = contactInfo.getAddress();
            Address targetAddress = new Address(contactAddress.getFirstAddress(), contactAddress.getSecondAddress(),
                    contactAddress.getCity(), contactAddress.getPostCode(),
                    contactAddress.getCountry(), contactAddress.getRegion());

            this.contactInfo = new ContactInfo(contactInfo.getTelephoneNumber(),
                    contactInfo.getFaxNumber(), targetAddress);
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        credentials = builder.credentials;
        firstName = builder.firstName;
        lastName = builder.lastName;
        companyName = builder.companyName;
        contactInfo = builder.contactInfo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public ContactInfo getContactInfo() {
        Address address = contactInfo.getAddress();
        String firstAddress = address.getFirstAddress();
        String secondAddress = address.getSecondAddress();
        String city = address.getCity();
        String postCode = address.getPostCode();
        String country = address.getCountry();
        String region = address.getRegion();
        return new ContactInfo(contactInfo.getTelephoneNumber(), contactInfo.getFaxNumber(),
                new Address(firstAddress, secondAddress, city, postCode, country, region));
    }

    public Credentials getCredentials() {
        return new Credentials(credentials.getEmail(), credentials.getPassword());
    }
}
