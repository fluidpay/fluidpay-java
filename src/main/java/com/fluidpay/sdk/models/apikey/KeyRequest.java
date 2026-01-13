package com.fluidpay.sdk.models.apikey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyRequest {
    private String type;
    private String name;

    public KeyRequest(String type, String name) {
        this.type = type;
        this.name = name;
    }
}
