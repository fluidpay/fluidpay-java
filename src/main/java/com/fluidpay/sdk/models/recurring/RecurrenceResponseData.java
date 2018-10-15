package com.fluidpay.sdk.models.recurring;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecurrenceResponseData{
    private String id;
    private String name;
    private String description;
    private int amount;
    private int percentage;
    private int duration;
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

    public int getPercentage() {
        return percentage;
    }

    public int getDuration() {
        return duration;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
