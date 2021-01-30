package ru.awesome.shop.ta.product.http.body.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

import java.util.Objects;

public class TokenRequestBody {
    private String username;
    private String key;

    public TokenRequestBody() {
    }

    public TokenRequestBody(String username, String key) {
        Objects.requireNonNull(key, "Key cannot be null");
        Objects.requireNonNull(username, "User name cannot be null");
        this.key = key;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 17;
        final int secondPrime = 37;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(key)
                .append(username)
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
        TokenRequestBody other = (TokenRequestBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(key, other.key)
                .append(username, other.username)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJson(this);
    }
}
