package ru.awesome.shop.ta.product.http.body.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

import java.util.Objects;

public class EditCartRequestBody {
    private int key;
    private int quantity;

    public EditCartRequestBody(int key, int quantity) {
        Objects.requireNonNull(key, "Key cannot be null");
        Objects.requireNonNull(quantity, "Quantity cannot be null");
        this.key = key;
        this.quantity = quantity;
    }

    public int getKey() {
        return key;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 61;
        final int secondPrime = 17;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(key)
                .append(quantity)
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
        EditCartRequestBody other = (EditCartRequestBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(key, other.key)
                .append(quantity, other.quantity)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJson(this);
    }
}
