package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerPayment {
    private CustomerRequest customer;

    public CustomerPayment(CustomerRequest customer) {
        this.customer = customer;
    }
}
