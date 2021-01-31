package awesome.shop.tests.cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.body.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.TokenRequestBody;
import ru.awesome.shop.ta.product.http.body.response.TokenResponseBody;
import ru.awesome.shop.ta.product.microservices.AuthenticationMicroservice;

import java.util.Objects;

public class TokenSteps {
    private ApiTestContext apiTestContext;
    private HttpClient httpClient = new HttpClient();
    private AuthenticationMicroservice authenticationMicroservice = new AuthenticationMicroservice(httpClient);

    public TokenSteps(ApiTestContext textContextApi) {
        Objects.requireNonNull(textContextApi, "ApiTestContext cannot be null");
        this.apiTestContext = textContextApi;
    }

    @Given("^I have authenticated as user \"(.*)\" with key \"(.*)\"$")
    public void generateTokenForNewSession(String userName, String key) throws JsonProcessingException, ParseException {
        Objects.requireNonNull(userName, "User name cannot be null");
        Objects.requireNonNull(key, "Key cannot be null");
        TokenRequestBody tokenRequestBody = new TokenRequestBody(userName, key);
        HttpResponse<TokenResponseBody> response = authenticationMicroservice.generateToken(tokenRequestBody);
        TokenResponseBody body = response.getBody();
        String token = body.getToken();
        this.apiTestContext.setToken(token);
    }
}
