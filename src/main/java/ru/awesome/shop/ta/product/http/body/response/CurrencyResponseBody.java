package ru.awesome.shop.ta.product.http.body.response;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

public class CurrencyResponseBody {
    private String error;
    private String success;

    public CurrencyResponseBody() {
    }

    public String getError() {
        return this.error;
    }

    public String getSuccess() {
        return this.success;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 17;
        final int secondPrime = 41;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(error)
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
        CurrencyResponseBody other = (CurrencyResponseBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(error, other.error)
                .append(success, other.success)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJsonString(this);
    }
}
