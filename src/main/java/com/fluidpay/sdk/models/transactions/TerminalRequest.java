package com.fluidpay.sdk.models.transactions;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TerminalRequest {
    private String id;
    @JsonProperty("expiration_date")
    private String expirationDate;
    private String cvc;
    @JsonProperty("print_receipt")
    private String printReceipt;
    @JsonProperty("signature_required")
    private boolean signatureRequired;

    public TerminalRequest(String id, String expirationDate, String cvc, String printReceipt, boolean signatureRequired) {
        this.id = id;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
        this.printReceipt = printReceipt;
        this.signatureRequired = signatureRequired;
    }
}
