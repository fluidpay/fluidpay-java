package com.fluidpay.sdk.models.transactions;

/**
 * response after a transaction
 */
public class TransactionResponse {
    private String status;
    private String msg;
    private TransactionResponseData data;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public TransactionResponseData getData() {
        return data;
    }
}
