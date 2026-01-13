package com.fluidpay.sdk.models.authentication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * request body for requesting a password reminder e-mail
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForgottenPasswordRequest {
    private String username;

    public ForgottenPasswordRequest(String username) {
        this.username = username;
    }
}
