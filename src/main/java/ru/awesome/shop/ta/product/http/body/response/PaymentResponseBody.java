package ru.awesome.shop.ta.product.http.body.response;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

import java.util.Objects;

public class PaymentResponseBody {
    private String error;
    private String success;

    public PaymentResponseBody() {
    }

    public PaymentResponseBody(String error, String success) {
        Objects.requireNonNull(error, "Error message cannot be null");
        Objects.requireNonNull(success, "Success message cannot be null");
        this.error = error;
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public String getSuccess() {
        return success;
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
        PaymentResponseBody other = (PaymentResponseBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(error, other.error)
                .append(success, other.success)
                .isEquals();
    }

    @Override
    public int hashCode() {
        final int firstPrime = 29;
        final int secondPrime = 43;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(error)
                .append(success)
                .toHashCode();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJson(this);
    }
}