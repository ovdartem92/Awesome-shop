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
    private TextContextApi testContext;
    private HttpClient httpClient = new HttpClient();

    public TokenSteps(TextContextApi textContextApi) {
        this.testContext = textContextApi;
    }

    @Given("^I have had a token$")
    public void getTokenForNewSession() throws JsonProcessingException, ParseException {
        TokenRequestBody tokenRequestBody = new TokenRequestBody();
        AuthorizationMicroservice authorizationMicroservice = new AuthorizationMicroservice(httpClient);
        HttpResponse<TokenResponseBody> response = authorizationMicroservice.getToken(tokenRequestBody, "");
        TokenResponseBody body = response.getBody();
        String token = body.getToken();
        testContext.setToken(token);
    }
}
