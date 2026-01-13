package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * response after a transaction
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
