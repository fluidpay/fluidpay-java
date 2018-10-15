package com.fluidpay.sdk.models.recurring;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * request for creating or updating a subscription
 */
public class SubscriptionRequest {
    @JsonProperty("plan_id")
    private String planId;
    private String description;
    private IdData customer;
    private int amount;
    @JsonProperty("billing_cycle_interval")
    private int billingCycleInterval;
    @JsonProperty("billing_frequency")
    private String billingFrequency;
    @JsonProperty("billing_days")
    private String billingDays;
    private int duration;
    @JsonProperty("next_bill_date")
    private String nextBillDate;
    @JsonProperty("add_ons")
    private OptionalRecurringAmountRequest[] addOns;
    private OptionalRecurringAmountRequest[] discounts;

    public SubscriptionRequest(String planId, String description, IdData customer, int amount, int billingCycleInterval, String billingFrequency, String billingDays, int duration, String nextBillDate) {
        this.planId = planId;
        this.description = description;
        this.customer = customer;
        this.amount = amount;
        this.billingCycleInterval = billingCycleInterval;
        this.billingFrequency = billingFrequency;
        this.billingDays = billingDays;
        this.duration = duration;
        this.nextBillDate = nextBillDate;
    }

    public void setAddOns(OptionalRecurringAmountRequest[] addOns) {
        this.addOns = addOns;
    }

    public void setDiscounts(OptionalRecurringAmountRequest[] discounts) {
        this.discounts = discounts;
    }
}
