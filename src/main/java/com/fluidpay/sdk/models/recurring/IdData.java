package com.fluidpay.sdk.models.recurring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IdData {
    private String id;

    public IdData() {
    }

    public IdData(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
