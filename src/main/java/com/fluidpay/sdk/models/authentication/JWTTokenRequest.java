package com.fluidpay.sdk.models.authentication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * request body for requesting a new JWT token
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JWTTokenRequest {
    private String username;
    private String password;

    public JWTTokenRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
