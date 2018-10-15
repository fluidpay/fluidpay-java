package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AchTransactionRequest implements TransactionRequest{
    private String type;
    private int amount;
    @JsonProperty("tax_exempt")
    private boolean taxExempt;
    @JsonProperty("tax_amount")
    private int taxAmount;
    @JsonProperty("shipping_amount")
    private int shippingAmount;
    private String currency;
    private String description;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("po_number")
    private String poNumber;
    @JsonProperty("ip_address")
    private String ipAddress;
    @JsonProperty("email_reciept")
    private boolean emailReciept;
    @JsonProperty("email_address")
    private String emailAddress;
    @JsonProperty("payment_method")
    private AchPayment paymentMethod;
    @JsonProperty("billing_address")
    private Address billingAddress;
    @JsonProperty("shipping_address")
    private Address shippingAddress;

    public AchTransactionRequest(String type, int amount, boolean taxExempt, int taxAmount, int shippingAmount, String currency, String description, String orderId, String poNumber, String ipAddress, boolean emailReciept, String emailAddress, AchPayment paymentMethod, Address billingAddress, Address shippingAddress) {
        this.type = type;
        this.amount = amount;
        this.taxExempt = taxExempt;
        this.taxAmount = taxAmount;
        this.shippingAmount = shippingAmount;
        this.currency = currency;
        this.description = description;
        this.orderId = orderId;
        this.poNumber = poNumber;
        this.ipAddress = ipAddress;
        this.emailReciept = emailReciept;
        this.emailAddress = emailAddress;
        this.paymentMethod = paymentMethod;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }
}
