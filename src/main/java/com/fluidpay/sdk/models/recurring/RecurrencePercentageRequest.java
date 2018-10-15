package com.fluidpay.sdk.models.recurring;

/**
 * request to create or update an add on with percentage
 */
public class RecurrencePercentageRequest implements RecurrenceRequest{
    private String name;
    private String description;
    private int percentage;
    private int duration;

    public RecurrencePercentageRequest(String name, String description, int percentage, int duration) {
        this.name = name;
        this.description = description;
        this.percentage = percentage;
        this.duration = duration;
    }
}
