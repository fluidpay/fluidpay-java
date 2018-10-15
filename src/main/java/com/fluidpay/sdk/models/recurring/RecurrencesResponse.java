package com.fluidpay.sdk.models.recurring;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * response from getting all the add ons or discounts
 */
public class RecurrencesResponse {
    private String status;
    private String msg;
    private RecurrenceResponseData[] data;
    @JsonProperty("total_count")
    private int totalCount;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public RecurrenceResponseData[] getData() {
        return data;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
