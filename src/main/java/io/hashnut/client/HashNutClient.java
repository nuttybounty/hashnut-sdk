package io.hashnut.client;

public interface HashNutClient {
    HashNutClientResponse request(String uri, String body, boolean needSign);
}
