package com.fluidpay.sdk.models.authentication;

/**
 * request body for requesting a password reminder e-mail
 */
public class ForgottenPasswordRequest {
    private String username;

    public ForgottenPasswordRequest(String username) {
        this.username = username;
    }
}
