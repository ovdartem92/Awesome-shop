package ru.awesome.shop.ta.product.bo.user;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.product.bo.address.Address;
import ru.awesome.shop.ta.product.bo.address.Region;
import ru.awesome.shop.ta.product.bo.contacts.ContactInfo;
import ru.awesome.shop.ta.product.bo.credentials.Credentials;
import ru.awesome.shop.ta.utils.JsonRepresentation;

public final class User {
    private final Credentials credentials;
    private final String firstName;
    private final String lastName;
    private final String companyName;
    private final ContactInfo contactInfo;

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
        Region region = address.getRegion();
        return new ContactInfo(contactInfo.getTelephoneNumber(), contactInfo.getFaxNumber(),
                new Address(firstAddress, secondAddress, city, postCode, region));
    }

    public Credentials getCredentials() {
        return new Credentials(credentials.getEmail(), credentials.getPassword());
    }

    public static class Builder {
        // Required parameters.
        private final Credentials credentials;

        // Optional parameters - initialized to default values.
        private String firstName = "";
        private String lastName = "";
        private String companyName = "";
        private ContactInfo contactInfo = new ContactInfo("", "",
                new Address("", "", "", "", Region.ABERDEEN));

        public Builder(Credentials credentials) {
            this.credentials = new Credentials(credentials.getEmail(), credentials.getPassword());
        }

        public Builder firstName(String name) {
            this.firstName = name;
            return this;
        }

        public Builder lastName(String name) {
            this.lastName = name;
            return this;
        }

        public Builder companyName(String name) {
            this.companyName = name;
            return this;
        }

        public Builder contactInfo(ContactInfo info) {
            Address contactAddress = info.getAddress();
            Address targetAddress = new Address(contactAddress.getFirstAddress(), contactAddress.getSecondAddress(),
                    contactAddress.getCity(), contactAddress.getPostCode(),
                    contactAddress.getRegion());

            this.contactInfo = new ContactInfo(info.getTelephoneNumber(), info.getFaxNumber(), targetAddress);
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public int hashCode() {
        final int firstPrime = 91;
        final int secondPrime = 11;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(credentials)
                .append(firstName)
                .append(lastName)
                .append(companyName)
                .append(contactInfo)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        User other = (User) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(credentials, other.credentials)
                .append(firstName, other.firstName)
                .append(lastName, other.lastName)
                .append(companyName, other.companyName)
                .append(contactInfo, other.contactInfo)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJson(this);
    }
}
