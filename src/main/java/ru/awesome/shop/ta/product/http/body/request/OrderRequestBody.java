package ru.awesome.shop.ta.product.http.body.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

import java.util.Objects;

public class OrderRequestBody {
    private String key;

    public OrderRequestBody(String key) {
        Objects.requireNonNull(key, "Key cannot be null.");
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 59;
        final int secondPrime = 11;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(key)
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
        OrderRequestBody other = (OrderRequestBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(key, other.key)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJsonString(this);
    }
}
