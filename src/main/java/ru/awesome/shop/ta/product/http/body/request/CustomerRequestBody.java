package ru.awesome.shop.ta.product.http.body.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

import java.util.Objects;

public class CustomerRequestBody {
    private String firstname;
    private String lastname;
    private String email;
    private String telephone;

    public CustomerRequestBody(String firstname, String lastname, String email, String telephone) {
        Objects.requireNonNull(firstname, "Firstname cannot be null.");
        Objects.requireNonNull(firstname, "Lastname cannot be null.");
        Objects.requireNonNull(firstname, "Email cannot be null.");
        Objects.requireNonNull(firstname, "Telephone cannot be null.");
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 41;
        final int secondPrime = 83;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(firstname)
                .append(lastname)
                .append(email)
                .append(telephone)
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
        CustomerRequestBody other = (CustomerRequestBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(firstname, other.firstname)
                .append(lastname, other.lastname)
                .append(email, other.email)
                .append(telephone, other.telephone)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJsonString(this);
    }

}
