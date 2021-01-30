package ru.awesome.shop.ta.product.http.body.response;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

public class TokenResponseBody {
    private String success;
    private String token;

    public TokenResponseBody() {
    }

    public TokenResponseBody(String success, String token) {
        this.success = success;
        this.token = token;
    }

    public String getSuccess() {
        return success;
    }

    public String getToken() {
        return token;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 47;
        final int secondPrime = 13;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(success)
                .append(token)
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
        TokenResponseBody other = (TokenResponseBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(success, other.success)
                .append(token, other.token)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJson(this);
    }
}
