package ru.awesome.shop.ta.product.http.body.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.awesome.shop.ta.utils.JsonRepresentation;

public class TokenRequestBody {
    private String key;

    public TokenRequestBody() {
        this.key = "6faAsXOzZ8ENbDJnFwnPqMooM0JcTRXUdJ7FicMVjE7FcxZwMtZVbrsi63ZPrFKV7FzuaETay3GfsCCpwUMMqo1fyIHg8F42uMPbFFs8K4sDwIOaoQJZDYNBOzu83YLOFfzIOKuRoPJy8UZbYmCYnavSjT8DvSLSMxzLingdiPPMFTwFrao2pMBR1Vsv53VMe3hNUgAknBxFIv5QWt86LoXvnzIx2xZqOLQrrK4ZADKWYn5hEDqtN8IHEGYgmmsM";
    }

    public TokenRequestBody(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
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
                .isEquals();
    }

    @Override
    public int hashCode() {
        final int firstPrime = 97;
        final int secondPrime = 5;
        return new HashCodeBuilder(firstPrime, secondPrime)
                .append(key)
                .toHashCode();
    }

    @Override
    public String toString() {
        return JsonRepresentation.convertToJson(this);
    }
}
