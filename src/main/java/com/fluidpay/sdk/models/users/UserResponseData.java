package com.fluidpay.sdk.models.users;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponseData{
    private String id;
    private String username;
    private String name;
    private String phone;
    private String email;
    private String timezone;
    private String status;
    private String role;
    @JsonProperty("account_type")
    private String accountType;
    @JsonProperty("account_type_id")
    private String accountTypeId;
    private UserPermissions permissions;
    @JsonProperty("two_factor_enabled")
    private boolean twoFactorEnabled;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getStatus() {
        return status;
    }

    public String getRole() {
        return role;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountTypeId() {
        return accountTypeId;
    }

    public UserPermissions getPermissions() {
        return permissions;
    }

    public boolean isTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
