package com.fluidpay.sdk.models.recurring;

/**
 * response from a plan
 */
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
