package com.fluidpay.sdk.models.customers;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * response from getting all of the customer's payment tokens
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerPaymentsResponse {
    private String status;
    private String msg;
    private CustomerCardResponse[] data;
    @JsonProperty("total_count")
    private int totalCount;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public CustomerCardResponse[] getData() {
        return data;
    }

    public int getTotalCount() {
        return totalCount;
    }
}
