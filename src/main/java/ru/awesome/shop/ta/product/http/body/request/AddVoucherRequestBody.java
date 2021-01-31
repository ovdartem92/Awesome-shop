package ru.awesome.shop.ta.product.http.body.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

import java.util.Map;
import java.util.Objects;

public class AddVoucherRequestBody {
    private String from_name;//NOSONAR
    private String from_email;//NOSONAR
    private String to_name;//NOSONAR
    private String to_email;//NOSONAR
    private String amount;
    private String code;

    public AddVoucherRequestBody(String from_name, String from_email, String to_name, String to_email, String amount, String code) {
        Objects.requireNonNull(from_name, "From_name cannot be null.");
        Objects.requireNonNull(from_email, "From_email cannot be null.");
        Objects.requireNonNull(to_name, "To_name cannot be null.");
        Objects.requireNonNull(to_email, "To_email cannot be null.");
        Objects.requireNonNull(amount, "Amount cannot be null.");
        Objects.requireNonNull(code, "Code cannot be null.");
        this.from_name = from_name;
        this.from_email = from_email;
        this.to_name = to_name;
        this.to_email = to_email;
        this.amount = amount;
        this.code = code;
    }

    public AddVoucherRequestBody(Map<String, String> parameters) {
        Objects.requireNonNull(parameters, "Parameters cannot be null.");
        this.from_name = parameters.get("from_name");
        this.from_email = parameters.get("from_email");
        this.to_name = parameters.get("to_name");
        this.to_email = parameters.get("to_email");
        this.amount = parameters.get("amount");
        this.code = parameters.get("code");
    }

    public String getFrom_name() {
        return this.from_name;
    }

    public String getFrom_email() {
        return this.from_email;
    }

    public String getTo_name() {
        return this.to_name;
    }

    public String getTo_email() {
        return this.to_email;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 43;
        final int secondPrime = 73;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(from_name)
                .append(from_email)
                .append(to_name)
                .append(to_email)
                .append(amount)
                .append(code)
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
        AddVoucherRequestBody other = (AddVoucherRequestBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(from_name, other.from_name)
                .append(from_email, other.from_email)
                .append(to_name, other.to_name)
                .append(to_email, other.to_email)
                .append(amount, other.amount)
                .append(code, other.code)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJsonString(this);
    }
}
