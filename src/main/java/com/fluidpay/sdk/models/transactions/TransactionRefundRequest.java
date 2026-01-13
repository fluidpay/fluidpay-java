package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * request to refund a transaction
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionRefundRequest {
    private int amount;

    public TransactionRefundRequest(int amount) {
        this.amount = amount;
    }
}
