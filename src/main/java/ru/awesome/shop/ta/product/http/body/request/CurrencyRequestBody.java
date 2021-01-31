package ru.awesome.shop.ta.product.http.body.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

import java.util.Objects;

public class CurrencyRequestBody {
    private String currency;

    public CurrencyRequestBody(String currency) {
        Objects.requireNonNull(currency, "Currency cannot be null.");
        this.currency = currency;
    }

    public String getCurrency() {
        return this.currency;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 71;
        final int secondPrime = 79;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(currency)
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
        CurrencyRequestBody other = (CurrencyRequestBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(currency, other.currency)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJsonString(this);
    }
}

