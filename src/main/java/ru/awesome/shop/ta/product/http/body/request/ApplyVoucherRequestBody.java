package ru.awesome.shop.ta.product.http.body.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

import java.util.Objects;

public class ApplyVoucherRequestBody {
    private String voucher;

    public ApplyVoucherRequestBody(String voucher) {
        Objects.requireNonNull(voucher, "Voucher cannot be null.");
        this.voucher = voucher;
    }

    public String getVoucher() {
        return this.voucher;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 89;
        final int secondPrime = 41;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(voucher)
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
        ApplyVoucherRequestBody other = (ApplyVoucherRequestBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(voucher, other.voucher)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJsonString(this);
    }
}

