package awesome.shop.tests.api.steps;

import ru.awesome.shop.ta.product.bo.Product;

public class ApiTestContext {
    private String token;
    private int actualCodeResponse;
    private String actualSuccessMessage;
    private String actualErrorMessage;
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getActualErrorMessage() {
        return actualErrorMessage;
    }

    public void setActualErrorMessage(String actualErrorMessage) {
        this.actualErrorMessage = actualErrorMessage;
    }

    public String getActualSuccessMessage() {
        return actualSuccessMessage;
    }

    public void setActualSuccessMessage(String actualSuccessMessage) {
        this.actualSuccessMessage = actualSuccessMessage;
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
