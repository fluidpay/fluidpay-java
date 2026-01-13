package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Payment adjustment details (convenience fees, service fees, and surcharges).
 * Either "flat" or "percentage" type.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentAdjustment {
    /**
     * Type of adjustment: "flat" or "percentage"
     */
    private String type;
    /**
     * Amount of adjustment in cents for "flat" (ex. 199 = $1.99)
     * or 3 decimal places for "percentage" (ex. 1000 = 1.000%)
     */
    private Integer value;

    public PaymentAdjustment() {
    }

    public PaymentAdjustment(String type, Integer value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
