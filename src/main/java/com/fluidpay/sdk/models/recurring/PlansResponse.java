package com.fluidpay.sdk.models.recurring;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * response from getting all the plans
 */
public class PlansResponse {
    private String status;
    private String msg;
    private PlanResponseData[] data;
    @JsonProperty("total_count")
    private int totalCount;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public PlanResponseData[] getData() {
        return data;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
