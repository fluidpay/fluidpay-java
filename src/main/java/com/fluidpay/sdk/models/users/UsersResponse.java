package com.fluidpay.sdk.models.users;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * response for all the users
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersResponse {
    private String status;
    private String msg;
    private UserResponseData[] data;
    @JsonProperty("total_count")
    private int totalCount;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public UserResponseData[] getData() {
        return data;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
