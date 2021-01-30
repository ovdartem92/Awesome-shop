package ru.awesome.shop.ta.product.http.body.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

public class TokenRequestBody {
    private String username;
    private String key;

    public TokenRequestBody() {
        this.username = "Autotest";
        this.key = "6faAsXOzZ8ENbDJnFwnPqMooM0JcTRXUdJ7FicMVjE7FcxZwMtZVbrsi63ZPrFKV7FzuaETay3GfsCCpwUMMqo1fyI" +
                "Hg8F42uMPbFFs8K4sDwIOaoQJZDYNBOzu83YLOFfzIOKuRoPJy8UZbYmCYnavSjT8DvSLSMxzLingdiPPMFTwFrao2pMBR1Vsv" +
                "53VMe3hNUgAknBxFIv5QWt86LoXvnzIx2xZqOLQrrK4ZADKWYn5hEDqtN8IHEGYgmmsM";
    }

    public TokenRequestBody(String username, String key) {
        this.key = key;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        final int firstPrime = 17;
        final int secondPrime = 37;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(key)
                .append(username)
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
        TokenRequestBody other = (TokenRequestBody) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(key, other.key)
                .append(username, other.username)
                .isEquals();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJson(this);
    }
}
