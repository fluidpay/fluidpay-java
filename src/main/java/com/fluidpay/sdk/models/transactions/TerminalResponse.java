package com.fluidpay.sdk.models.transactions;

/**
 * response from the terminal after a transaction
 */
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
