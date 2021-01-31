package ru.awesome.shop.ta.product.http.body.response;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

import java.util.Objects;

public class ChangeCartResponseBody {
    private String success;

    public ChangeCartResponseBody() {
    }

    public ChangeCartResponseBody(String success) {
        Objects.requireNonNull(success, "Success message cannot be null");
        this.success = success;
    }

    public String getSuccess() {
        return success;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 61;
        final int secondPrime = 89;
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
        ChangeCartResponseBody other = (ChangeCartResponseBody) obj;
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
