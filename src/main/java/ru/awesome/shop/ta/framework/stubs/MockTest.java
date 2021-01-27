package ru.awesome.shop.ta.framework.stubs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;

import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.TokenRequestBody;
import ru.awesome.shop.ta.product.microservices.GetTokenMicroservice;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class MockTest {
    private static final int PORT = 9999;
    private static final String HOST = "localhost";
    private static WireMockServer server = new WireMockServer(PORT);

    @BeforeClass
    public void setUp() {
        String token = RandomStringUtils.randomAlphabetic(15);
        JSONObject responseBody = new JSONObject();
        responseBody.put("success", "Success: API session successfully started!");
        responseBody.put("token", token);
        server.start();
        WireMock.configureFor(HOST, PORT);
        stubFor(post(urlEqualTo("/api/login"))
                .withRequestBody(equalToJson("{ \"username\": \"Autotest\", \"key\": \"bBL8a\" }"))
                .willReturn(aResponse().withStatus(200).withBody(responseBody.toJSONString())));
    }

    @Test
    public void firstTest() throws JsonProcessingException, ParseException {
        String key = "bBL8a";
        String userName = "Autotest";
        TokenRequestBody tokenRequestBody = new TokenRequestBody(userName, key);
        HttpClient httpClient = new HttpClient();
        GetTokenMicroservice tokenMicroservice = new GetTokenMicroservice(httpClient);
        HttpResponse httpResponse = tokenMicroservice.generateToken(tokenRequestBody);
        System.out.println("STATUS CODE -----------" + httpResponse.getResponseStatusCode());
        System.out.println("BODY--------" + httpResponse.getBody().toString());
        System.out.println("HEADERS ---------------" + httpResponse.getHeaders().toString());
    }

    @AfterClass
    public static void teardown() {
        if (null != server && server.isRunning()) {
            server.shutdownServer();
        }
    }
}
