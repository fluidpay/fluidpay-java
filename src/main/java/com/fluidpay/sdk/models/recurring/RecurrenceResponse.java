package com.fluidpay.sdk.models.recurring;

/**
 * response from an add on or discount
 */
public class RecurrenceResponse {
    private String status;
    private String msg;
    private RecurrenceResponseData data;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public RecurrenceResponseData getData() {
        return data;
    }
}
