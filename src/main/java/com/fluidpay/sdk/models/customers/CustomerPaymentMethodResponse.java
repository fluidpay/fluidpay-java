package com.fluidpay.sdk.models.customers;

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
