package com.fluidpay.sdk.models.transactions;

public class IntQuery {
    private String operator;
    private int value;

    public IntQuery(String operator, int value) {
        this.operator = operator;
        this.value = value;
    }
}
