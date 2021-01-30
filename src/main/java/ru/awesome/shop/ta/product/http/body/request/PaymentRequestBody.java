package ru.awesome.shop.ta.product.http.body.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

public class PaymentRequestBody {
    private String paymentMethod;

    public PaymentRequestBody(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
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
        PaymentRequestBody other = (PaymentRequestBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(paymentMethod, other.paymentMethod)
                .isEquals();
    }

    @Override
    public int hashCode() {
        final int firstPrime = 31;
        final int secondPrime = 29;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(paymentMethod)
                .toHashCode();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJson(this);
    }

}
