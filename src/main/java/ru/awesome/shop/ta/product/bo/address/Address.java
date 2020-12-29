package ru.awesome.shop.ta.product.bo.address;

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
}
