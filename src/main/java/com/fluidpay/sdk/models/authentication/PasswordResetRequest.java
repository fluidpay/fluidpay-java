package com.fluidpay.sdk.models.authentication;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * request body for reseting the password
 * (the password field is the new password)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PasswordResetRequest {
    private String username;
    @JsonProperty("reset_code")
    private String resetCode;
    private String password;

    public PasswordResetRequest(String username, String resetCode, String password) {
        this.username = username;
        this.resetCode = resetCode;
        this.password = password;
    }
}
