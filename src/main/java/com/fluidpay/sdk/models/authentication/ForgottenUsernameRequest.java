package com.fluidpay.sdk.models.authentication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * request body for requesting a username reminder e-mail
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForgottenUsernameRequest {
    private String email;

    public ForgottenUsernameRequest(String email) {
        this.email = email;
    }
}
