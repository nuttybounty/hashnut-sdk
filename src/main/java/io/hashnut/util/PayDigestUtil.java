package io.hashnut.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PayDigestUtil {
    public static String HMACSHA256Base64(String key,String data) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        sha256_HMAC.update(data.getBytes(StandardCharsets.UTF_8));
        byte[] array = sha256_HMAC.doFinal();
        return Base64.getEncoder().encodeToString(array);
    }
}
