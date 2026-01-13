package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StringQuery {
    private String operator;
    private String value;

    public StringQuery(String operator, String value) {
        this.operator = operator;
        this.value = value;
    }
}
