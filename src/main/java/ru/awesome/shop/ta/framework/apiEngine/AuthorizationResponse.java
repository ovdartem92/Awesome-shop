package ru.awesome.shop.ta.framework.apiEngine;

public class AuthorizationResponse {
    private String success;
    private String token;

    public AuthorizationResponse() {
    }

    public AuthorizationResponse(String success, String token) {
        super();
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
    public String toString() {
        return "AuthorizationResponse{" +
                "success='" + success + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
