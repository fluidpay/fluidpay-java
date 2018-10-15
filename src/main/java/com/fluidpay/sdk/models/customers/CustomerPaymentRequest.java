package com.fluidpay.sdk.models.customers;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * request to create or update a customer payment token
 */
public class CustomerPaymentRequest {
    @JsonProperty("card_number")
    private String cardNumber;
    @JsonProperty("expiration_date")
    private String expirationDate;

    public CustomerPaymentRequest(String cardNumber, String expirationDate) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }
}
