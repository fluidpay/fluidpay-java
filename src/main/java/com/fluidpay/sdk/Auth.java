package com.fluidpay.sdk;

/**
 * com.fluidpay.sdk.Auth stores API key authentication
 */
public class Auth {
    private String authorization;

    public Auth(String apiKey) {
        this.authorization = apiKey;
    }

    public void setAuth(String apiKey) {
        this.authorization = apiKey;
    }

    public String getAuthorization() {
        return authorization;
    }
}
