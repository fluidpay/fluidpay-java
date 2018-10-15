package com.fluidpay.sdk.models.customers;

/**
 * response for a customer token
 */
public class CustomerResponse {
    private String status;
    private String msg;
    private CustomerResponseData data;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public CustomerResponseData getData() {
        return data;
    }
}
