package com.fluidpay.sdk.models.transactions;

/**
 * request to refund a transaction
 */
public class TransactionRefundRequest {
    private int amount;

    public TransactionRefundRequest(int amount) {
        this.amount = amount;
    }
}
