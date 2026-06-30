package io.hashnut.client;

import io.hashnut.authentication.Authentication;
import io.hashnut.exception.SystemErrorException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.UUID;

public class HashNutClientImpl implements HashNutClient {
    public static final String PRODUCTION_URL = "https://defi.hashnut.io/api/v4.0.0";
    public static final String TESTNET_URL = "https://testnet.hashnut.io/api/v4.0.0";

    private final HttpClient httpClient;
    private final Authentication authentication;
    private final String baseUrl;

    public HashNutClientImpl(String secretKey, boolean testMode) {
        this(secretKey, testMode ? TESTNET_URL : PRODUCTION_URL, HttpClient.newHttpClient());
    }

    public HashNutClientImpl(String secretKey, String baseUrl) {
        this(secretKey, baseUrl, HttpClient.newHttpClient());
    }

    public HashNutClientImpl(String secretKey, String baseUrl, HttpClient httpClient) {
        this.baseUrl = trimTrailingSlash(baseUrl);
        this.httpClient = httpClient;
        this.authentication = new Authentication(secretKey);
    }

    @Override
    public HashNutClientResponse request(String uri, String body, boolean needSign) {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder()
                    .uri(URI.create(this.baseUrl + uri))
                    .timeout(Duration.ofSeconds(10))
                    .header("Content-Type", "application/json");
            if (needSign) {
                String uuid = UUID.randomUUID().toString();
                long timestamp = System.currentTimeMillis();
                String sign = this.authentication.generateHashNutSign(uuid, timestamp, body);
                builder.header("hashnut-request-uuid", uuid);
                builder.header("hashnut-request-timestamp", Long.toString(timestamp, 10));
                builder.header("hashnut-request-sign", sign);
            }
            builder.POST(HttpRequest.BodyPublishers.ofString(body));
            HttpRequest request = builder.build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return new HashNutClientResponse(response.statusCode(), response.body());
        } catch (Exception e) {
            throw new SystemErrorException("Error making API call to HashNut", e);
        }
    }

    private static String trimTrailingSlash(String value) {
        if (value == null || value.isEmpty()) {
            return "";
        }
        int end = value.length();
        while (end > 0 && value.charAt(end - 1) == '/') {
            end--;
        }
        return value.substring(0, end);
    }
}
