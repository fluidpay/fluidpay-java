package com.fluidpay.sdk.models.apikey;

/**
 * response for creating a new API key for a user
 */
public class KeyResponse {
    private String status;
    private String msg;
    private KeyResponseData data;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public KeyResponseData getData() {
        return data;
    }
}
