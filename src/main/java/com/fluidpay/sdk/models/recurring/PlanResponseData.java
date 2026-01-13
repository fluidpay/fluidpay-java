package com.fluidpay.sdk.models.recurring;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanResponseData{
    private String id;
    private String name;
    private String description;
    private int amount;
    private int percentage;
    @JsonProperty("billing_cycle_interval")
    private int billingCycleInterval;
    @JsonProperty("billing_frequency")
    private String billingFrequency;
    @JsonProperty("billing_days")
    private String billingDays;
    @JsonProperty("total_add_ons")
    private int totalAddOns;
    @JsonProperty("total_discounts")
    private int totalDiscounts;
    private int duration;
    @JsonProperty("add_ons")
    private RecurrenceResponseData[] addOns;
    private RecurrenceResponseData[] discounts;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public int getBillingCycleInterval() {
        return billingCycleInterval;
    }

    public String getBillingFrequency() {
        return billingFrequency;
    }

    public String getBillingDays() {
        return billingDays;
    }

    public int getTotalAddOns() {
        return totalAddOns;
    }

    public int getTotalDiscounts() {
        return totalDiscounts;
    }

    public int getDuration() {
        return duration;
    }

    public RecurrenceResponseData[] getAddOns() {
        return addOns;
    }

    public RecurrenceResponseData[] getDiscounts() {
        return discounts;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
