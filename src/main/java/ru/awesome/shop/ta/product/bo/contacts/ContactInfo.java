package ru.awesome.shop.ta.product.bo.contacts;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.product.bo.address.Address;
import ru.awesome.shop.ta.utils.JsonRepresentation;

public final class ContactInfo {
    private final String telephoneNumber;
    private final String faxNumber;
    private final Address address;

    public ContactInfo(String telephoneNumber, String faxNumber, Address address) {
        this.telephoneNumber = telephoneNumber;
        this.faxNumber = faxNumber;
        this.address = new Address(address.getFirstAddress(), address.getSecondAddress(), address.getCity(),
                address.getPostCode(), address.getRegion());
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public Address getAddress() {
        return new Address(address.getFirstAddress(), address.getSecondAddress(), address.getCity(),
                address.getPostCode(), address.getRegion());
    }

    @Override
    public int hashCode() {
        final int firstPrime = 61;
        final int secondPrime = 23;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(telephoneNumber)
                .append(faxNumber)
                .append(address)
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
        ContactInfo other = (ContactInfo) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(telephoneNumber, other.telephoneNumber)
                .append(faxNumber, other.faxNumber)
                .append(address, other.address)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJsonString(this);
    }
}
