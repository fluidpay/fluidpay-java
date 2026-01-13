package com.fluidpay.sdk.models.customers;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * request to create or update a customer payment token
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerPaymentRequest {
    @JsonProperty("card_number")
    private String cardNumber;
    @JsonProperty("expiration_date")
    private String expirationDate;

    public CustomerPaymentRequest(String cardNumber, String expirationDate) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}
