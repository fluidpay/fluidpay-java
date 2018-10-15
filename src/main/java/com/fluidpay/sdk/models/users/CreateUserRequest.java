package com.fluidpay.sdk.models.users;

/**
 * request body for creating a new user
 * (status can be active or disabled, role can be admin or standard)
 */
public class CreateUserRequest {
    private String username;
    private String name;
    private String phone;
    private String email;
    private String timezone;
    private String password;
    private String status;
    private String role;

    public CreateUserRequest(String username, String name, String phone, String email, String timezone, String password, String status, String role) {
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.timezone = timezone;
        this.password = password;
        this.status = status;
        this.role = role;
    }
}
