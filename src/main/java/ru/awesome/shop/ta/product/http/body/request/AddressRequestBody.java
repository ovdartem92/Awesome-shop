package ru.awesome.shop.ta.product.http.body.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

public class AddressRequestBody {
    private String firstname;
    private String lastname;
    private String address_1;
    private String city;
    private String country_id;
    private String zone_id;

    public AddressRequestBody(String firstname, String lastname, String address_1, String city, String country_id, String zone_id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address_1 = address_1;
        this.city = city;
        this.country_id = country_id;
        this.zone_id = zone_id;
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
        AddressRequestBody other = (AddressRequestBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(firstname, other.firstname)
                .append(lastname, other.lastname)
                .append(address_1, other.address_1)
                .append(city, other.city)
                .append(country_id, other.country_id)
                .append(zone_id, other.zone_id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        final int firstPrime = 19;
        final int secondPrime = 71;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(firstname)
                .append(lastname)
                .append(address_1)
                .append(city)
                .append(country_id)
                .append(zone_id)
                .toHashCode();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJson(this);
    }

}
