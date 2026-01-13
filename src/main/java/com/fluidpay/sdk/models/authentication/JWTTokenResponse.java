package com.fluidpay.sdk.models.authentication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * response from requesting a new JWT token
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JWTTokenResponse {
    private String status;
    private String msg;
    private String token;
    private String sid;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public String getToken() {
        return token;
    }

    public String getSid() {
        return sid;
    }
}
