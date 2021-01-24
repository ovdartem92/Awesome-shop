package awesome.shop.tests.api.Steps;

public class TextContextApi {
    private String BASE_URL = "https://awesome-shop.01sh.ru/index.php?";
    private String token;
    private int cartId;

    public String getBASE_URL() {
        return BASE_URL;
    }

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
}
