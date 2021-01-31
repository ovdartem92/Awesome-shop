package awesome.shop.tests.api.steps;

import ru.awesome.shop.ta.product.bo.Product;

import java.util.List;
import java.util.Map;

public class ApiTestContext {
    private String token;
    private List<Product> products;
    private int actualStatusCode;
    private String actualSuccessMessage;
    private Map<String, String> actualErrorMessages;
    private String actualErrorMessage;

    public String getActualErrorMessage() {
        return actualErrorMessage;
    }

    public void setActualErrorMessage(String actualErrorMessage) {
        this.actualErrorMessage = actualErrorMessage;
    }

    public Map<String, String> getActualErrorMessages() {
        return this.actualErrorMessages;
    }

    public void setActualErrorMessages(Map<String, String> actualBodyMessages) {
        this.actualErrorMessages = actualBodyMessages;
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

    public int getActualStatusCode() {
        return actualStatusCode;
    }

    public void setActualStatusCode(int actualStatusCode) {
        this.actualStatusCode = actualStatusCode;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
