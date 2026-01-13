package com.fluidpay.sdk;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fluidpay.sdk.models.terminals.TerminalsResponse;

import java.io.IOException;
import java.net.HttpURLConnection;

public class Terminals {
    private ObjectMapper om = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    private Utils util = new Utils();

    /**
     * Retrieve all terminals associated with the gateway account.
     * This will include inactive/disabled terminals as well.
     * GET /api/terminals
     */
    public TerminalsResponse getTerminals(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, TerminalsResponse.class);
    }
}
