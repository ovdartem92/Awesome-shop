package ru.awesome.shop.ta.product.http.body.response;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

public class AddVoucherResponseBody {
    private String success;

    public AddVoucherResponseBody() {
    }

    public String getSuccess() {
        return this.success;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 29;
        final int secondPrime = 13;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(success)
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
        AddVoucherResponseBody other = (AddVoucherResponseBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(success, other.success)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJsonString(this);
    }
}
