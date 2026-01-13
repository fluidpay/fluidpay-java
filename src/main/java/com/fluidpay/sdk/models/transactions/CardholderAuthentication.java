package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardholderAuthentication {
    private String condition;
    private String eci;
    private String cavv;
    private String xid;

    public CardholderAuthentication(String condition, String eci, String cavv, String xid) {
        this.condition = condition;
        this.eci = eci;
        this.cavv = cavv;
        this.xid = xid;
    }
}
