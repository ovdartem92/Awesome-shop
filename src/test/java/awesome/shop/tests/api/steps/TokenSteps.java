package awesome.shop.tests.api.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.TokenRequestBody;
import ru.awesome.shop.ta.product.http.body.response.TokenResponseBody;
import ru.awesome.shop.ta.product.microservices.AuthorizationMicroservice;

public class TokenSteps {
    private ApiTestContext apiTestContext;
    private HttpClient httpClient = new HttpClient();

    public TokenSteps(ApiTestContext textContextApi) {
        this.apiTestContext = textContextApi;
    }

    @Given("^I have authenticated as user \"(.*)\" with key \"(.*)\"$")
    public void generateTokenForNewSession(String userName, String key) throws JsonProcessingException, ParseException {
        TokenRequestBody tokenRequestBody = new TokenRequestBody(userName, key);
        AuthorizationMicroservice authorizationMicroservice = new AuthorizationMicroservice(httpClient);
        HttpResponse<TokenResponseBody> response = authorizationMicroservice.generateToken(tokenRequestBody);
        TokenResponseBody body = response.getBody();
        String token = body.getToken();
        apiTestContext.setToken(token);
    }
}
