package com.fluidpay.sdk;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fluidpay.sdk.models.apikey.KeyRequest;
import com.fluidpay.sdk.models.apikey.KeyResponse;
import com.fluidpay.sdk.models.apikey.KeysResponse;


import java.io.IOException;
import java.net.HttpURLConnection;

public class ApiKey {
    private ObjectMapper om = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    private Utils util = new Utils();

    public KeyResponse createKey(HttpURLConnection conn, KeyRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, KeyResponse.class);
    }

    public KeysResponse getKeys(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, KeysResponse.class);
    }

    public KeyResponse deleteKey(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "DELETE", null, apiKey);

        return om.readValue(resBody, KeyResponse.class);
    }
}
