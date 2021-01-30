package ru.awesome.shop.ta.product.http.body.response;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

public class CouponResponseBody {
    private String error;

    public CouponResponseBody() {
    }

    public CouponResponseBody(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 31;
        final int secondPrime = 11;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(error)
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
        CouponResponseBody other = (CouponResponseBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(error, other.error)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJson(this);
    }
}
