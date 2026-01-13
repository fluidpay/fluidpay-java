package com.fluidpay.sdk.models.customers;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Card payment method for default_payment
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultPaymentCard {
    private String number;
    @JsonProperty("expiration_date")
    private String expirationDate;

    public DefaultPaymentCard() {
    }

    public DefaultPaymentCard(String number, String expirationDate) {
        this.number = number;
        this.expirationDate = expirationDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
