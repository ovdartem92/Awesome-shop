package ru.awesome.shop.ta.product.http.body.request;

public class TokenRequestBody {
    public String username;
    public String key;

    public TokenRequestBody(String username, String key) {
        this.username = username;
        this.key = key;
    }
}
