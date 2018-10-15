package com.fluidpay.sdk.models.recurring;

/**
 * if you don't want to change the attributes of the original
 * enter the old data
 */
public class OptionalRecurringAmountRequest implements OptionalRecurringRequest{
    private String id;
    private String name;
    private String description;
    private int amount;
    private int duration;

    public OptionalRecurringAmountRequest(String id, String name, String description, int amount, int duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.duration = duration;
    }
}
