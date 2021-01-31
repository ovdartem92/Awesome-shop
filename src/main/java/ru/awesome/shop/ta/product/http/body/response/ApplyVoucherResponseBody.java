package ru.awesome.shop.ta.product.http.body.response;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

public class ApplyVoucherResponseBody {
    private String error;

    public ApplyVoucherResponseBody() {
    }

    public String getError() {
        return this.error;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 23;
        final int secondPrime = 17;
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
        ApplyVoucherResponseBody other = (ApplyVoucherResponseBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(error, other.error)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJsonString(this);
    }
}

