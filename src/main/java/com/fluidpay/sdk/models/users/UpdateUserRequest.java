package com.fluidpay.sdk.models.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * request body for updating a user
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUserRequest {
    private String name;
    private String phone;
    private String email;
    private String timezone;
    private String status;
    private String role;

    public UpdateUserRequest(String name, String phone, String email, String timezone, String status, String role) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.timezone = timezone;
        this.status = status;
        this.role = role;
    }
}
