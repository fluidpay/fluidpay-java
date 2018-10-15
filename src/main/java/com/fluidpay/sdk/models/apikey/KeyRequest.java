package com.fluidpay.sdk.models.apikey;

public class KeyRequest {
    private String type;
    private String name;

    public KeyRequest(String type, String name) {
        this.type = type;
        this.name = name;
    }
}
