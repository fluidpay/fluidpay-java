package com.fluidpay.sdk.models.authentication;

/**
 * request body for requesting a new JWT token
 */
public class JWTTokenRequest {
    private String username;
    private String password;

    public JWTTokenRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
