package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountholderAuthentication {
    @JsonProperty("dl_state")
    private String dlState;
    @JsonProperty("dl_number")
    private String dlNumber;

    public AccountholderAuthentication(String dlState, String dlNumber) {
        this.dlState = dlState;
        this.dlNumber = dlNumber;
    }
}
