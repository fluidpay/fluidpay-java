package com.fluidpay.sdk.models.recurring;

/**
 * response from a subscription
 */
public class SubscriptionResponse {
    private String status;
    private String msg;
    private SubscriptionResponseData data;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public SubscriptionResponseData getData() {
        return data;
    }
}