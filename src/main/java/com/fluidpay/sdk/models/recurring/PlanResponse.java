package com.fluidpay.sdk.models.recurring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * response from a plan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanResponse {
    private String status;
    private String msg;
    private PlanResponseData data;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public PlanResponseData getData() {
        return data;
    }
}
