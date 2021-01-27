package awesome.shop.tests.api.Steps;

import awesome.shop.tests.api.GetTokenService;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import ru.awesome.shop.ta.framework.apiEngine.AuthorizationResponse;

public class TokenSteps {
    private TextContextApi testContext;
    private String key = "bBL8a7Pfnr8olMEdFvrNxHBwGnGuwHlAu72JSybQDjCsKOQpnBeJp5kbY4TuPStaDt33i6PI922NmGEfXS1dlh2uIfTaSqQwTd1" +
            "KvgueOE1q4GLUWnjaKqMsKrvfdHC5nOrJBDEj9Zb88NDO2k4dYxmrKW2bgc156nJLOVrOVSkVLQRlFxKAVkuG9vypNiNEhB2eOSRvpn5" +
            "8UKW6YiscedNgTmy8QHCZTzyih8qCrYngI3YMqaXHdGKu0Vq6kgfm";
    private String userName = "Autotest";

    public TokenSteps(TextContextApi textContextApi) {
        this.testContext = textContextApi;
    }

    @Given("^I have had a token$")
    public void getTokenForNewSession() {
        GetTokenService getTokenService = new GetTokenService();
        Response response = getTokenService.getToken(userName, key);
        AuthorizationResponse authorizationResponse = response.getBody().as(AuthorizationResponse.class);
        String token = authorizationResponse.getToken();
        testContext.setToken(token);
    }
}
