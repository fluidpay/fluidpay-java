package com.fluidpay.sdk.models.customers;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * response from searching customers or getting all customers
 */
public class CustomersResponse {
    private String status;
    private String msg;
    private CustomerResponseData[] data;
    @JsonProperty("total_count")
    private int totalCount;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public CustomerResponseData[] getData() {
        return data;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
