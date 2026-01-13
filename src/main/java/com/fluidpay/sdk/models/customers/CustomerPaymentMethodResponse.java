package com.fluidpay.sdk.models.customers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerPaymentMethodResponse {
    private CustomerCardResponse card;
    private String ach;

    public CustomerCardResponse getCard() {
        return card;
    }

    public String getAch() {
        return ach;
    }
}
