package ru.awesome.shop.ta.product.http.body.response;

public class TokenResponseBody {
    private String success;
    private String token;

    public String getSuccess() {
        return success;
    }

    public String getToken() {
        return token;
    }

    public TokenResponseBody(String success, String token) {
        this.success = success;
        this.token = token;
    }

    public TokenResponseBody() {
    }

    @Override
    public String toString() {
        return "AuthorizationResponse{" +
                "success='" + success + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
