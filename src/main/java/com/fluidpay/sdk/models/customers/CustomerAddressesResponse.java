package com.fluidpay.sdk.models.customers;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * response from getting all of the customer's address tokens
 */
public class CustomerAddressesResponse {
    private String status;
    private String msg;
    private CustomerAddressResponseData[] data;
    @JsonProperty("total_count")
    private int totalCount;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public CustomerAddressResponseData[] getData() {
        return data;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
