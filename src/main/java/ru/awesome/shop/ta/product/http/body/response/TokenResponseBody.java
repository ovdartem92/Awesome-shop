package ru.awesome.shop.ta.product.http.body.response;

public class TokenResponseBody {

    private String success;
    private String token;

    public TokenResponseBody() {
    }

    public TokenResponseBody(String success, String token) {
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
