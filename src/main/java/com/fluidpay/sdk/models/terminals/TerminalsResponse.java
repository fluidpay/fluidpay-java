package com.fluidpay.sdk.models.terminals;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * response form getting all the terminals
 */
public class TerminalsResponse {
    private String status;
    private String msg;
    private TerminalsResponseData[] data;
    @JsonProperty("total_count")
    private int totalCount;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public TerminalsResponseData[] getData() {
        return data;
    }

    public int getTotalCount() {
        return totalCount;
    }
}