package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionResponseBody {
    private CardResponse card;

    public CardResponse getCard() {
        return card;
    }
}
