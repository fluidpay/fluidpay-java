package com.fluidpay.sdk.models.users;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * request body for changing the password
 */
public class ChangePasswordRequest{
    private String username;
    @JsonProperty("current_password")
    private String currentPassword;
    @JsonProperty("new_password")
    private String newPassword;

    public ChangePasswordRequest(String username, String currentPassword, String newPassword) {
        this.username = username;
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
    }
}
