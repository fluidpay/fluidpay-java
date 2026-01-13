package com.fluidpay.sdk.models.customers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * response from a customer payment token
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerPaymentResponse {
    private String status;
    private String msg;
    private CustomerPaymentMethodResponse data;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public CustomerPaymentMethodResponse getData() {
        return data;
    }
}
