package com.fluidpay.sdk.models.recurring;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * request to create or update a plan
 */
public class PlanRequest {
    private String name;
    private String description;
    private int amount;
    @JsonProperty("billing_cycle_interval")
    private int billingCycleInterval;
    @JsonProperty("billing_frequency")
    private String billingFrequency;
    @JsonProperty("billing_days")
    private String billingDays;
    private int duration;
    @JsonProperty("add_ons")
    private OptionalRecurringRequest[] addOns;
    private OptionalRecurringRequest[] discounts;

    public PlanRequest(String name, String description, int amount, int billingCycleInterval, String billingFrequency, String billingDays, int duration) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.billingCycleInterval = billingCycleInterval;
        this.billingFrequency = billingFrequency;
        this.billingDays = billingDays;
        this.duration = duration;
    }

    public void setAddOns(OptionalRecurringRequest[] addOns) {
        this.addOns = addOns;
    }

    public void setDiscounts(OptionalRecurringRequest[] discounts) {
        this.discounts = discounts;
    }
}
