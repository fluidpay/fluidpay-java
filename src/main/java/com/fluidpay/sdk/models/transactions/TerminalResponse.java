package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * response from the terminal after a transaction
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TerminalResponse {
    private String status;
    private String msg;
    private TerminalResponseData data;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public TerminalResponseData getData() {
        return data;
    }
}
