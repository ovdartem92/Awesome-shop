package ru.awesome.shop.ta.product.http.body.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

public class AddItemRequestBody {
    private int product_id; //NOSONAR
    private int quantity;

    public int getProduct_id() { //NOSONAR
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public AddItemRequestBody(int productId, int quantity) {
        this.product_id = productId;
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 11;
        final int secondPrime = 53;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(product_id)
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
        AddItemRequestBody other = (AddItemRequestBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(product_id, other.product_id)
                .append(quantity, other.quantity)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJson(this);
    }
}
