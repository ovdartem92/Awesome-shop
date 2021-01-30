package awesome.shop.tests.cucumber.steps;

import io.cucumber.java.en.Given;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.body.request.TokenRequestBody;
import ru.awesome.shop.ta.product.microservices.AuthenticationMicroservice;

import java.io.IOException;

public class TokenSteps {
    private TextContextApi testContext;
    private HttpClient httpClient = new HttpClient();

    public TokenSteps(TextContextApi textContextApi) {
        this.testContext = textContextApi;
    }

    @Given("^I have had a token$")
    public void getTokenForNewSession() throws IOException {
        TokenRequestBody tokenRequestBody = new TokenRequestBody();
        AuthenticationMicroservice authenticationMicroservice = new AuthenticationMicroservice(httpClient);
        String token = authenticationMicroservice.generateToken(tokenRequestBody).getBody().getToken();
        testContext.setToken(token);
    }
}
