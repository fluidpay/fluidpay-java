package com.fluidpay.sdk.models.customers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerPaymentMethodRequest {
    @JsonProperty("card")
    private CustomerPaymentRequest card;

    public CustomerPaymentMethodRequest(CustomerPaymentRequest card) {
        this.card = card;
    }

    public CustomerPaymentRequest getCard() {
        return card;
    }
}
