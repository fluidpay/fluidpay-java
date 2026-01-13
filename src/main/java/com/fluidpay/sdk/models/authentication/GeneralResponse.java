package com.fluidpay.sdk.models.authentication;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * response with empty data
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneralResponse {
    private String status;
    private String msg;
    private String data;

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
