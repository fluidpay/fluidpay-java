package com.fluidpay.sdk.models.recurring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * response from a subscription
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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