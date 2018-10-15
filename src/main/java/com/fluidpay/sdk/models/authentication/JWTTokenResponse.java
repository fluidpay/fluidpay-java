package com.fluidpay.sdk.models.authentication;

/**
 * response from requesting a new JWT token
 */
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
