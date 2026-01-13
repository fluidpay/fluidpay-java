package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AchPayment {
    private AchRequest ach;

    public AchPayment(AchRequest ach) {
        this.ach = ach;
    }
}
