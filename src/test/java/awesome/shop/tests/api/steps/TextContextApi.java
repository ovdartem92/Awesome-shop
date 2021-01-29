package awesome.shop.tests.api.steps;

public class TextContextApi {
    private String token;
    private int cartId;
    private int actualCodeResponse;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public int getActualCodeResponse() {
        return actualCodeResponse;
    }

    public void setActualCodeResponse(int actualCodeResponse) {
        this.actualCodeResponse = actualCodeResponse;
    }
}
