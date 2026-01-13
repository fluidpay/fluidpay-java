package com.fluidpay.sdk.models.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * response for a user
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {
    private String status;
    private String msg;
    private UserResponseData data;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public UserResponseData getData() {
        return data;
    }
}
