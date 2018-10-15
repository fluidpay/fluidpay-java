package com.fluidpay.sdk.models.authentication;

/**
 * request body for requesting a username reminder e-mail
 */
public class ForgottenUsernameRequest {
    private String email;

    public ForgottenUsernameRequest(String email) {
        this.email = email;
    }
}
