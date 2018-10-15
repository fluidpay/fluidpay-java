package com.fluidpay.sdk.models.apikey;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * response for getting all the keys for a user
 */
public class KeysResponse {
    private String status;
    private String msg;
    private KeyResponseData[] data;
    @JsonProperty("total_count")
    private int totalCount;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public KeyResponseData[] getData() {
        return data;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
