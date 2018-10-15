package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * response of a specific or queried transaction
 */
public class TransactionSearchResponse {
    private String status;
    private String msg;
    private TerminalResponseData data;
    @JsonProperty("total_count")
    private int totalCount;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public TerminalResponseData getData() {
        return data;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
