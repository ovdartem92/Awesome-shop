package ru.awesome.shop.ta.framework.apiEngine;

public class AuthorizationRequest {
    public String username;
    public String key;

    public AuthorizationRequest(String username, String key) {
        this.username = username;
        this.key = key;
    }
}
