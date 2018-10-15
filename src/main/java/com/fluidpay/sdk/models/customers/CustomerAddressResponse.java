package com.fluidpay.sdk.models.customers;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * response from a customer address token
 */
public class CustomerAddressResponse {
    private String status;
    private String msg;
    private CustomerAddressResponseData data;
    @JsonProperty("total_count")
    private String totalCount;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public CustomerAddressResponseData getData() {
        return data;
    }
}
