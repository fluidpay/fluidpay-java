package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TerminalPayment {
    private TerminalRequest terminal;

    public TerminalPayment(TerminalRequest terminal) {
        this.terminal = terminal;
    }
}
