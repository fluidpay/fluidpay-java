package com.fluidpay.sdk.models.recurring;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * response from getting the subscription
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionsResponse {
    private String status;
    private String msg;
    private SubscriptionResponseData[] data;
    @JsonProperty("total_count")
    private int totalCount;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public SubscriptionResponseData[] getData() {
        return data;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
