package ru.awesome.shop.ta.product.bo.credentials;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

public final class Credentials {
    private final String email;
    private final String password;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 29;
        final int secondPrime = 73;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(email)
                .append(password)
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
        Credentials other = (Credentials) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(email, other.email)
                .append(password, other.password)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJsonString(this);
    }
}
