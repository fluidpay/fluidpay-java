package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardRequest {
    @JsonProperty("entry_type")
    private String entryType;
    private String number;
    @JsonProperty("expiration_date")
    private String expirationDate;
    private String cvc;
    @JsonProperty("cardholder_authentication")
    private CardholderAuthentication cardholderAuthentication;

    public CardRequest(String entryType, String number, String expirationDate, String cvc, CardholderAuthentication cardholderAuthentication) {
        this.entryType = entryType;
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
        this.cardholderAuthentication = cardholderAuthentication;
    }
}
