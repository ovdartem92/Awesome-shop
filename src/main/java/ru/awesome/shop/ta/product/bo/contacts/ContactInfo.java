package ru.awesome.shop.ta.product.bo.contacts;

import ru.awesome.shop.ta.product.bo.address.Address;

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
}
