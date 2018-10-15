package com.fluidpay.sdk.models.recurring;

public class OptionalRecurringPercentageRequest implements OptionalRecurringRequest {
    private String id;
    private String name;
    private String description;
    private int percentage;
    private int duration;

    public OptionalRecurringPercentageRequest(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
