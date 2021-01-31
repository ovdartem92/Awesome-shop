package ru.awesome.shop.ta.product.bo.address;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

public final class Address {
    private final String firstAddress;
    private final String secondAddress;
    private final String city;
    private final String postCode;
    private final Region region;

    public Address(String firstAddress, String secondAddress, String city,
                   String postCode, Region region) {
        this.firstAddress = firstAddress;
        this.secondAddress = secondAddress;
        this.city = city;
        this.postCode = postCode;
        this.region = region;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public Region getRegion() {
        return region;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 17;
        final int secondPrime = 37;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(firstAddress)
                .append(secondAddress)
                .append(city)
                .append(postCode)
                .append(region)
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
        Address other = (Address) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(firstAddress, other.firstAddress)
                .append(secondAddress, other.secondAddress)
                .append(city, other.city)
                .append(postCode, other.postCode)
                .append(region, other.region)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJsonString(this);
    }
}
