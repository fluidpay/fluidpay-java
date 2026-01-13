package com.fluidpay.sdk.models.transactions;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionResponseData{
    private String id;
    private String type;
    private int amount;
    @JsonProperty("tip_amount")
    private int tipAmount;
    @JsonProperty("tax_amount")
    private int taxAmount;
    @JsonProperty("tax_exempt")
    private boolean taxExempt;
    @JsonProperty("shipping_amount")
    private int shippingAmount;
    private String currency;
    private String description;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("po_number")
    private String poNumber;
    @JsonProperty("ip_addrss")
    private String ipAddress;
    @JsonProperty("email_receipt")
    private boolean emailReceipt;
    @JsonProperty("email_address")
    private String emailAddress;
    @JsonProperty("payment_method")
    private String paymentMethod;
    private TransactionResponseBody response;
    private String status;
    @JsonProperty("billing_address")
    private Address billingAddress;
    @JsonProperty("shipping_address")
    private Address shippingAddress;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public int getTipAmount() {
        return tipAmount;
    }

    public int getTaxAmount() {
        return taxAmount;
    }

    public boolean isTaxExempt() {
        return taxExempt;
    }

    public int getShippingAmount() {
        return shippingAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public boolean isEmailReceipt() {
        return emailReceipt;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public TransactionResponseBody getResponse() {
        return response;
    }

    public String getStatus() {
        return status;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
