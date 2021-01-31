package ru.awesome.shop.ta.product.microservices;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import ru.awesome.shop.ta.framework.client.HttpClient;
import ru.awesome.shop.ta.product.http.HttpResponse;
import ru.awesome.shop.ta.product.http.body.request.AddVoucherRequestBody;
import ru.awesome.shop.ta.product.http.body.request.ApplyVoucherRequestBody;
import ru.awesome.shop.ta.product.http.body.response.AddVoucherResponseBody;
import ru.awesome.shop.ta.product.http.body.response.ApplyVoucherResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static ru.awesome.shop.ta.utils.JsonRepresentation.convertFromJson;
import static ru.awesome.shop.ta.utils.JsonRepresentation.convertToJson;

public class VoucherMicroservice extends BaseMicroservice {
    private String token;

    public VoucherMicroservice(HttpClient httpClient, String token) {
        super(httpClient);
        Objects.requireNonNull(token, "Token cannot be null");
        this.token = token;
    }

    public HttpResponse<ApplyVoucherResponseBody> applyExistingVoucher(ApplyVoucherRequestBody applyVoucherRequestBody) throws ParseException {
        Objects.requireNonNull(applyVoucherRequestBody, "Voucher Request Body cannot be null.");
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("token", this.token);

        queryParameters.put(ROUTE, "api/voucher");
        JSONObject requestBody = convertToJson(applyVoucherRequestBody);
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(COMMON_URL, queryParameters,
                requestBody);
        ApplyVoucherResponseBody applyVoucherResponseBody = convertFromJson(httpResponse.getBody(), ApplyVoucherResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                applyVoucherResponseBody);
    }

    public HttpResponse<AddVoucherResponseBody> addNewVoucher(AddVoucherRequestBody addVoucherRequestBody) throws ParseException {
        Objects.requireNonNull(addVoucherRequestBody, "Voucher Add Request Body cannot be null.");
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("token", this.token);
        queryParameters.put(ROUTE, "api/voucher/add");
        JSONObject requestBody = convertToJson(addVoucherRequestBody);
        HttpResponse<JSONObject> httpResponse = this.httpClient.post(COMMON_URL, queryParameters,
                requestBody);
        AddVoucherResponseBody addVoucherResponseBody = convertFromJson(httpResponse.getBody(), AddVoucherResponseBody.class);
        return new HttpResponse<>(httpResponse.getStatusCode(), httpResponse.getHeaders(),
                addVoucherResponseBody);
    }
}
