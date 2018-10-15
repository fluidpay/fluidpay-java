package com.fluidpay.sdk.models.recurring;

/**
 * request to create or update an add on with amount
 */
public class RecurrenceAmountRequest implements RecurrenceRequest {
    private String name;
    private String description;
    private int amount;
    private int duration;

    public RecurrenceAmountRequest(String name, String description, int amount, int duration) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.duration = duration;
    }
}
