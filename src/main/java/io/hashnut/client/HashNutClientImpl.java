package io.hashnut.client;

import io.hashnut.authentication.Authentication;
import io.hashnut.exception.SystemErrorException;

import java.util.UUID;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HashNutClientImpl implements HashNutClient {
    /**
     * The production environment
     */
    private static final String PRODUCTION_URL = "https://defi.hashnut.io/api/v3.0.0";

    /**
     * The sandbox environment
     */
    private static final String SANDBOX_URL = "https://testnet.hashnut.io/api/v3.0.0";

    private final Authentication authentication;
    private final String baseUrl;

    public HashNutClientImpl(String secretKey, boolean testMode) {
        this.baseUrl = testMode ? SANDBOX_URL : PRODUCTION_URL;
        this.authentication = new Authentication(secretKey);
    }

    @Override
    public HashNutClientResponse request(String uri, String body,boolean needSign) {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest.Builder builder = HttpRequest.newBuilder()
                    .uri(URI.create(this.baseUrl + uri))
                    .timeout(Duration.ofSeconds(10))
                    .header("content-type", "application/json");
            if(needSign){
                String uuid= UUID.randomUUID().toString();
                long timestamp=System.currentTimeMillis();
                String sign=this.authentication.generateHashNutSign(uuid,timestamp,body);
                builder.header("hashnut-request-uuid",uuid);
                builder.header("hashnut-request-timestamp",Long.toString(timestamp,10));
                builder.header("hashnut-request-sign",sign);
            }
            builder.POST(HttpRequest.BodyPublishers.ofString(body));
            HttpRequest request = builder.build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return new HashNutClientResponse(response.statusCode(), response.body());
        } catch (Exception e) {
            throw new SystemErrorException("Error making API call to HashNut", e);
        }
    }
}
