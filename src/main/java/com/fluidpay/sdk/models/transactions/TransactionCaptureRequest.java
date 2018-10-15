package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * request to capture a transaction
 */
public class TransactionCaptureRequest {
    private int amount;
    @JsonProperty("tax_amount")
    private int taxAmount;
    @JsonProperty("tax_exempt")
    private boolean taxExempt;
    @JsonProperty("shipping_amount")
    private int shippingAmount;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("po_number")
    private String poNumber;
    @JsonProperty("ip_address")
    private String ipAddress;

    public TransactionCaptureRequest(int amount, int taxAmount, boolean taxExempt, int shippingAmount, String orderId, String poNumber, String ipAddress) {
        this.amount = amount;
        this.taxAmount = taxAmount;
        this.taxExempt = taxExempt;
        this.shippingAmount = shippingAmount;
        this.orderId = orderId;
        this.poNumber = poNumber;
        this.ipAddress = ipAddress;
    }
}
