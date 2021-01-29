package ru.awesome.shop.ta.product.http.body.request;

public class AddressRequestBody {
    private String firstname;
    private String lastname;
    private String address_1;
    private String city;
    private String country_id;
    private String zone_id;

    public AddressRequestBody() {
        this.firstname = "Art";
        this.lastname = "Ovd";
        this.address_1 = "Gagarina";
        this.city = "Gomel";
        this.country_id = "Bel";
        this.zone_id = "EU";
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress_1() {
        return address_1;
    }

    public String getCity() {
        return city;
    }

    public String getCountry_id() {
        return country_id;
    }

    public String getZone_id() {
        return zone_id;
    }
}
