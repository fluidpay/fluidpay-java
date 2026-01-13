package com.fluidpay.sdk.models.recurring;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionResponseData {
    private String id;
    @JsonProperty("plan_id")
    private String planId;
    private String status;
    private String description;
    private IdData customer;
    private int amount;
    @JsonProperty("total_adds")
    private int totalAdds;
    @JsonProperty("total_discounts")
    private int totalDiscounts;
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
    private RecurrenceResponseData[] addOns;
    private RecurrenceResponseData[] discounts;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;

    public String getId() {
        return id;
    }

    public String getPlanId() {
        return planId;
    }

    public String getDescription() {
        return description;
    }

    public IdData getCustomer() {
        return customer;
    }

    public int getAmount() {
        return amount;
    }

    public int getTotalAdds() {
        return totalAdds;
    }

    public int getTotalDiscounts() {
        return totalDiscounts;
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

    public int getDuration() {
        return duration;
    }

    public String getNextBillDate() {
        return nextBillDate;
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
