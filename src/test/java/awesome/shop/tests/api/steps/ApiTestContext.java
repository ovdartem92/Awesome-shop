package awesome.shop.tests.api.steps;

import ru.awesome.shop.ta.product.bo.Product;

import java.util.List;

public class ApiTestContext {
    private String token;
    private List<Product> products;
    private int actualCodeResponse;
    private String actualSuccessMessage;
    private String actualErrorMessage;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
