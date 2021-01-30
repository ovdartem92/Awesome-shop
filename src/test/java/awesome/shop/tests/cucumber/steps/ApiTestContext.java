package awesome.shop.tests.cucumber.steps;

public class ApiTestContext {
    private String token;
    private int actualCodeResponse;
    private String actualBodyMessage;

    public String getActualBodyMessage() {
        return actualBodyMessage;
    }

    public void setActualBodyMessage(String actualBodyMessage) {
        this.actualBodyMessage = actualBodyMessage;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getActualCodeResponse() {
        return this.actualCodeResponse;
    }

    public void setActualCodeResponse(int actualCodeResponse) {
        this.actualCodeResponse = actualCodeResponse;
    }
}
