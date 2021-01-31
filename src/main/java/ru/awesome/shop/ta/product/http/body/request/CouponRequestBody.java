package ru.awesome.shop.ta.product.http.body.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

public class CouponRequestBody {
    private int coupon;

    public CouponRequestBody(int coupon) {
        this.coupon = coupon;
    }

    public int getCoupon() {
        return coupon;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 79;
        final int secondPrime = 29;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(coupon)
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
        CouponRequestBody other = (CouponRequestBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(coupon, other.coupon)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJsonString(this);
    }
}
