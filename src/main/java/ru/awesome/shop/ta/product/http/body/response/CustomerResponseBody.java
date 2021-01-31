package ru.awesome.shop.ta.product.http.body.response;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

import java.util.Map;
import java.util.Objects;

public class CustomerResponseBody {
    private String success;
    private Map<String, String> error;

    public CustomerResponseBody() {
    }

    public CustomerResponseBody(String success, Map<String, String> error) {
        Objects.requireNonNull(success, "Success message cannot be null");
        Objects.requireNonNull(error, "Error messages cannot be null");
        this.success = success;
        this.error = error;
    }

    public String getSuccess() {
        return success;
    }

    public Map<String, String> getError() {
        return error;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 47;
        final int secondPrime = 67;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(success)
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
        CustomerResponseBody other = (CustomerResponseBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(success, other.success)
                .append(error, other.error)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJsonString(this);
    }
}
