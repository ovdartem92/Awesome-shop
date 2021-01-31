package ru.awesome.shop.ta.product.http.body.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

import java.util.Objects;

public class AddressRequestBody {
    private String firstname;
    private String lastname;
    private String address_1;//NOSONAR
    private String city;
    private String country_id;//NOSONAR
    private String zone_id;//NOSONAR

    public AddressRequestBody(String firstname, String lastname, String address, String city, String country, String zone) {
        Objects.requireNonNull(firstname, "First name cannot be null");
        Objects.requireNonNull(lastname, "Last name cannot be null");
        Objects.requireNonNull(address, "Address cannot be null");
        Objects.requireNonNull(city, "City cannot be null");
        Objects.requireNonNull(country, "Country cannot be null");
        Objects.requireNonNull(zone, "Zone cannot be null");
        this.firstname = firstname;
        this.lastname = lastname;
        this.address_1 = address;//NOSONAR
        this.city = city;
        this.country_id = country;//NOSONAR
        this.zone_id = zone;//NOSONAR
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getAddress_1() {//NOSONAR
        return this.address_1;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry_id() {//NOSONAR
        return this.country_id;
    }

    public String getZone_id() {//NOSONAR
        return this.zone_id;
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
        return JsonRepresentation.convertToJsonString(this);
    }
}
