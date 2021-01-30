package awesome.shop.tests.cucumber.steps;

import io.cucumber.java.en.Given;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.body.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.TokenRequestBody;
import ru.awesome.shop.ta.product.http.body.response.TokenResponseBody;
import ru.awesome.shop.ta.product.microservices.AuthenticationMicroservice;

import java.io.IOException;

public class TokenSteps {
    private ApiTestContext testContext;
    private HttpClient httpClient = new HttpClient();
    private AuthenticationMicroservice authenticationMicroservice = new AuthenticationMicroservice(httpClient);

    public TokenSteps(ApiTestContext textContextApi) {
        this.testContext = textContextApi;
    }

    @Given("^I have had a token$")
    public void getTokenForNewSession() throws IOException, ParseException {
        TokenRequestBody tokenRequestBody = new TokenRequestBody();
        HttpResponse<TokenResponseBody> tokenResponse = authenticationMicroservice.generateToken(tokenRequestBody);
        TokenResponseBody tokenResponseBody = tokenResponse.getBody();
        String token = tokenResponseBody.getToken();
        testContext.setToken(token);
    }
}
