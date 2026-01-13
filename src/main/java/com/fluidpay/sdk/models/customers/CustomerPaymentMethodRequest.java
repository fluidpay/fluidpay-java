package com.fluidpay.sdk.models.customers;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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
