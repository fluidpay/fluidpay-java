package com.fluidpay.sdk.models.users;

/**
 * response for a user
 */
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
