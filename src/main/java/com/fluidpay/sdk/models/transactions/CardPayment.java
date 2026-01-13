package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardPayment {
    private CardRequest card;

    public CardPayment(CardRequest card) {
        this.card = card;
    }
}
